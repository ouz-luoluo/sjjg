package 数据结构与算法.com.lz.数组;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

// 动态数组
public class DynamicArray implements Iterable<Integer>{
	
	private int size = 0; // 逻辑大小
	
	private int capacity = 8;// 容量
	
	private int[] array= new int[capacity];
	
	
	/**
	 * 向最后位置[size]添加元素
	 * @param element 待添加元素
	 */
	public void addList(int element) {
		add(size,element);
	}
	
	/**
	 * 向[0...size]添加元素
	 * @param index 索引位置
	 * @param element 待添加元素
	 */
	public void add(int index, int element) {
		if(index >= 0 && index < size) {
			/**
			 * 2、参数分析
				Object src : 原数组
				int srcPos : 从元数据的起始位置开始
				Object dest : 目标数组
				int destPos : 目标数组的开始起始位置
				int length : 要copy的数组的长度
				System.arraycopy(src, srcPos, dest, destPost, length);
			 */
			System.arraycopy(array, index, array, index +1, size - index);
		}
		array[index] = element;
		size++;
	}
	
	/**
	 * 查询元素
	 * @param index -索引位置，在[0...size]区间内
	 * @return 该索引位置元素
	 */
	public int get(int index) { // [0...size]
		if (index < 0 || size-1 < index) {
			return -1;
		}
		return array[index];
	}
	
	/**
	 * 遍历方法一
	 * @param consumer 遍历要执行的参数，入参:每个元素
	 */
	public void foreach(Consumer<Integer> consumer) {
		for(int i=0;i<size;i++) {
//			System.out.println(array[i]);
			// 提供array[i]
			// 返回void
			consumer.accept(array[i]);
		}
	}

	/**
	 * 遍历方法二 迭代器遍历
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int i = 0;

			@Override
			public boolean hasNext() { // 有没有下一个元素
				return i<size;
			}

			@Override
			public Integer next() { // 返回当前元素，并移动到下一个元素
				return array[i++];
			}
			
		};
	}
	
	/**
	 * 遍历方法三 stream流遍历
	 * @return
	 */
	public IntStream stream() {
		return IntStream.of(Arrays.copyOfRange(array, 0, size));
	}
	
	
	public int remove(int index) {
		int removed = array[index];
		System.arraycopy(array, index-1, array, index, size-index-1);
		size--;
		return removed;
	}

	public static void main(String[] args) {
		DynamicArray dynamicArray = new DynamicArray();
		dynamicArray.addList(1);
		dynamicArray.addList(2);
		dynamicArray.addList(3);
		dynamicArray.addList(4);
		dynamicArray.addList(5);
//		System.out.println(dynamicArray.get(0));
//		System.out.println(dynamicArray.get(-1));
//		System.out.println(dynamicArray.get(4));
		
//		dynamicArray.forEach(element->{
//			System.out.println(element);
//		});
		
//		for(Integer emelent : dynamicArray) { //hasNext() nex()
//			System.out.println(emelent);
//		}
		
//		dynamicArray.stream().forEach(element->{
//			System.out.println(element);
//		});
		
  	}

}
