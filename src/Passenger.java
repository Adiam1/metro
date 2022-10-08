import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Passenger 
{
	private static int counter = 0;
	private int passengerNum;
	private ArrayList<Road> passengerRoute;
	private Junction initialJunction;

	public Passenger(Map map) 
	{
		super();
		this.passengerRoute = map.creatingRoute();
		this.initialJunction = passengerRoute.get(0).getStart();
		passengerNum = ++counter;
	}
	

	
	public ArrayList<Road> getPassengerRoute() 
	{
		return passengerRoute;
	}

	public void setPassengerRoute(ArrayList<Road> passengerRoute) 
	{
		this.passengerRoute = passengerRoute;
	}

	public Junction getInitialJunction() 
	{
		return initialJunction;
	}

	public void setInitialJunction(Junction startJunction) 
	{
		this.initialJunction = startJunction;
	}
	
	public void addToReport(int vehicleNum)
	{
		String fileName = "report.txt";
		int length = passengerRoute.size();
		int endJunction = passengerRoute.get(length - 1).getEnd().getJunctionNum();
		String passengerReport = String.format("Vehicle %-4d|Passenger %-5d|Junction %-3d|Junction %-3d\n", vehicleNum, passengerNum, initialJunction.getJunctionNum(), endJunction);
		try
		{
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter writer = new BufferedWriter(fw);
			
			writer.write(passengerReport);
			writer.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}


	@Override
	public String toString() 
	{
		return "Passenger " + passengerNum;
	}

}
