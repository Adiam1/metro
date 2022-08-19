

import java.util.ArrayList;

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
		trafficLight = new TrafficLight();
		junctionNum = ++counter;
		System.out.println(String.format("Creating " + this + " at Point (%.2f, %.2f)", x, y));
	}
	@Override
	public String toString() 
	{
		return "Junction " + junctionNum;
	}

	
	
}
