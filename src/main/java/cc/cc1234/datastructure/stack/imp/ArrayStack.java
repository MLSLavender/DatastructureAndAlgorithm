package cc.cc1234.datastructure.stack.imp;

import java.util.Arrays;

import cc.cc1234.datastructure.stack.IStack;

/**
 * 
 * 栈：后来居上
 * (底层实现可以由数组和链表两种实现方式)
 * @author vran
 */
public class ArrayStack<E> implements IStack<E>{
	private Object[] data;
	private int size;
	
	public ArrayStack(int capacity) {
		data = new Object[capacity];
	}
	
	/**
	 * 将元素压入栈底
	 * @Date 2017年7月21日
	 */
	@Override
	public boolean push(E e) {
		if(size == data.length) {
			return false;
		}
		data[size] = e;
		size++;
		return true;
	}
	
	/**
	 * 弹出栈顶元素
	 * @Date 2017年7月21日
	 */
	@Override
	public E pop() {
		if(size == 0) {
			return null;
		}
		E e = (E) data[--size];
		data[size] = null;
		return e;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	
	
	@Override
	public String toString() {
		return "Stack [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}
}
