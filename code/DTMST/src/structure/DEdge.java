package structure;

public class DEdge implements Comparable<DEdge> {
	public DPoint[] p=new DPoint[2];
	public double weight;
	
	public DEdge(DPoint a, DPoint b){
		p[0]=a;
		p[1]=b;
	}
	
	public double getWeight(){
		weight=Math.abs(p[0].value-p[1].value);
		return weight;
	}
	
	public int hashCode() {
		int hash = p[0].hashCode();
		hash = hash * p[1].hashCode();
		return hash;
	}
	
	public boolean equals(Object o){
		return this.hashCode()==o.hashCode();
	}
	
	@Override
	public int compareTo(DEdge arg0) {
		int compare = this.weight > arg0.weight ? 1 : this.weight < arg0.weight ? -1 : 0;
		return compare;
	}
	
	public String toString(){
		return "["+p[0]+","+p[1]+"]\n";
	}
}
