package delaunay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import structure.DEdge;
import structure.DPoint;
import structure.DTriangle;
import utils.DPolygon;

public class BowyerWatson {
	public ArrayList<DTriangle> triangles;
	public ArrayList<DPoint> points;
	public ArrayList<DPoint> initpoints;

	public BowyerWatson(double w,double h, ArrayList<DPoint> p){
		triangles=new ArrayList<DTriangle>();
		initial(w,h);
		for(DPoint q:p){
			run(q);
		}
	}
	
	public void initial(double w,double h){
		initpoints=new ArrayList<DPoint>();
		DPoint a=new DPoint(0,0);
		DPoint b=new DPoint(0,h);
		DPoint c=new DPoint(w,h);
		DPoint d=new DPoint(w,0);
		DTriangle tri1=new DTriangle(a,b,c);
		DTriangle tri2=new DTriangle(a,c,d);
		triangles.add(tri1);
		triangles.add(tri2);
		initpoints.add(a);
		initpoints.add(b);
		initpoints.add(c);
		initpoints.add(d);
	}
	
	public void run(DPoint p){
		ArrayList<DTriangle> bads=new ArrayList<DTriangle>();
		HashSet<DEdge> edges=new HashSet<DEdge>();
		HashSet<DEdge> toremove=new HashSet<DEdge>();
		for(int i=triangles.size()-1;i>=0;i--){
			DTriangle tri=triangles.get(i);
			if(tri.inCircum(p)){
				bads.add(tri);
				triangles.remove(i);
			}
		}
		for(DTriangle tri:bads){
			DEdge e1=new DEdge(tri.p[0],tri.p[1]);
			DEdge e2=new DEdge(tri.p[1],tri.p[2]);
			DEdge e3=new DEdge(tri.p[0],tri.p[2]);
			if(!edges.add(e1)){toremove.add(e1);};
			if(!edges.add(e2)){toremove.add(e2);};
			if(!edges.add(e3)){toremove.add(e3);};
		}
		
		for(DEdge e:toremove){
			edges.remove(e);
		}
		
		for(DEdge e:edges){
			DTriangle tri=new DTriangle(e.p[0],e.p[1],p);
			triangles.add(tri);
		}
		//System.out.println(triangles.toString());
	}
	
	public String toString(){
		String output="";
		for(DTriangle tri:triangles){
			output+=tri.toString();
		}
		return output;
	}
	
	public void reMoveBoundary(HashSet<DEdge> edges){
		Collection<DEdge> removeCandidates = new ArrayList<DEdge>();
		for(DEdge e:edges){
			boolean flag=false;
			if(e.p[0]==initpoints.get(0)||e.p[0]==initpoints.get(1)||e.p[0]==initpoints.get(2)||e.p[0]==initpoints.get(3)){
				flag=true;
			}
			if(e.p[1]==initpoints.get(0)||e.p[1]==initpoints.get(1)||e.p[1]==initpoints.get(2)||e.p[1]==initpoints.get(3)){
				flag=true;
			}
			if(flag==true){
				removeCandidates.add(e);
			}
		}
		edges.removeAll(removeCandidates);
	}
	
	public ArrayList<DPolygon> getPolygons(){
		ArrayList<DPolygon> polys=new ArrayList<DPolygon>();
		for(DTriangle tri:triangles){
			ArrayList<DPoint> set=new ArrayList<DPoint>();
			set.add(tri.p[0]);
			set.add(tri.p[1]);
			set.add(tri.p[2]);
			DPolygon poly=new DPolygon(set);
			polys.add(poly);
		}
		return polys;
	}
	
	public HashSet<DEdge> getPrunEdges(){
		HashSet<DEdge> edges=new HashSet<DEdge>();
		for(DTriangle tri:triangles){
			DEdge e1=new DEdge(tri.p[0],tri.p[1]);
			DEdge e2=new DEdge(tri.p[1],tri.p[2]);
			DEdge e3=new DEdge(tri.p[0],tri.p[2]);
			edges.add(e1);
			edges.add(e2);
			edges.add(e3);	
		}
		reMoveBoundary(edges);
		return edges;
	}
}
