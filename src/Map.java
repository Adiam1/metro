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
		ArrayList<Integer> blockedNumbers = new ArrayList <Integer>();
		int num;
		for(int j = 0; j < junctionAmount; j++)
		{
			blockedNumbers.add(j)
;			for(int i = 0; i< rand.nextInt(junctionAmount); i++)
			{
				num = rand.nextInt(junctionAmount);
				while (blockedNumbers.contains(num))
				{
					num = rand.nextInt(junctionAmount);
				}
				blockedNumbers.add(num);
				Road road = new Road(junctions.get(j), junctions.get(num));
				
				
			}
			
			blockedNumbers.clear();
			
		}
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
