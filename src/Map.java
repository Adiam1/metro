import java.util.ArrayList;
import java.util.Random;

public class Map 
{
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<Road> route = new ArrayList<Road>();;

	public Map(int junctionAmount) 
	{
		super();
		this.junctions = new ArrayList<Junction>();
		this.roads = new ArrayList<Road>();
		for(int i = 0; i < junctionAmount; i++)
		{
			junctions.add(new Junction());
		}
		if (junctionAmount == 1) 
		{
			return;
		}
		Random rand = new Random();
		
		for(int j = 0; j < junctionAmount; j++)
		{
			boolean isCreatinJunction;
;			for(int i = 0; i < junctionAmount; i++)
			{
				isCreatinJunction = rand.nextBoolean();
				
				if(i != j && isCreatinJunction) 
				{
					Road road = new Road(junctions.get(j), junctions.get(i));
					roads.add(road);
				}
				
			}
			
		}
	}
	
	public Map(ArrayList<Junction> junctions, ArrayList<Road> roads)
	{
		super();
		setJunctions(junctions);
		setRoads(roads);
		//adding here traffic lights, junctions and roads are already given
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
		int junctionsLength = junctions.size();
		Random rand = new Random();
		int junctionIndex = rand.nextInt(junctionsLength);
		final int maxRoadLength = 4;
		Junction beginningJunction = junctions.get(junctionIndex);
		int exitingRoadsLength = beginningJunction.getExitingRoads().size();
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
	
}
