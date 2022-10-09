/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class DrivingGame 
{
	private Map map;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Passenger> passengersList;
	private boolean gameFinished;
		
	public DrivingGame(int junctionAmount, int vehicleAmount) 
	{
		this.passengersList = new ArrayList<Passenger>();
		map = new Map(junctionAmount, passengersList);
		gameFinished = false;
		this.vehicles = new ArrayList<Vehicle>();
		
		for(int i = 0; i < vehicleAmount; i++)
		{
			this.vehicles.add(new Vehicle(map));
		}
	}

	public static void initiateReport()
	{
		String fileName = "report.txt";
		String str = "  Vehicle   |   Passenger   |     From   |     To    \n"
				+ "------------|---------------|------------|------------\n";
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		    writer.write(str);
		    writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
	
		int turnCount = 1;
		initiateReport();
		ArrayList<Dynamic> workers = new ArrayList<Dynamic>();

		workers.addAll(vehicles);
			
		for(Junction j: map.getJunctions())
		{
			if(j.getTrafficLight() != null)
			{
				workers.add(j.getTrafficLight());
			}
		}
		while(!gameFinished)
		{
			gameFinished = true;
			System.out.println("Turn "+ turnCount);
			
			if(turnCount % 3 == 0)
			{
				Passenger passenger = new Passenger(map);
				passengersList.add(passenger);
				System.out.println(passenger.toString() + " is waiting for vehicle at " + passenger.getInitialJunction() + ", path: " + passenger.getPassengerRoute());
			}
			for(Dynamic d: workers)
			{
				d.executeTurn();
			}
	
			for (Vehicle v: vehicles)
			{
				if(!v.isFinished())
				{
					gameFinished = false;
				}
			}
			
			turnCount++;
		}
	}
}
