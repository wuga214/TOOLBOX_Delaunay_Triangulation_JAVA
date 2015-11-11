package structure;

public class DEdge {
	public DPoint[] p=new DPoint[2];
	
	public DEdge(DPoint a, DPoint b){
		p[0]=a;
		p[1]=b;
	}
	
	public int hashCode() {
		int hash = p[0].hashCode();
		hash = hash * p[1].hashCode();
		return hash;
	}
	
	public boolean equals(Object o){
		return this.hashCode()==o.hashCode();
	}
	
	public String toString(){
		return "["+p[0]+","+p[1]+"]\n";
	}
}
