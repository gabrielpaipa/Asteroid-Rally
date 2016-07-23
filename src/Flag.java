
public class Flag {

	private Extent extent;

	private boolean hasBeenHitByShip1;

	private boolean hasBeenHitByShip2;

	public Flag(double x, double y){
		extent = new Extent(x,y, 0.01);
	}

	//Why does the testGetExtent fail when using instance variables that are shared?

	public Extent getExtent() {return this.extent;}

	public boolean hasBeenHitByShip1(){
		return this.hasBeenHitByShip1;
	}

	public boolean hasBeenHitByShip2(){
		return this.hasBeenHitByShip2;
	}


	public void setHitByShip1(){
		this.hasBeenHitByShip1 = true;
	}

	public void setHitByShip2(){
		this.hasBeenHitByShip2 = true;
	}

}
