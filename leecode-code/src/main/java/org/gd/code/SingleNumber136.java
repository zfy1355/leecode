package org.gd.code;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        if(nums.length<1){
            return nums[0];
        }
        for(int i=1;i<nums.length;i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] data = {4,1,2,1,2};
        System.out.println(new SingleNumber136().singleNumber(data));
        System.out.println(4^1^1);
    }
}
