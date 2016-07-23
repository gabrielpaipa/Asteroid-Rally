
public class Ship {

	private double angle;
	
	private Extent extent;
	
	private double x;
	
	private double y;

	public Ship(double x, double y, double angle){
		extent = new Extent(x,y, 0.025);
		this.angle = angle;
	}

	public void accelerate (double force){
		this.x += force * Math.cos(this.angle); 
		this.y += force * Math.sin(this.angle);
	}
	
	public Extent getExtent(){return this.extent;}
	
	public double getAngle(){return this.angle;}
	
	public double rotate(double angle){
		this.angle += angle;
		return this.angle;
	}

	public void drift(){
		this.extent.move(this.x, this.y);;
	}


}
