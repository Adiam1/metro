import java.util.Random;

public class TrafficLight
{
	private int pulseTime;
	final int maxVal = 4;
	final int minVal = 2;

	public TrafficLight(int pulseTime) 
	{
		super();
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
