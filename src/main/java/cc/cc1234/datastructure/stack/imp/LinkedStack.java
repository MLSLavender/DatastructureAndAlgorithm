package cc.cc1234.datastructure.stack.imp;

import cc.cc1234.datastructure.stack.IStack;

/**
 * 基于链表的栈实现
 * @author vran1
 */
public class LinkedStack<E> implements IStack<E>{
	private Node<E> head;
	private int size;
	
	private static class Node<E>{
		E v;
		Node<E> next;
		Node<E> pre;
		
		public Node(E v) {
			this.v = v;
		}
	}
	
	@Override
	public boolean push(E e) {
		if(e == null) {
			return false;
		}
		
		if(head == null) {
			head = new Node<>(e);
		}else {
			Node<E> n = head;
			Node<E> node = new Node<>(e);
			node.next = n;
			head = node;
		}
		size++;
		return true;
	}

	@Override
	public E pop() {
		if(size == 0) {
			return null;
		}
		Node<E> node = head;
		head =node.next;
		size--;
		return node.v;
	}

	@Override
	public int size() {
		return size;
	}
	
}
