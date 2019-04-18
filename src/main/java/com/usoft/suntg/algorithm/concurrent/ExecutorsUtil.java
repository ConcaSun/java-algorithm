package com.usoft.suntg.algorithm.concurrent;

import com.usoft.suntg.algorithm.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.*;

/**
 * @author suntg
 * @date ${date}
 */
public class ExecutorsUtil {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static final String FILE_PATH = "/mnt/data/test";

    public static void createDataFile(int threadCount, int dataCountPerFile, int endFileIndex) throws InterruptedException, ExecutionException {
        CompletionService completionService = new ExecutorCompletionService(executorService);
        File dir = new File(FILE_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        FileUtils.deleteSubFiles(dir);
        for (int i = 1; i <= threadCount; i ++) {
            completionService.submit(getTask(i, threadCount, endFileIndex, dataCountPerFile, dir));
        }
        waitCompletion(completionService, threadCount);
    }

    private static void waitCompletion(CompletionService completionService, int threadCount) throws InterruptedException, ExecutionException {
        for (int i = 0; i < threadCount; i ++) {
            Future<Long> future = completionService.take();
            future.get();
        }
    }

    private static Callable getTask(int threadIndex, int threadCount, int endFileIndex, int dataCount, File dataDir) {
        return ()->{
            long startTime = System.currentTimeMillis();
            int fileNameIndex = threadIndex;
            while (fileNameIndex <= endFileIndex) {
                File file = new File(dataDir, fileNameIndex + ".txt");
                int startId = (fileNameIndex - 1) * dataCount + 1;
                writeIdToFile(startId, dataCount, file);
                fileNameIndex += threadCount;
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        };
    }

    public static void writeIdToFile(int startId, int count, File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < count; i ++) {
            printWriter.write("{\"id\":" + startId + ",\"title\":\"这是第" + startId + "条数据\"}\n");
            startId ++;
        }
        printWriter.flush();
        printWriter.close();
    }
}
