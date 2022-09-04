import java.util.Random;

public class RandomTrafficLight extends TrafficLight
{
	Road currentGreen;
	private int pulseTime;
	
	
	public RandomTrafficLight(Junction junction) 
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
		if(this.getPulseTime() <= 0)
		{
			setPulseTime();
			nextGreen();
		}
		else
		{
			pulseTime -= 1;
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
		Random rand = new Random();
		int nextIndex = rand.nextInt(size);
		Road nextGreen = this.getJunction().getEnteringRoads().get(nextIndex);
	}
	
	@Override
	public String toString() 
	{
		return "Random " + super.toString();
	}
}
