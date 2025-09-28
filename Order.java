/*
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor: Huseyin Aygun
 * Project 2
 * Date: 09/28/2025
 */

public class Order {
	private final String id;
	private final int deadlineMinute;
	private int arrivalMinute;
	

	public Order(String id, int deadlineMinute) {
		// TODO Auto-generated constructor stub
		if(id == null || id.isEmpty())
		{
			throw new IllegalArgumentException("Order ID cannot be null or empty");
		}
		
		if(deadlineMinute < 0)
		{
			throw new IllegalArgumentException("Deadline cannot be negative");
		}
		
		this.id = id;
		this.deadlineMinute = deadlineMinute;
		//this.arrivalMinute = -1;
	}
	
	public void setArrivalMinute(int minute)
	{
		if(minute < 0)
		{
			throw new IllegalArgumentException("Arrival minute cannot be negative");
		}
		this.arrivalMinute = minute;
	}
	
	public int getArrivalMinute()
	{
		return arrivalMinute;
	}
	
	public int getDeadlineMinute()
	{
		return deadlineMinute;
	}
	
	public String getId()
	{
		return id;
	}
//	@Override
//	public String toString()
//	{
//		return ("Order[ " + orderId + ", arrives at " + arrivalMinute + ", deadline " + deadlineMinute + "]");
//	}
}
