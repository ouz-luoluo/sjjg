package 数据结构与算法.com.lz.链表;

import java.util.Iterator;



// 环形链表
public class AnnularLinkedList implements Iterable<Integer> {
	
	private static class Node{
		Node prev;
		int value;
		Node next;
		public Node(Node prev, int value, Node next) {
			super();
			this.prev = prev;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node sentinel = new Node(null, -1, null);
	
	public AnnularLinkedList() {
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}
	
	public void addFirst(int value) {
		Node aNode = sentinel;
		Node bNode = sentinel.next;
		Node addedNode = new Node(aNode, value, bNode);
		aNode.next = addedNode;	
		bNode.prev = addedNode;
	}
	
	public void addLasst(int value) {
		Node aNode = sentinel.prev;
		Node bNode = sentinel;
		Node addendNode = new Node(aNode, value, bNode);
		aNode.next = addendNode;
		bNode.prev = addendNode;
	}
	
	public void removeFirst() {
		Node removeNode = sentinel.next;
		if(removeNode == sentinel) {
			throw new IllegalArgumentException("没有可删除的节点了");
		}
		Node aNode = sentinel;
		Node bNode = removeNode.next;
		aNode.next = bNode;
		bNode.prev = aNode;
	}
	
	public void removeLast() {
		Node removeNode = sentinel.prev;
		if(removeNode == sentinel) {
			throw new IllegalArgumentException("没有可删除的节点了");
		}
		Node aNode = removeNode.prev;
		Node bNode = sentinel;
		aNode.next = bNode;
		bNode.prev = aNode;
	}
	
	private Node findByValue(int value) {
		Node pNode = sentinel.next;
		while(pNode != sentinel) {
			if (pNode.value == value) {
				return pNode;
			}
			pNode = pNode.next;
		}
		return null;
		
	}
	
	// 根据值删除
	public void removeByValue(int value) {
		Node pNode = findByValue(value);
		if (pNode == null) {
			throw new IllegalArgumentException("没有对应value值的节点");
		}
		Node aNode = pNode.prev;
		Node bNode = pNode.next;
		aNode.next = bNode;
		bNode.prev = aNode;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			Node p = sentinel.next;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return p != sentinel;
			}

			@Override
			public Integer next() {
				int value = p.value;
				p = p.next;
				return value;
			}
			
		};
	}
	
	public void loop() {
		Node pNode = sentinel.next;
		while(pNode != sentinel) {
			System.out.println(pNode.value);
			pNode = pNode.next;
		}
	}
	
	public static void main(String[] args) {
		AnnularLinkedList list = new AnnularLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
//		list.loop();
		list.removeByValue(0);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	

}
