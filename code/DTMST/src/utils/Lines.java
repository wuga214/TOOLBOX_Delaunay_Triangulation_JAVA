package utils;

import java.awt.BasicStroke;
import java.awt.Color;
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
	private HashSet<DEdge> full_edges=null;
	private HashSet<DEdge> mst_edges=null;
	private ArrayList<DPoint> p=null;
	public Lines(HashSet<DEdge> full,HashSet<DEdge> mst){
		super();
		full_edges=full;
		mst_edges=mst;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		float dash[] = { 10.0f };
		g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
		        BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
		g2.setColor(Color.gray);
		for(DEdge line:full_edges){
			Shape k = new Line2D.Double(line.p[0].x,line.p[0].y, line.p[1].x,line.p[1].y);
			g2.draw(k);
		}
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke((float) 1.5));
		for(DEdge line:mst_edges){
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
