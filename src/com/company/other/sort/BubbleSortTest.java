package com.company.other.sort;

import java.util.Arrays;

// 冒泡算法
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] L = new int[]{5,3,9,1,2};
        fun1(L);
        System.out.println("fun1:"+Arrays.toString(L));

        L = new int[]{9,1,5,8,3,7,4,6,2};
        fun2(L);
        System.out.println("fun2:"+Arrays.toString(L));

        L = new int[]{9,1,5,8,3,7,4,6,2};
        fun3(L);
        System.out.println("fun2:"+Arrays.toString(L));

        int target = 3;
        System.out.println(target+"的Index:"+BinarySearch(L, target));

        System.out.println(target+"的Index:"+BinarySearchREC(L, 0, L.length-1, target)+" 递归实现");
    }

    // 非递归二分查找
    static int BinarySearch(int[] L, int key){
        int low = 0;
        int high = L.length;
        while(low <= high){
            int mid = (high-low)/2+low;
            if (L[mid] > key){
                high = mid-1;
            }
            else if (L[mid] < key){
                low = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    // 二分查找-递归实现
    static int BinarySearchREC(int[] L, int low, int high, int target){
        if (low > high) return -1;
        int mid = (high-low)/2+low;
        if (L[mid] > target){
            return BinarySearchREC(L, low, mid-1, target);
        }else if(L[mid] < target){
            return BinarySearchREC(L, mid+1,high,target);
        }
        return mid;
    }

    // 初阶冒泡算法
    // 算法思想是：round1 让i=0，不断的跟后面的值比较并交换，直到最小
    //            round2 让i=1，不断的比较交换，直到最小
    //            最后数组会从升序排序
    static void fun1(int[] L){
        for (int i = 0;i<L.length-1;i++){
            for (int j=i+1;j<L.length;j++){
                if (L[i] > L[j]){
                    swap(L, i, j);
                }
            }
        }
    }

    // 正宗的冒泡算法
    // i表示的也是轮次，round1 两两比较交换确定 L[0] 为最小
    //                 round2 确定L[1] 为第二小
    //                 降序
    //                 边界为   < L.length -1
    static void fun2(int[] L){
//        System.out.println("fun2:"+Arrays.toString(L));
        for (int i =0; i<L.length-1;i++){   // i标识轮多少次   i< L.length
            for (int j=L.length-1;j>i;j--){ //  j = L.length
                if (L[j-1] > L[j]){
                    swap(L, j-1,j);
                }
            }
        }
    }

    // 优化过的冒泡算法，减少不必要的循环
    // 用flag标记是否还要继续循环
    // 如果一轮比较中，没有任何的交换那就证明数组已经有序了，不用再继续循环了
    static void fun3(int[] L){
        boolean flag = true;
        for (int i =0; i<L.length-1 && flag ;i++){   // i标识轮多少次   i< L.length
            flag = false;
            for (int j=L.length-1;j>i;j--){ //  j = L.length
                if (L[j-1] > L[j]){
                    swap(L, j-1,j);
                    flag = true;
                }
            }
        }
    }

    static void swap(int[] L, int i, int j){
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;
    }
}
