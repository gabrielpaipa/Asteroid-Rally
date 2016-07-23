
public class Extent {

	/** This extent's x. */
	private double x;
	
	/** This extent's y. */
	private double y;
	
	/** This extent's radius. */
	private double radius;
	
	/** 
	 * 
	 * @param x
	 * 		The x of this extent.
	 * @param y
	 * 		The y of this extent.
	 * @param radius
	 * 		The radius of this extent.
	 */
	public Extent(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**
	 * Moves this instance's x and y.
	 * 
	 * @param addX
	 * 		The amount to add to x.
	 * @param addY
	 * 		The amount to add to y.
	 */
	public void move(double addX, double addY) {
		this.x = this.x + addX;
		if(this.x > 1.0) {
			this.x = this.x - 1.0;
		} else if(this.x < 0.0) {
			this.x = this.x + 1.0;
		}
		this.y = this.y + addY;
		if(this.y > 1.0) {
			this.y = this.y - 1.0;
		} else if(this.y < 0.0) {
			this.y = this.y + 1.0;
		}
	}
	
	/** 
	 * Returns the distance between two extents.
	 * 
	 * @param b
	 * 		The parameter in question.
	 */
	public double distanceTo(Extent b) {
		double x = this.x - b.x;
	    double y = this.y - b.y;
	    return Math.sqrt((x * x) + (y * y));
	}
	
	/** Returns the x value. */
	public double getX() {
		return this.x;
	}
	
	/** Returns the y value. */ 
	public double getY() {
		return this.y;
	}
	
	/** Returns the radius */
	public double getRadius() {
		return this.radius;
	}

	/** 
	 * 
	 * @param extent
	 * 		The circle in question
	 * @return
	 * 		Returns true if they do overlap
	 */
	public boolean overlaps(Extent extent) {
		if(this.distanceTo(extent) < (this.radius + extent.radius)){
			return true;
		} else {
			return false;	
		}
	}

	
}
