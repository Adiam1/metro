
import java.util.ArrayList;
import java.util.Random;

public class Junction extends Point
{
	
	private ArrayList<Road> ExitingRoads;
	private ArrayList<Road> EnteringRoads;
	private TrafficLight trafficLight;
	private int junctionNum;
	private static int counter = 0;
	public Junction() 
	{
		super();
		ExitingRoads = new ArrayList<Road>();;
		EnteringRoads = new ArrayList<Road>();
		trafficLight = null;
		junctionNum = ++counter;
		System.out.println(String.format("Creating " + this + " at Point (%.2f, %.2f)", getX(), getY()));
	}
	
	public Junction(double x, double y) 
	{
		super();
		ExitingRoads = new ArrayList<Road>();;
		EnteringRoads = new ArrayList<Road>();
		trafficLight = null;
		junctionNum = ++counter;
		System.out.println(String.format("Creating " + this + " at Point (%.2f, %.2f)", getX(), getY()));
	}
	@Override
	public String toString() 
	{
		return "Junction " + junctionNum;
	}
	public ArrayList<Road> getExitingRoads() 
	{
		return ExitingRoads;
	}
	public void setExitingRoads(ArrayList<Road> exitingRoads) 
	{
		ExitingRoads = exitingRoads;
	}
	public ArrayList<Road> getEnteringRoads() 
	{
		return EnteringRoads;
	}
	public void setEnteringRoads(ArrayList<Road> enteringRoads) 
	{
		EnteringRoads = enteringRoads;
	}
	public void addEnteringRoads(Road enteringRoad) 
	{
		EnteringRoads.add(enteringRoad);
	}
	public void addExitingRoads(Road exitingRoad) 
	{
		ExitingRoads.add(exitingRoad);
	}
	public int getJunctionNum() 
	{
		return junctionNum;
	}
	public void setJunctionNum(int junctionNum) 
	{
		this.junctionNum = junctionNum;
	}

	public TrafficLight getTrafficLight() 
	{
		return trafficLight;
	}

	public void setTrafficLight() 
	{
		Random rand = new Random();
		
		if(rand.nextBoolean())
		{
			this.trafficLight = new RandomTrafficLight(this);
		}
		else
		{
			this.trafficLight = new SequentialTrafficLight(this);
		}
		
		System.out.println(this.trafficLight);
		
	}
	
	
}
