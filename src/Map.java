import java.util.ArrayList;
import java.util.Random;

public class Map 
{
	private ArrayList<Junction> junctions;

	public Map(int junctionAmount) 
	{
		super();
		
		for(int i = 0; i < junctionAmount; i++)
		{
			junctions.add(new Junction());
		}
		if (junctionAmount == 1) 
		{
			return;
		}
		Random rand = new Random(junctionAmount);
		int num;
		for(int i = 0; i < junctionAmount / 2; i++)
		{
			for(int j = 0; j< junctionAmount; j++)
			{
				num = rand.nextInt();
				while (num == i) 
				{
					num = rand.nextInt();
				}
				Road road = new Road(junctions.get(i), junctions.get(num));
			}
		}
		
	}
	
	
}
