package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import structure.DEdge;
import structure.DPoint;

public class Kruskal {
	
	public ArrayList<DEdge> edges;
	public ArrayList<DPoint> points;
	public Kruskal(ArrayList<DPoint> p, HashSet<DEdge> e){
		getEdgesWeights(e);
		sort(e);
		points=p;
	}
	public void getEdgesWeights(HashSet<DEdge> e){
		for(DEdge i:e){
			i.getWeight();
		}
	}
	public void sort(HashSet<DEdge> e){
		edges=new ArrayList<DEdge>(e);
		Collections.sort(edges);
	}
	
	public HashSet<DEdge> getMST(){
		ArrayList<HashSet<DPoint>> components=new ArrayList<HashSet<DPoint>>();
		for(DPoint p:points){
			HashSet<DPoint> set=new HashSet<DPoint>();
			set.add(p);
			components.add(set);
		}
		HashSet<DEdge> mst=new HashSet<DEdge>();
		for(int i=0;i<edges.size();i++){
			DPoint p0=edges.get(i).p[0];
			DPoint p1=edges.get(i).p[1];
			int indexp0=0;
			int indexp1=0;
			for(int j=0;j<components.size();j++){
				if(components.get(j).contains(p0)){indexp0=j;};
				if(components.get(j).contains(p1)){indexp1=j;};
			}
			
			if(indexp0!=indexp1){
				mst.add(edges.get(i));
				HashSet<DPoint> merge=components.get(indexp0);
				merge.addAll(components.get(indexp1));
				if(indexp1>indexp0){
					components.remove(indexp1);
					components.remove(indexp0);
				}else{
					components.remove(indexp0);
					components.remove(indexp1);
				}
				components.add(merge);
			}
		}
		return mst;
	}

}
