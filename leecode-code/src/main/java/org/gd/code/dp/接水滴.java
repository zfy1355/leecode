package org.gd.code.dp;

/**
 * 接水滴
 */
public class 接水滴 {
    /**
     * 双指针求值
     * @param height
     * @return
     */
    public static int trap(int[] height) {

        int left_max=0,right_max=0;
        int left=0,right=height.length-1;
        int sum=0;
        while(left<right){
            if(height[left]<height[right]){
                //如果大于此时最大值重新赋值
                if(height[left]>left_max){
                    left_max=height[left];
                }
                else{
                    //或者把当前两个值相减得到当前峰值
                    sum+=left_max-height[left];
                }
                left++;
            }
            else{
                if(height[right]>right_max){right_max=height[right];}
                else{
                    sum+=right_max-height[right];
                }
                right--;
            }
        }
        return sum;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int  trap2(int[] height){
        int sum = 0;
        for(int i = 0; i < height.length; i++){
            if(i == 0 || i == height.length - 1){
                continue;
            }
            //记录左边和右边柱子的最高高度，初始化为当前柱子高度
            int rHeight = height[i];
            int lHeight = height[i];
            //右柱子
            for(int r = i + 1; r < height.length; r++){
                if(height[r] > rHeight){
                    rHeight = height[r];
                }
            }
            //左柱子
            for(int l = i - 1; l >= 0 ; l--){
                if(height[l] > lHeight){
                    lHeight = height[l];
                }
            }
            int h = Math.min(lHeight,rHeight) - height[i];
            if(h > 0) {
                sum += h;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] shuidi = {1,3,5,2,4,2,9,2,7,8,5,4,2,2};
        System.out.println(trap(shuidi));
        System.out.println(trap2(shuidi));
    }
}
