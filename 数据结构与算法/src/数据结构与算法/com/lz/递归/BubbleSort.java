package 数据结构与算法.com.lz.递归;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] array = {3,2,5,1,6};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] array) {
		bubble(array,array.length - 1);
	}
	
	private static void bubble(int[] array,int n) {
		if(n == 0) {
			return;
		}
		int x = 0;
		for(int i =0;i < n;i++) {
			if(array[i] > array[i+1]) {
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				x = i;
			}
		}
		bubble(array, x);
	}
	
	
}
