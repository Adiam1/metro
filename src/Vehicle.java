/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.ArrayList;
import java.util.Random;

public class Vehicle implements Dynamic
{
	private static int counter = 0;
	private double currDistance = 0;
	private int numOfRoad = 0;
	private ArrayList<Road> route;
	private double distance;
	private int vehicleNum;
	private int vehicleSpeed;
	private final int minSpeed = 30;
	private final int maxSpeed = 120;
	private Passenger passenger;
	private Map map;
	private boolean isFinished = false;
	
	public Vehicle(Map map)
	{
		super();
		this.map = map;
		this.route = map.creatingRoute();
		distance = route.get(numOfRoad).getLength();
		vehicleNum = ++counter;
		Random rand = new Random();
		vehicleSpeed = rand.nextInt(maxSpeed - minSpeed) + minSpeed;
		System.out.println("Creating Vehicle "  + vehicleNum + ", speed: " + vehicleSpeed + ", path: " + route);
	}
	
	public boolean isFinished() 
	{
		return isFinished;
	}
	
	public int getNumOfRoad() 
	{
		return numOfRoad;
	}

	public void setNumOfRoad(int numOfRoad) 
	{
		this.numOfRoad = numOfRoad;
	}
	
	public ArrayList<Road> getRoute() 
	{
		return route;
	}

	public void setRoute(ArrayList<Road> route) 
	{
		this.route = route;
	}

	public void executeTurn()
	{
		this.currDistance += vehicleSpeed;
		
		if(numOfRoad == route.size()) // vehicle arrival
		{
			System.out.println("Vehicle " + vehicleNum + " arrived to it's destination: " + route.get(numOfRoad - 1).getEnd());
			
			if (passenger != null)
			{
				System.out.println(passenger.toString() + " arrived to the destination with " + this);
				passenger.addToReport(vehicleNum);
				passenger = null;
			}
			isFinished = true;
			return;
		}
		System.out.println(this + " is moving on the " + route.get(numOfRoad));

		
		if(this.currDistance >= distance) //vehicle switching road in route
		{
			takeRelevantPassenger();
			
			if (route.get(numOfRoad).getEnd().getTrafficLight() != null &&
						route.get(numOfRoad).getEnd().getTrafficLight().getCurrentGreen() != route.get(numOfRoad))  // handle traffic lights
			{
				System.out.println("Vehicle " + vehicleNum + " is waiting for green light on " + route.get(numOfRoad).getEnd());
				this.currDistance -= vehicleSpeed;
			}
			numOfRoad += 1;
			if(numOfRoad < route.size())
			{
				distance += route.get(numOfRoad).getLength();
			}
		}
	}

	private void takeRelevantPassenger() 
	{
		for(int p = 0; p < map.getPassengersList().size(); p++)
		{
			if(map.getPassengersList().get(p).getInitialJunction().getJunctionNum() == this.getRoute().get(numOfRoad).getEnd().getJunctionNum() 
					&& passenger == null) //checks if there is passenger
			{
				passenger = map.getPassengersList().get(p);
				double distanceRemainder = currDistance - distance;
				this.setRoute(passenger.getPassengerRoute());
				numOfRoad = 0;
				currDistance = distanceRemainder;
				distance = route.get(numOfRoad).getLength();
				map.getPassengersList().remove(passenger);
				break;
			}
		}
	}
	
	@Override
	public String toString() 
	{
		return "Vehicle " + vehicleNum;
	}
	
}
