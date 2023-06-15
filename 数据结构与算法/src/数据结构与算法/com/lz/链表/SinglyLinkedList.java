package 数据结构与算法.com.lz.链表;

import java.util.Iterator;
import java.util.function.Consumer;

import javax.crypto.Cipher;

//单向链表
public class SinglyLinkedList { //整体
	
	private Node head = null; // 头指针
	
	
	// 节点类
	private static class Node{
		int value; // 值
		Node next; // 下一个节点的指针

		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	/**
	 * 向链表
	 * @param value 待添加的值
	 */
	public void addFirst(int value) {
		// 1.链表为空
//		head = new Node(value, null);
		// 2.链表非空
		head = new Node(value, head);
	}
	
	// 遍历链表1
	public void loop(Consumer<Integer> consumer) {
		Node p = head;
		while(p != null) {
			consumer.accept(p.value);
			p = p.next;
		}
	}
	
	// 遍历链表2
	public void loop2() {
		for(Node pNode=head; pNode!=null;pNode=pNode.next) {
			System.out.println(pNode.value);
		}
	}
	
	// 遍历到最后节点
	private Node findList() {
		if (head == null) {
			return null;
		}
		Node p = head;
		while(p.next != null ) {
			p = p.next;
		}
		return p;
	}
	
	//向链表尾部添加
	public void addLast(int value) {
		Node last = findList();
		if (last == null) {
			addFirst(value);
			return;
		}
		last.next = new Node(value, null);
	}
	
	public void test() {
		int i = 0;
		for(Node p = head;p != null;p = p.next, i++) {
			System.out.println(p.value+" 索引:"+i);
		}
	}
	
	// 找到目标索引下的节点
	private Node findNode(int index) {
		int i = 0;
		Node p = head;
//		if(index == 0) {
//			return p;
//		}
		while(p != null) {
			if(i == index) {
				return p;
			}
			p = p.next;
			i++;
		}
 		return null; // 没找到
	}
	
	/**
	 * 根据索引查找
	 * @param index 索引
	 * @return 找到，返回该索引位置节点的值
	 * Throw IllegalArgumentException 找到，抛出index
	 */
	public int get(int index) {
		Node node = findNode(index);
		if(node == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		return node.value;
	}
	
	/**
	 * 向索引位置插入
	 * @param index 索引
	 * @param value 待插入值
	 * Throw IllegalArgumentException 找到，抛出index
	 */
	public void insert(int index, int value) {
		if(index == 0) {
			addFirst(value);
			return;
		}
		Node prev = findNode(index - 1);// 找到上一个节点
		if(prev == null) { // 找不到
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		prev.next = new Node(value, prev.next);
	}
	
	// 删除第一个节点
	public void removeList() {
		if(head.next == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n"));
		}
		head = head.next;
	}
	
	public void remove(int index) {
		if(index == 0) {
			removeList();
			return;
		}
		Node prev = findNode(index - 1);
		if(prev == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		Node remove = prev.next;
		if (remove == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		prev.next = remove.next;
		
	}
	
	// 遍历链表3
	public void loop3() {
		recursion(head);
	}
	
	// 递归遍历
	private void recursion(Node curr) { // 某个节点要进行的操作
		if (curr == null) {
			return;
		}
		System.out.println(curr.value);
		recursion(curr.next);
	}
	
	
	
	public static void main(String[] args) {
		SinglyLinkedList list = new  SinglyLinkedList();
//		list.addFirst(1);
//		list.addFirst(2);
//		list.addFirst(3);
//		list.addFirst(4);
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
//		list.test();
		
		//list.insert(4, 10);// 插入
		list.remove(1);
		
//		list.loop(value->{
//			System.out.println(value);
//		});
//		System.out.println("---------");
		list.loop3();
//		System.out.println(list.get(0));
		
		
	}
}


