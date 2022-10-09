/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */

public abstract class TrafficLight implements Dynamic
{
	private int pulseTime;
	private Junction junction;
	private final int maxVal = 4;
	private final int minVal = 2;

	public abstract int getPulseTime();

	public abstract void setPulseTime();
	
	public abstract void executeTurn();
	
	public abstract Road getCurrentGreen();
	
	public TrafficLight(Junction junction) 
	{
		super();
		this.junction = junction;
	}
	
	public Junction getJunction() 
	{
		return junction;
	}

	public void setJunction(Junction junction)
	{
		this.junction = junction;
	}

	@Override
	public String toString() 
	{
		return "TrafficLights Junction " + this.junction.getJunctionNum() + ", delay= " + getPulseTime()+ ": green light on " + this.getCurrentGreen();
	}
	

}
