package cc.cc1234.datastructure.list.imp;

import cc.cc1234.datastructure.list.BaseList;

/**
 * 链表(逻辑连续)
 * @author vran
 */
public class LinkedList<E extends Comparable<? super E>> extends BaseList<E> {
	
	private Node<E> head;
	private Node<E> last;
	
	private static class Node<E>{
		E value;
		Node next;
		Node pre;
		
		public Node() {
			super();
		}
		
		public Node(E obj) {
			this.value = obj;
		}

		public Node(E obj, Node next, Node pre) {
			this.value = obj;
			this.next = next;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "Node [obj=" + value + "]";
		}	
		
	}
	
	@Override
	public void add(E e) {
		if(e == null) {
			throw new NullPointerException();
		}
		Node<E> node = new Node<>(e);
		insertNode(node);
		size++;
	}
	
	private void insertNode(Node<E> node) {
		if(head == null) {
			head = last = node;
		}else {
			node.pre = last;
			last.next = node;
			last = node;
		}
	}

	@Override
	public E remove(int index) {
		Node<E> n=find(index);
		if(n == null) { return null;}
		
		Node<E> pre = n.pre;
		Node<E> next = n.next;
		
		if(pre == null) {
			if(next == null) {//单个节点删除（既是头结点又是尾节点）
				head = last = null;
			}else {//头结点删除（有后继节点）
				head = next;
				next.pre = null;
			}
		}else {
			if(next == null) {//尾结点删除
				last = pre;
				pre.next = null;
			}else {// 中间节点删除
				pre.next = next;
				next.pre = pre;
			}
		}
		size--;
		return n.value;
	}

	@Override
	public E get(int index) {
		Node<E> n=find(index);
		return n==null?null:n.value;
	}
	
	private Node<E> find(int index){
		if(index>=super.size()) {
			throw new IllegalArgumentException();
		}
		
		Node<E> n = head;
		int i=0;
		while(n!=null) {
			if(i==index) {
				return n;
			}
			i++;
			n=n.next;
		}
		return null;
	}
	
	@Override
	public boolean contains(E e) {
		if(size == 0) {
			return false;
		}
		
		Node<E> n = head;
		while(n!=null) {
			if(n.value.compareTo(e) == 1) {
				return true;
			}
			n = n.next;
		}
		
		return false;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		Node<E> n = head;
		while(n!=null) {
			builder.append(n.value).append(" ");
			n = n.next;
		}
		builder.append("]");
		builder.append(" size=").append(super.size);
		return builder.toString();
	}

	public static void main(String[] args) {
		BaseList<Integer> list = new LinkedList<>();
		list.add(1);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		System.out.println("-------------------");
		list.add(1);
		list.add(2);
		System.out.println("remove 1="+list.remove(1));
		System.out.println(list);
		list.add(3);
		System.out.println("remove 0="+list.remove(0));
		System.out.println(list);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println("remove 2="+list.remove(2));
		System.out.println(list);
		
		
	}
}
