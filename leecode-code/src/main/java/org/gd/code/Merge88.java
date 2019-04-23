package org.gd.code;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k =0;
        while(i>=0 && j >= 0){
            if(nums1[i]>nums2[j]){
                nums1[m+n-1-k] = nums1[i];
                i--;
            }else{
                nums1[m+n-1-k] =nums2[j];
                j--;
            }
            k++;
        }
        while(j>=0){
            nums1[m+n-1-k] = nums2[j];
            j--;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Merge88().merge(nums1,3,nums2,3);
        System.out.println(nums1);
    }
}
