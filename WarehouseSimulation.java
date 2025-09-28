/*
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor: Huseyin Aygun
 * Project 2
 * Date: 09/28/2025
 */

import java.util.Comparator;


public class WarehouseSimulation implements SimulationInterface {
	private MyPriorityQueue<Order> orderQueue;
	private MyStack<Order> returnsStack;
	private Order[] allOrders;
	private int currentMinute;
	private int releaseIndex;
	
	private int totalArrived;
	private int totalShipped;
	private int totalLate;
	
	
	public WarehouseSimulation(Order[] orders) {
		// TODO Auto-generated constructor stub
		this.allOrders = orders;
		this.orderQueue = new MyPriorityQueue<>(new OrderComparator());
		this.returnsStack = new MyStack<>();
		this.currentMinute = 0;
		this.releaseIndex = 0;
		this.totalArrived = 0;
		this.totalLate = 0;
		this.totalShipped = 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(releaseIndex < allOrders.length)
		{
			Order order = allOrders[releaseIndex++];
			order.setArrivalMinute(currentMinute);
			orderQueue.enqueue(order);
			totalArrived++;
		}
		
		if(!orderQueue.isEmpty())
		{
			Order toShip = orderQueue.dequeue();
			totalShipped++;
		
		if(currentMinute > toShip.getDeadlineMinute())
		{
			returnsStack.push(toShip);
			totalLate++;
		}
		currentMinute++;
		}
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return releaseIndex >= allOrders.length && orderQueue.isEmpty();
	}

	@Override
	public int getCurrentMinute() {
		// TODO Auto-generated method stub
		return currentMinute;
	}

	@Override
	public int getTotalArrived() {
		// TODO Auto-generated method stub
		return totalArrived;
	}

	@Override
	public int getTotalShipped() {
		// TODO Auto-generated method stub
		return totalShipped;
	}

	@Override
	public int getTotalLate() {
		// TODO Auto-generated method stub
		return totalLate;
	}

}
