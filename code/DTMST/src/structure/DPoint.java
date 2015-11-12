package structure;

public class DPoint {

	public double x;
	public double y;
	public double value;
	public DPoint(double xs,double ys){
		x=xs;
		y=ys;
	}
	public DPoint(double xs,double ys,double vl){
		x=xs;
		y=ys;
		value=vl;
	}
	
	public String toString(){
		return "("+x+","+y+") ";
	}
}
