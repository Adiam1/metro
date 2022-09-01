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



	public void move()
	{
		int routeLength = route.size();
		this.currDistance += vehicleSpeed;
		if(this.currDistance >= distance && numOfRoad < routeLength)
		{
			numOfRoad += 1;
			if(numOfRoad < routeLength)
			{
				distance += route.get(numOfRoad).getLength();
				System.out.println(this);
			}
		}
		else if(this.currDistance < distance && numOfRoad < routeLength)
		{
			System.out.println(this);
		}
		


		
		if(numOfRoad == routeLength)
		{
			System.out.println("Vehicle " + vehicleNum + " arrived to it's destination: " + route.get(numOfRoad - 1).getEnd());
			
		}
	}



	@Override
	public String toString() 
	{
		return "Vehicle " + vehicleNum + " is moving on the " + route.get(numOfRoad);
	}
	
	

}
