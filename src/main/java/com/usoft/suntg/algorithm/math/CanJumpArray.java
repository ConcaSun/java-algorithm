package com.usoft.suntg.algorithm.math;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * 题目：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 分析：
 * 只有数组中第一个
 *
 * @author suntg
 */
public class CanJumpArray {

    public static boolean canJump(int[] array) {
        if (array.length <= 1) {
            // 数组只有一个元素，一定可以到达
            return true;
        } else {
            // 数组长度大于1
            for (int i = 0; i < array.length-1; i ++) {
                int a = array[i];
                if (i == 0 && a == 0) {
                    // 第一个数为0，一定不可到达
                    return false;
                } else {
                    // 只有某一个数为0，才会出现不能到达
                    // 并且他前面的所有数都不能跳到这个数后面
                    if (a == 0) {
                        boolean result = false;
                        for (int j = i - 1; j >= 0; j --) {
                            if (array[j] > (i - j)) {
                                result =  true;
                                continue;
                            }
                        }
                        if (!result) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
