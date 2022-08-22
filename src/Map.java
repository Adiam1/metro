import java.util.ArrayList;
import java.util.Random;

public class Map 
{
	private ArrayList<Junction> junctions;

	public Map(int junctionAmount) 
	{
		super();
		this.junctions = new ArrayList<Junction>();
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
				}
				
			}
			
		}
	}
	
	public Map(ArrayList<Junction> junctions, ArrayList<Road> roads)
	{
		super();
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
	
	
}
