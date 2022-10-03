/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
import java.util.Random;

public class RandomTrafficLight extends TrafficLight
{
	private Road currentGreen;
	private int pulseTime;
	private final int maxVal = 4;
	private final int minVal = 2;
	
	
	public RandomTrafficLight(Junction junction) 
	{
		super(junction);
		setPulseTime();
		if (this.getJunction().getEnteringRoads().size() > 0)
		{
			this.currentGreen = this.getJunction().getEnteringRoads().get(0);
		}

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

	@Override
	public void check() 
	{
		if(this.pulseTime <= 0)
		{
			setPulseTime();
			nextGreen();
			System.out.println(currentGreen.getEnd().getTrafficLight());
		}
		this.pulseTime -= 1;
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
		this.currentGreen  = this.getJunction().getEnteringRoads().get(nextIndex);
	}
	
	@Override
	public String toString() 
	{
		return "Random " + super.toString();
	}
}
