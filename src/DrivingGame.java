/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class DrivingGame 
{
	private Map map;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Passenger> passengersList;
	private int finishedVehicles;
		
	public DrivingGame(int junctionAmount, int vehicleAmount) 
	{
		map = new Map(junctionAmount);
		finishedVehicles = 0;
		this.vehicles = new ArrayList<Vehicle>();
		this.passengersList = new ArrayList<Passenger>();
		
		for(int i = 0; i < vehicleAmount; i++)
		{
			this.vehicles.add(new Vehicle(map));
		}
	}

	public static void initiateReport() throws IOException
	{
		String fileName = "report.txt";
		String str = "  Vehicle   |   Passenger   |     From   |     To    \n"
				+ "------------|---------------|------------|------------\n";
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    writer.write(str);
	    
	    writer.close();
	}
	
	public void play() throws IOException
	{
		int turnCount = 1;
		initiateReport();
		
		while(finishedVehicles < vehicles.size())
		{
			finishedVehicles = 0;
			System.out.println("Turn "+ turnCount);
			
			if(turnCount % 3 == 0)
			{
				Passenger passenger = new Passenger(map);
				passengersList.add(passenger);
				System.out.println(passenger.toString() + " is waiting for vehicle at " + passenger.getInitialJunction() + ", path: " + passenger.getPassengerRoute());
			}
			
			for(Vehicle v: vehicles)
			{
				if(v.move(passengersList))
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
			
			turnCount++;
		}
	}
}
