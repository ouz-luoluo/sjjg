package 数据结构与算法.com.lz.数组;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Array1 {
	
	public static void main(String[] args) {
		int[] arr = {20,1,2,3,5,6,};
		int target = 10;
		// 添加
//		arr = add(arr,target);
//		System.out.println(Arrays.toString(arr));
		// 删除
//		arr = remove(arr, 3);
		// 插入
		arr = insert(arr, 1, 10);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * 添加
	 * @param arr 原数组
	 * @param target 目标值
	 * @return 新数组
	 */
	public static int[] add(int[] arr,int target) {
		//创建一个新数组，其长度为老数组的加一
		int[] newArray = new int[arr.length+1];
		for(int i = 0;i<arr.length;i++) {
			newArray[i] = arr[i];
		}
		//将目标元素加入到新数组当中
		newArray[arr.length] = target;//此处arry.lenth是新数组的最后后一个元素，为什么？第一个元素从零开始算起
		return newArray;
	}
	
	/**
	 * 删除
	 * @param arr 原数组
	 * @param index 目标索引
	 * @return 新数组
	 */
	public static int[] remove(int[] arr, int index) {
		//新建一个数组
		int[] newArray = new int[arr.length - 1];
		//弄一个循环，，将原数组符合条件的加进新数组当中
		for (int i = 0; i < newArray.length; i++) {
			System.out.println(i +"---"+index+"---"+arr[i]);
			if(i < index) {
				newArray[i] = arr[i];//在下标元素之前
			}else {
				newArray[i] = arr[i+1];//下标元素之后
			}
		}
		return newArray;
	}
	
	/**
	 * 插入
	 * @param arr 原数组
	 * @param index 目标索引
	 * @param target 目标值
	 * @return 新数组
	 */
	public static int[] insert(int[] arr, int index, int target) {
		//再创建一个新数组，并且将其长度设置为原数组的长度加一
		int[] newArray = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			//接下来对原数组的元素进行筛选操作
			if(i < index) {
				newArray[i] = arr[i];
			}else {
				 //当i=时，将其空出。之后的位置继续由原数组复制添加进来
				newArray[i+1] = arr[i];
			}
		}
		 //将新数组下标为index的空元素进行填补。就是插入操作
		newArray[index] = target;
		return newArray;
	}
	
	
}