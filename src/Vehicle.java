/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle 
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

	public boolean move(ArrayList<Passenger> passengersList) throws IOException
	{
		int routeLength = route.size();
		this.currDistance += vehicleSpeed;
		
		if(numOfRoad == routeLength) // vehicle arrival
		{
			System.out.println("Vehicle " + vehicleNum + " arrived to it's destination: " + route.get(numOfRoad - 1).getEnd());
			
			if (passenger != null)
			{
				System.out.println(passenger.toString() + " arrived to the destination with " + this);
				passenger.addToReport(vehicleNum);
				passenger = null;
			}
			return true;
		}
		
		System.out.println(this + " is moving on the " + route.get(numOfRoad));
		
		if(this.currDistance >= distance) // handle vehicle movement
		{
			for(int p = 0; p < passengersList.size(); p++)
			{
				if(passengersList.get(p).getInitialJunction().getJunctionNum() == this.getRoute().get(numOfRoad).getEnd().getJunctionNum() && passenger == null) //checks if there is passenger
				{
					passenger = passengersList.get(p);
					double distanceRemainder = currDistance - distance;
					
					this.setRoute(passenger.getPassengerRoute());
					routeLength = route.size();
					numOfRoad = 0;
					currDistance = distanceRemainder;
					distance = route.get(numOfRoad).getLength();
					passengersList.remove(passenger);
					
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
				try 
				{
					distance += route.get(numOfRoad).getLength();
				}
				catch(Exception e)
				{
					distance+=0;
				}
			}
		}
		return false;
	}


	@Override
	public String toString() 
	{
		return "Vehicle " + vehicleNum;
	}
	
	

}
