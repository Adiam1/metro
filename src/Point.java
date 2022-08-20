
import java.util.Random;

/*
 * Yuval Gonen, ID: 314832163
 * Adi Amshalem ID: 318784352
 */
public class Point 
{
	private double x;
	private double y;
	final int maxX = 800;
	final int maxY = 600;

	public Point(double x, double y) 
	{
		super();
	    setX(x);
	    setY(y);
	    if (!(this instanceof Junction))
		{
			System.out.println(String.format("Creating Point (%.2f, %.2f)", this.x, this.y));
		}
	}
	
	public Point() 
	{
		super();
		Random rand = new Random();
		this.x = rand.nextDouble() * maxX;
		this.y = rand.nextDouble() * maxY;
		if (!(this instanceof Junction))
		{
			System.out.println(String.format("Creating Point (%.2f, %.2f)", this.x, this.y));
		}
	}
	
	public double getX() 
	{
		return x;
	}
	public void setX(double x) 
	{
		if (validate(x, maxX)) 
		{
			this.x = x;
		}
		else
		{
			Random rand = new Random();
			this.x = rand.nextDouble() * maxX;
			System.out.println(String.format("%.2f is illegal value for x and has been replaced with %f", x, this.x));
		}
	}
	public double getY() 
	{
		return y;
	}
	public void setY(double y) 
	{
		if (validate(y, maxY))
		{
			this.y = y;
		}
		else
		{
			Random rand = new Random();
			this.y = rand.nextDouble() * maxY;
			System.out.println(String.format("%.2f is illegal value for y and has been replaced with %f", y, this.y));
		}
	}
	
	private boolean validate(double variable, int maxValue) 
	{
		return (0 <= variable && variable <= maxValue);
	}
	public double calcDistance(Point other) 
	{
		double index1 = other.x - this.x;
		double index2 = other.y - this.y;
		double total = index1 * index1 + index2 * index2;
		return Math.sqrt(total);
	}

	
}
