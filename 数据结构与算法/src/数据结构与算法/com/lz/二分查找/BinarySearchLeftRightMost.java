package 数据结构与算法.com.lz.二分查找;

public class BinarySearchLeftRightMost {
	
	/**
	 * 二分查找 leftmost
	 * @param arr 待查找的升序数组
	 * @param target 待查找目标值
	 * @return 找到返回索引，否则返回-1;
	 */
	public static int binarySearchLeftmost1(int[] arr, int target) {
		int i=0,j=arr.length-1;
		int candidata = -1; // 候选
		while(i<=j) {
			int m = (i+j)>>>1;
			if(target < arr[m]) {
				j = m-1;
			}else if(target > arr[m]) {
				i = m+1;
			}else {
				// 记录候选数
				candidata = m;
				j = m-1;
			}
		}
		return candidata;
	}
	
	/**
	 * 二分查找 rightmost
	 * @param arr 待查找的升序数组
	 * @param target 待查找目标值
	 * @return 找到返回索引，否则返回-1;
	 */
	public static int binarySearchRightmost1(int[] arr, int target) {
		int i=0,j=arr.length-1;
		int candidata = -1; // 候选
		while(i<=j) {
			int m = (i+j)>>>1;
			if(target < arr[m]) {
				j = m-1;
			}else if(target > arr[m]) {
				i = m+1;
			}else {
				// 记录候选数
				candidata = m;
				i = m+1;
			}
		}
		return candidata;
	}
	
	/**
	 * 二分查找 leftmost
	 * @param arr 待查找的升序数组
	 * @param target 待查找数值
	 * @return 返回 >=target的最靠左索引
	 */
	public static int binarySearchLeftmost2(int[]arr, int target) {
		int i=0,j=arr.length-1;
		while(i<=j) {
			int m = (i+j)>>>1;
			if(target <= arr[m]) {
				j = m-1;
			}else {
				i = m+1;
			}
		}
		return i;
	}
	
	/**
	 * 二分查找 rightmost
	 * @param arr 待查找的升序数组
	 * @param target 待查找数值
	 * @return 返回 <=target的最靠右索引
	 */
	public static int binarySearchRightmost2(int[]arr, int target) {
		int i=0,j=arr.length-1;
		while(i<=j) {
			int m = (i+j)>>>1;
			if(target < arr[m]) {
				j = m-1;
			}else {
				i = m+1;
			}
		}
		return i - 1;
	}
	
}
