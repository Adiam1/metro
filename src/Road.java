

public class Road
{
	private Junction ExitingJunction;
	private Junction EnteringJunction;
	

	public Road(Junction exitingJunction, Junction enteringJunction) 
	{
		super();
		ExitingJunction = exitingJunction;
		EnteringJunction = enteringJunction;
		double length = getLength();
		System.out.println(String.format("Creating Road from Junction 1 to Junction 2, length: %.2f", length));
	}
	
	public double getLength() 
	{
		return  EnteringJunction.calcDistance(ExitingJunction);
	}

	@Override
	public String toString() {
		return "Road from Junction " + ExitingJunction + " to Junction " + EnteringJunction;
	}
}
