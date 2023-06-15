package 数据结构与算法.com.lz.二分查找;

import java.util.Arrays;

public class BinarySearch {
	
	public static void main(String[] args) {
		
		int[] arry = {-1,2,3,4,13,23,34,45};
		int[] arry2 = {23,13,4,3,2,1,0};
		int[] arry3 = {2,3,4,4,13,23,34,34,45};
		int target = -1;
		int i = Integer.MAX_VALUE-1;
//		System.out.println(i);
//		System.out.println(binarySearc(arry, 0,arry.length-1,target));
//		System.out.println(binarySearc(arry2, 0,arry.length-1,target));
//		System.out.println(binarySearch3(arry, target));
//		System.out.println(Arrays.binarySearch(arry, target));
		System.out.println(binarySearch(arry,target));
//		System.out.println(binarySearchLeftmost1(arry3, target));
	}
	
	// 二分查找基础版
	public static int binarySearch(int[] arr, int target) {
		int i = 0,j = arr.length-1;
		while(i <= j) {
			int m = (i+j)>>>1;
			if(arr[m] < target) {
				i = m+1;
			}else if(arr[m] > target) {
				j = m-1;
			}else {
				return m;
			}
		}
		return -1;
	}
	
	/**
	 * 二分查找递归
	 * @param arry 待查找的升序数组
	 * @param target 待查找的目标值
	 * @return 找到返回索引，否则返回-1
	 */
	
	public static int binarySearc(int[] arr,int i,int j,int target) {
		if(i>j) {
			return -1;
		}
		int m = (i+j)>>>1;
		if(arr[i] < arr[j]) { // // 升序
			if (target > arr[m]) {
				return binarySearc(arr, m+1, j, target);
			}else if(target < arr[m]) {
				return binarySearc(arr, i, j-1, target);
			} else {
				return m;
			}
		}else { // 降序
			if (target > arr[m]) {
				return binarySearc(arr, i,m-1, target);
			} else if (target < arr[m]) {
				return binarySearc(arr, m+1, j, target);
			} else {
				return m;
			}
		}
	}
	
	/*
	 * 1.左闭右开的区间，i指向的可能是目标，而j指向的不是目标
	 * 2.不在循环内找出，等范围只剩下i时，退出循环，在循环外比较a[i]与target
	 * 3.循环内的平均比较次数减少了
	 * 4.时间复炸度 O(log(n))
	 */
	public static int binarySearch3(int[] arr, int target) {
		int i = 0, j = arr.length;
		while(1 < j - i) {
			int m = (i + j) >>> 1;
			if(target < arr[m]) {
				j = m;
			}else {
				i = m;
			}
		}
		if (target == arr[i]) {
			return i;
		}else {
			return -1;
		}
	}
	
	
	
}
