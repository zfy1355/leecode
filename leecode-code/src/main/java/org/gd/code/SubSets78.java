package org.gd.code;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class SubSets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> data = new ArrayList<List<Integer>>();
        for(int i=0;i<=nums.length;i++){
            subsets(nums,new ArrayList<Integer>(),i,0,data);
        }
        return data;
    }

    /**
     * 回溯法
     * 1、 针对所给问题，定义问题的解空间，它至少包含问题的一个（最优）解。
     * 2 、确定易于搜索的解空间结构,使得能用回溯法方便地搜索整个解空间 。
     * 3 、以深度优先的方式搜索解空间，并且在搜索过程中用剪枝函数避免无效搜索。
     * @param nums
     * @param path
     * @param k
     * @param s
     * @param data
     */
    private void subsets(int[] nums, ArrayList<Integer> path, int k, int s, List<List<Integer>> data) {
        if(k == 0){
            data.add(new ArrayList<Integer>(path));
        }else{
            for(int i=s;i<=nums.length-k;i++){
                path.add(nums[i]);
                subsets(nums,path,k-1,i+1,data);
                path.remove(path.size()-1);
            }
        }
    }

    /**
     * 动态规划：若要解一个给定问题，我们需要解其不同部分（即子问题），再合并子问题的解以得出原问题的解。
     * 通常许多子问题非常相似，为此动态规划法试图仅仅解决每个子问题一次，从而减少计算量： 一旦某个给定子
     * 问题的解已经算出，则将其记忆化存储，以便下次需要同一个子问题解之时直接查表。
     * https://blog.csdn.net/qq_1932568757/article/details/82725132
     * @param nums
     * @return
     */
    public List<List<Integer>> subSet2(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<List> temResult = new ArrayList<List>();
        List list = new ArrayList();
        // 设置初始条件
        result.add(list);
        for(int i = 0; i < nums.length; i++){
            temResult.clear();
            int len = result.size();
            for(int j = 0; j < len; j++){
                List item = new ArrayList<>(result.get(j));
                item.add(nums[i]);
                temResult.add(item);
            }
            //将新产生的子集添加到结果集中
            for(int k =0; k < temResult.size(); k++){
                result.add(temResult.get(k));
            }

        }
        return result;
    }

    public List<List<Integer>> subSet(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length;j>i;j--){
                List<Integer> tempList = new ArrayList<Integer>();
                int[] temp = Arrays.copyOfRange(nums,i,j);
                tempList.addAll(Ints.asList(temp));
                res.add(tempList);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] data = {1,2,3};
        System.out.println(new SubSets78().subSet2(data));
    }
}
