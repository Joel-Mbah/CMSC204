/*
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor: Huseyin Aygun
 * Project 2
 * Date: 09/28/2025
 */

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> implements PriorityQueueADT<T>{
	private static final int DEFAULT_CAPACITY = 10;	
	private T[] data;
	private int size ;
	private Comparator<T> comparator;
	
	// constructor with a default capacity
	public MyPriorityQueue(Comparator<T> comparator) {
		this.data = (T[]) new Object[DEFAULT_CAPACITY];
		this.comparator = comparator;
		this.size = 0;
		
	}

	@Override
	public void enqueue(T item) {
		// TODO Auto-generated method stub
		
		if(item == null)
		{
			throw new IllegalArgumentException("Enque is empty");
		}
		if (size >= data.length)
		{
			throw new IllegalStateException("PriorityQueue is full");
		}
		
		int i;
		//i = size - 1;
		for(i = size - 1; i >= 0 && comparator.compare(item, data[i]) < 0; i--)
		{
			data[i + 1] = data[i];
		}
		data[i + 1] = item;
		size++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new NoSuchElementException("Queue is empty.");
		}
		T item =  data[0];
		for (int i = 1; i < size; i++)
		{
			data[i-1] = data[i];
		}
		data[--size] = null;
		return item;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new NoSuchElementException("Queue is empty.");
		}
		return data[0];
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
		Object[] arrayClone = new Object[size];
		for(int i = 0; i < size; i++)
		{
			arrayClone[i] = data[i];  //copy the elements of data array to arrayClone array
		}
		return arrayClone;
	}


}
