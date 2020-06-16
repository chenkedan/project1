package com.leetcode.demo.project.list;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返下·。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {


    public static int getStr(String str){
        int maxSize = 0;
        int [] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i=0;
        while(key < str.length()){
            i = str.charAt(key);
            if(dict[i] > base)
                base = dict[i];
            dict[i] = key+1; //以1作为起始位置，下标加1
            maxSize = (maxSize>key-base+1)?maxSize:key-base+1;
            key++;
        }
        return maxSize;

    }
    public static void main(String[] args){

        String ss = "abcsdfgaddsssvbnmlkjhgfd";
        System.out.println(Solution3.getStr(ss));
    }

}
