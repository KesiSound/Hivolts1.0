
public class Barrier {
	
	private int barrierX;
	private int barrierY;
	private int widthBarrier;

	//constructor
	
	public Barrier(int barrierX, int barrierY, int widthBarrier){
		this.barrierX = barrierX;
		this.barrierY = barrierY;
		this.widthBarrier = widthBarrier;
	}
	
	//getters
	public int getBarrierX(){
		return this.barrierX;
	}
	
	public int getBarrierY(){
		return this.barrierY;
	}
	
	public int getBarrierWidth(){
		return this.widthBarrier;
	}
	
	
	//setters
	public int setBarrierX(int barrierx){
		this.barrierX = barrierx;
		return barrierX;
	}
	
	public int setBarrierY( int barriery){
		this.barrierY = barriery;
		return barrierY;
	}
	
	
	
}
