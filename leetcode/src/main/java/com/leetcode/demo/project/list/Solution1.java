package com.leetcode.demo.project.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class Solution1 {

    public static Map twoSum(int[] nums,int target ){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i =0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    map.put(i,j);
                }
            }

        }


        return map;
    }

    public static int[] twoSums(int[] nums,int target){

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int j = 0;j<nums.length;j++){
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) !=j){
                return new int[]{j,map.get(complement)};
            }
        }
        return null;
    }



    public static void main(String[] args){
        int nums[] = {1,2, 7,8, 11, 15};
        int target = 9;
        int[] map = Solution1.twoSums(nums,target);
        for (int i : map){
            System.out.println(i);
        }
        System.out.println(map.toString());
    }
}
