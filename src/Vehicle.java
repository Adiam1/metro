/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.ArrayList;
import java.util.Random;

public class Vehicle 
{
	private static int counter = 0;
	private int currDistance = 0;
	private int numOfRoad = 0;
	private ArrayList<Road> route;
	private double distance;
	private int vehicleNum;
	private int vehicleSpeed;
	private final int minSpeed = 30;
	private final int maxSpeed = 120;
	private boolean hasPassenger = false;
	public Vehicle(Map map)
	{
		super();
		this.route = map.creatingRoute();
		distance = route.get(numOfRoad).getLength();
		vehicleNum = ++counter;
		Random rand = new Random();
		vehicleSpeed = rand.nextInt(maxSpeed - minSpeed) + minSpeed;
		System.out.println("Creating Vehicle "  + vehicleNum + ", speed: " + vehicleSpeed + ", path: " + route);
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

	public boolean move(ArrayList<Passenger> passengersList)
	{
		int routeLength = route.size();
		this.currDistance += vehicleSpeed;
		
		if(numOfRoad == routeLength) // vehicle arrival
		{
			System.out.println("Vehicle " + vehicleNum + " arrived to it's destination: " + route.get(numOfRoad - 1).getEnd());
			return true;
		}
		
		System.out.println(this);
		
		if(this.currDistance >= distance) // handle vehicle movement
		{
			for(Passenger p: passengersList)
			{
				if(p.getInitialJunction().getJunctionNum() == this.getRoute().get(numOfRoad).getEnd().getJunctionNum() && hasPassenger == false) //checks if there is passenger
				{
					hasPassenger = true;
					this.setRoute(p.getPassengerRoute()); //check  if works
				}
				
			}
			
			if (route.get(numOfRoad).getEnd().getTrafficLight() != null &&
					route.get(numOfRoad).getEnd().getTrafficLight().getCurrentGreen() != route.get(numOfRoad))  // handle traffic lights
			{
				System.out.println("Vehicle " + vehicleNum + " is waiting for green light on " + route.get(numOfRoad).getEnd());
				this.currDistance -= vehicleSpeed;
				return false;
			}
			numOfRoad += 1;
			if(numOfRoad < routeLength)
			{
				distance += route.get(numOfRoad).getLength();
				
			}
		}
		return false;
	}


	@Override
	public String toString() 
	{
		return "Vehicle " + vehicleNum + " is moving on the " + route.get(numOfRoad);
	}
	
	

}
