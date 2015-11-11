package utils;

import java.util.ArrayList;
import java.util.HashSet;

import structure.DPoint;
import utils.ConvexHull;

public class DPolygon {

	public ArrayList<DPoint> polygon;

	public DPolygon(ArrayList<DPoint> set){
		polygon=ConvexHull.getPolygon(set);
	}
	public String toString(){
		return polygon.toString();
	}
}
