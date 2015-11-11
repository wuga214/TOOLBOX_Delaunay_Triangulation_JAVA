package structure;

public class DTriangle {

	public DPoint[] p=new DPoint[3];
	public DPoint center;
	public double radius;
	
	public DTriangle(DPoint a, DPoint b, DPoint c){
		p[0]=a;
		p[1]=b;
		p[2]=c;
		center=getCentre();
		radius=getRadius();
	}
	public DPoint getCentre(){
		double a=p[1].x-p[0].x;
		double b=p[1].y-p[0].y;
		double c=p[2].x-p[0].x;
		double d=p[2].y-p[0].y;
		double e=a*(p[0].x+p[1].x)+b*(p[0].y+p[1].y);
		double f=c*(p[0].x+p[2].x)+d*(p[0].y+p[2].y);
		double g=2.0*(a*(p[2].y-p[1].y)-b*(p[2].x-p[1].x));
		if(g==0){ return null;}
		double px=(d*e-b*f)/g;
		double py=(a*f-c*e)/g;
		return new DPoint(px,py);
		
	}
	
	public double getRadius(){
		double x=p[0].x-center.x;
		double y=p[0].y-center.y;
		return Math.sqrt(x*x+y*y);
	}
	
	public boolean inCircum(DPoint q){
		double x=q.x-center.x;
		double y=q.y-center.y;
		if(Math.sqrt(x*x+y*y)<radius){
			return true;
		}else return false;
	}
	
	public boolean hasPoint(DPoint q){
		boolean flag=false;
		for(int i=0;i<3;i++){
			if(p[i]==q){
				flag= true;
			}
		}
		return flag;
	}
	
	public String toString(){
		return "["+p[0]+","+p[1]+","+p[2]+"]\n";
	}
}
