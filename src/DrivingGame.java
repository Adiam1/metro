/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.ArrayList;

public class DrivingGame 
{
	private Map map;
	private ArrayList<Vehicle> vehicles;
		
	public DrivingGame(int junctionAmount, int vehicleAmount) 
	{
		map = new Map(junctionAmount);
		this.vehicles = new ArrayList<Vehicle>();
		
		for(int i = 0; i < vehicleAmount; i++)
		{
			this.vehicles.add(new Vehicle(map));
		}
	}
	
	public void play(int turns)
	{
		if(turns <= 0)
		{
			return;
		}
		
		for(int i = 0; i < turns;i++)
		{
			System.out.println("turn "+ (i + 1));
			
			for(Junction j: map.getJunctions())
			{
				if(j.getTrafficLight() != null)
				{
					j.getTrafficLight().check();
				}
			}
			
			for(Vehicle v: vehicles)
			{
				v.move();
			}
		}
	}
}
