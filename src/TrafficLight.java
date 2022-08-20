import java.util.Random;

public class TrafficLight
{
	private int pulseTime;
	private Junction junction;
	final int maxVal = 4;
	final int minVal = 2;

	public TrafficLight(int pulseTime, Junction junction) 
	{
		super();
		this.junction = junction;
		if(pulseTime <= maxVal && minVal <= pulseTime)
		{
			this.pulseTime = pulseTime;
		}
		else 
		{
			pulseTime = calcPulse();
		}

	}
	
	public TrafficLight() 
	{
		this.junction = null;
		pulseTime = calcPulse();
	}

	public int getPulseTime() 
	{
		return pulseTime;
	}

	public void setPulseTime(int pulseTime) 
	{
		this.pulseTime = pulseTime;
	}

	@Override
	public String toString() 
	{
		return "TrafficLight [pulseTime=" + pulseTime + "]";
	}
	
	public int calcPulse()
	{
		Random r = new Random();
		return r.nextInt(maxVal - minVal) + minVal;
	}
	
	
	
}
