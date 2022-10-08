import java.util.Random;

/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
public class SequentialTrafficLight extends TrafficLight
{
	private Road currentGreen;
	private int pulseTime;
	private final int maxVal = 4;
	private final int minVal = 2;
	
	
	
	public SequentialTrafficLight(Junction junction) 
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

	public void executeTurn() 
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
		for (int i = 0; i < size; i++)
		{
			if (this.getJunction().getEnteringRoads().get(i) == this.currentGreen) 
			{
				this.currentGreen = this.getJunction().getEnteringRoads().get((i+1)%size);
				return;
			}
		}
	}
	
	@Override
	public String toString() 
	{
		return "Sequential " + super.toString();
	}
}
