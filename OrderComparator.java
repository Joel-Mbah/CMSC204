/*
 * Name: Joel Mbah
 * Class: CMSC 204
 * Professor: Huseyin Aygun
 * Project 2
 * Date: 09/28/2025
 */

import java.util.Comparator;
public class OrderComparator implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		// TODO Auto-generated method stub
		int deadlineComparison = Integer.compare(o1.getDeadlineMinute(), o2.getDeadlineMinute());
		if(deadlineComparison != 0)
		{
			return deadlineComparison;
		}
		
		return Integer.compare(o1.getArrivalMinute(), o2.getArrivalMinute());
	}

	
}
