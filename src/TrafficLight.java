import java.util.Random;

public abstract class TrafficLight
{
	private int pulseTime;
	private Junction junction;
	final int maxVal = 4;
	final int minVal = 2;

	public TrafficLight(Junction junction) 
	{
		super();
		setPulseTime();
		this.junction = junction;
	}

	public int getPulseTime() 
	{
		return pulseTime;
	}

	public void setPulseTime() 
	{
		Random rand = new Random();
		pulseTime = rand.nextInt(maxVal-minVal+1) + minVal;
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
	
	public abstract void check();
	public abstract Road getCurrentGreen();

	
	
	
}
