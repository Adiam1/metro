
public class Road
{
	private Junction exitingJunction;
	private Junction enteringJunction;
	

	public Road(Junction exitingJunction, Junction enteringJunction) 
	{
		super();
		this.exitingJunction = exitingJunction;
		if(exitingJunction.getJunctionNum() == enteringJunction.getJunctionNum())
		{
			Junction junction = new Junction();
			this.enteringJunction = junction;
			System.out.println("Road can not connect a junction to itself, the end junction has been\n"
					+ "replaced with Junction " + junction.getJunctionNum());
		}
		else
		{
			this.enteringJunction = enteringJunction;
		}

		this.exitingJunction.addExitingRoads(this);
		this.enteringJunction.addEnteringRoads(this);
		double length = getLength();
		System.out.println(String.format("Creating " + this + ", length: %.2f", length));
	}
	
	public double getLength() 
	{
		return  enteringJunction.calcDistance(exitingJunction);
	}

	@Override
	public String toString() 
	{
		return "Road from " + exitingJunction + " to " + enteringJunction;
	}
	public Junction getStart()
	{
		
		return this.exitingJunction;
	}
	public Junction getEnd()
	{
		
		return this.enteringJunction;
	}
}
