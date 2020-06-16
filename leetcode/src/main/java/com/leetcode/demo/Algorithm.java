package com.leetcode.demo;

public class Algorithm {


    public static int[] bubbling(int[] arr){
        for (int i=0;i<arr.length-1;i++){


            for (int j= i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void quickSort(int[] arr,int left,int right){

        if (left<right){
            int i = left;
            int j = right;
            int temp = arr[left];
            while (i<j){
                while (i<j && arr[j]>temp){
                    j--;
                }
                if (i<j){
                    arr[i++] = arr[j];
                }
                while (i<j && arr[i]<temp){
                    i++;
                }
                if (i<j){
                    arr[j--] = arr[i];
                }

            }
            arr[i] = temp;
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }

    }

    public static void selectSort(int[] arr){

        for (int i =0;i<arr.length-1;i++){

            int index = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[index]){
                    index = j;
                }
            }
            if (i!=index){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

    }

    public static void main(String[] args){
        int[] arr ={88,1,5,2,2,7,9,3,4,88};
        //int[] bu = quick_sort(arr,0,6);
        //quickSort(arr,0,arr.length-1);
        selectSort(arr);
        for (int i : arr){
            System.out.println(i);
        }

    }
}
