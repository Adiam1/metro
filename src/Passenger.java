import java.util.ArrayList;

public class Passenger 
{
	private static int counter = 0;
	private int passengerNum;
	private ArrayList<Road> passengerRoute;
	private Junction initialJunction;

	public Passenger(Map map) 
	{
		super();
		this.passengerRoute = map.creatingRoute();
		this.initialJunction = passengerRoute.get(0).getStart();
		passengerNum = ++counter;
	}
	

	public ArrayList<Road> getPassengerRoute() 
	{
		return passengerRoute;
	}

	public void setPassengerRoute(ArrayList<Road> passengerRoute) 
	{
		this.passengerRoute = passengerRoute;
	}

	public Junction getInitialJunction() 
	{
		return initialJunction;
	}

	public void setInitialJunction(Junction startJunction) 
	{
		this.initialJunction = startJunction;
	}

	@Override
	public String toString() 
	{
		return "Passenger " + passengerNum + " is waiting for vehicle at " + initialJunction + ", path: " + passengerRoute;
	}

}
