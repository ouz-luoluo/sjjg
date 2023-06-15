package 数据结构与算法.com.lz.链表;

// 双向链表(带哨兵)
public class DoublyLinkedListSentinel {
	
	static class Node{
		Node prev; // 上一个节点指针
		int value; 	   // 值
		Node next; // 下一个节点指针
		
		public Node(Node prev, int value, Node next) {
			super();
			this.prev = prev;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head; // 头哨兵
	private Node tail; // 尾哨兵

	public DoublyLinkedListSentinel() {
		head = new Node(null, 666, null);
		tail = new Node(null, 888, null);
		head.next = tail;
		tail.prev = head;
	}
	
	/**
	 * 得到索引值的节点
	 * @param index 索引值
	 * @return t:索引下的节点，f:返回null
	 */
	public Node findNode(int index) {
		int i = -1;
		Node p = head;
		while(p != tail){
			if(i == index) {
				return p;
			}
			p = p.next;
			i++;
		}
		return null;
		
	}
	
	/**
	 * 添加到头节点
	 * @param value 添加的值
	 */
	public void addFirst(int value) {
		insert(0, value);
	}
	
	/**
	 * 添加到尾节点
	 * @param value 添加的值
	 */
	public void addLast(int value) {
		Node last = tail.prev;
		Node added = new Node(last, value, tail);
		last.next = added;
		tail.prev = added;
	}
	
	/**
	 * 删除头节点
	 */
	public void removeFirst() {
		remove(0);
	}
	
	/**
	 * 删除尾节点
	 */
	public void removeLast() {
		Node removed = tail.prev;
		if (removed == head) {
			throw new IllegalArgumentException("没有可删除的节点了");
		}
		Node prev = removed.prev;
		prev.next = tail;
 	}
	
	/**
	 * 插入节点
	 * @param index 插入的节点索引位置
	 * @param value 插入节点的值
	 */
	public void insert(int index, int value) {
		Node prev = findNode(index - 1);
		if(prev == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
			
		}
		Node next = prev.next;
		Node inserNode = new Node(prev, value, next);
		prev.next = inserNode;
		next.prev = inserNode;
	}
	
	/**
	 * 删除节点
	 * @param index 删除节点索引位置
	 */
	public void remove(int index) {
		Node prev = findNode(index - 1);
		if(prev == null) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		Node removeNode = prev.next;
		if(removeNode == tail) {
			throw new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
		}
		Node next = removeNode.next;
		
		prev.next = next;
		next.prev = prev;
	}
	
	// 遍历
	public void loop() {
		Node p = head.next;
		while(p != tail) {
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	
	
	public static void main(String[] args) {
		DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
		list.insert(0, 10);
//		list.removeLast();
		
		list.loop();
	}
	
	

}
