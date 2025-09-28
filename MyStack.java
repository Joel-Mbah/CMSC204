/*
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor: Huseyin Aygun
 * Project 2
 * Date: 09/28/2025
 */
import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private T[] data;
	private int size;

	public MyStack() {
		// TODO Auto-generated constructor stub
		this.data = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		if (item == null) 
		{
			throw new IllegalArgumentException("Cannot push null item");
		}
		if (size >= StackADT.MAX_CAPACITY || size >= data.length)
		{
			throw new IllegalStateException("Stack is full");
		}
		data[size] = item;
		size++;
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new NoSuchElementException("Stack is empty");
		}
		T item = data[--size];
		data[size] = null;
		
		return item;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new NoSuchElementException("Stack is empty");
		}
		return data[size - 1];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object [] copy = new Object [size];
		for(int i = 0; i < size; i++)
		{
			copy[i] = data[i];
		}
		return copy;
	}

}
