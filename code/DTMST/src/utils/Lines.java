package utils;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import structure.DEdge;
import structure.DPoint;


public class Lines extends JComponent{
	private HashSet<DEdge> l=null;
	private ArrayList<DPoint> p=null;
	public Lines(HashSet<DEdge> edges){
		super();
		l=edges;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for(DEdge line:l){
			Shape k = new Line2D.Double(line.p[0].x,line.p[0].y, line.p[1].x,line.p[1].y);
			g2.draw(k);
		}
//		g2.setStroke(new BasicStroke(3));
//		for(DPoint point:p){
//			Shape k = new Line2D.Double(point.x,point.y, point.x,point.y);
//			g2.draw(k);
//		}
	}
}
