/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.ArrayList;

public class DrivingGame 
{
	private Map map;
	private ArrayList<Vehicle> vehicles;
	private int finishedVehicles;
		
	public DrivingGame(int junctionAmount, int vehicleAmount) 
	{
		map = new Map(junctionAmount);
		finishedVehicles = 0;
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
			
			System.out.println("Turn "+ (i + 1));
			
			for(Vehicle v: vehicles)
			{
				v.move();
			}
			
			for(Junction j: map.getJunctions())
			{
				if(j.getTrafficLight() != null)
				{
					j.getTrafficLight().check();
				}
			}
		}
	}
	
	public void play()
	{
		int i = 1;
		while(finishedVehicles < vehicles.size())
		{
			finishedVehicles = 0;
			System.out.println("Turn "+ i);
			
			for(Vehicle v: vehicles)
			{
				if(v.move())
				{
					finishedVehicles += 1;
				}
			}
			
			for(Junction j: map.getJunctions())
			{
				if(j.getTrafficLight() != null)
				{
					j.getTrafficLight().check();
				}
			}
			
			i++;
		}
	}
}
