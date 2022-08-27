import java.util.Random;

public class SequentialTrafficLight extends TrafficLight
{
	Road currentGreen;
	private int pulseTime;
	
	
	public SequentialTrafficLight(Junction junction) 
	{
		super(junction);
		if (this.getJunction().getEnteringRoads().size() > 0)
		{
			this.currentGreen = this.getJunction().getEnteringRoads().get(0);
		}

	}

	@Override
	public void check() 
	{
		if(this.getPulseTime() == 0)
		{
			setPulseTime();
			nextGreen();
		}
	}

	@Override
	public Road getCurrentGreen() 
	{
		return currentGreen;
	}
	public void nextGreen()
	{
		int size = this.getJunction().getEnteringRoads().size();
		for (int i=0; i < size; i++)
		{
			if (this.getJunction().getEnteringRoads().get(i) == this.currentGreen) 
			{
				currentGreen = this.getJunction().getEnteringRoads().get(i++%size);
			}
		}
	}
	
	@Override
	public String toString() 
	{
		return "Sequential " + super.toString();
	}
}
