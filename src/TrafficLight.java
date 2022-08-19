

public class TrafficLight
{
	private int pulseTime;

	public TrafficLight(int pulseTime) 
	{
		super();
		this.pulseTime = pulseTime;
	}
	
	public TrafficLight() 
	{
		pulseTime = 1;
	}

	public int getPulseTime() 
	{
		return pulseTime;
	}

	public void setPulseTime(int pulseTime) {
		this.pulseTime = pulseTime;
	}

	@Override
	public String toString() 
	{
		return "TrafficLight [pulseTime=" + pulseTime + "]";
	}
	
	
}
