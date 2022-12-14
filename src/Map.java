/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.ArrayList;
import java.util.Random;

public class Map 
{
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<Passenger> passengersList;

	public Map(int junctionAmount, ArrayList<Passenger> passengersList) 
	{
		super();
		this.junctions = new ArrayList<Junction>();
		this.roads = new ArrayList<Road>();
		this.passengersList = passengersList;
		for(int i = 0; i < junctionAmount; i++)
		{
			junctions.add(new Junction());
		}
		if (junctionAmount == 1) 
		{
			return;
		}
		Random rand = new Random();
		ArrayList<Integer> blockedNumbers = new ArrayList<Integer>(); 
		int num;
		for(int j = 0; j < junctionAmount; j++)
		{
			blockedNumbers.add(j);
			for(int i = 0; i< rand.nextInt(junctionAmount); i++)
			{
				num = rand.nextInt(junctionAmount);
				while (blockedNumbers.contains(num))
				{
					num = rand.nextInt(junctionAmount);
				}
				blockedNumbers.add(num);
				Road road = new Road(junctions.get(j), junctions.get(num));
				roads.add(road);
			}
			blockedNumbers.clear();
		}
		creatingTrafficLight(junctionAmount);
	}
	
	public Map(ArrayList<Junction> junctions, ArrayList<Road> roads)
	{
		super();
		setJunctions(junctions);
		setRoads(roads);
		int junctionAmount = junctions.size();
		creatingTrafficLight(junctionAmount);
	}
	
	public ArrayList<Passenger> getPassengersList() 
	{
		return passengersList;
	}

	public ArrayList<Junction> getJunctions() 
	{
		return junctions;
	}

	public void setJunctions(ArrayList<Junction> junctions) 
	{
		this.junctions = junctions;
	}

	public ArrayList<Road> getRoads() 
	{
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) 
	{
		this.roads = roads;
	}

	public ArrayList<Road> creatingRoute()
	{
		ArrayList<Road> route = new ArrayList<Road>();
		int junctionsLength = junctions.size();
		Random rand = new Random();
		int junctionIndex = rand.nextInt(junctionsLength);
		final int maxRoadLength = 4;
		Junction beginningJunction = junctions.get(junctionIndex);
		int exitingRoadsLength = beginningJunction.getExitingRoads().size();
		while(exitingRoadsLength == 0)
		{
			junctionIndex = rand.nextInt(junctionsLength);
			beginningJunction = junctions.get(junctionIndex);
			exitingRoadsLength = beginningJunction.getExitingRoads().size();
		}
		int i = 0;
		while(i < maxRoadLength && exitingRoadsLength > 0) 
		{
			int exitRoadIndex = rand.nextInt(exitingRoadsLength);
			Road newRoad = beginningJunction.getExitingRoads().get(exitRoadIndex);
			route.add(newRoad);
			beginningJunction = newRoad.getEnd();
			exitingRoadsLength = beginningJunction.getExitingRoads().size();
			i++;
		}
		
		return route;
	}
	
	public void creatingTrafficLight(int junctionAmount)
	{
		Random rand = new Random();
		for (int i = 0; i < junctionAmount;i++) 
		{
			if (0 < junctions.get(i).getEnteringRoads().size())
			{
				if (rand.nextBoolean() && rand.nextBoolean())
				{
					junctions.get(i).setTrafficLight();
				}
			}
		}
	}
	
}
