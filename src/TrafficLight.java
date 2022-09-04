/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.Random;

public abstract class TrafficLight
{
	private int pulseTime;
	private Junction junction;
	private final int maxVal = 4;
	private final int minVal = 2;

	public TrafficLight(Junction junction) 
	{
		super();
		this.junction = junction;
	}

	public abstract int getPulseTime();

	public abstract void setPulseTime(); 
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
	
	public abstract void check();
	public abstract Road getCurrentGreen();
}
