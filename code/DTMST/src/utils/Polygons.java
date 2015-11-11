package utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JComponent;


public class Polygons  extends JComponent {
	private ArrayList<DPolygon> pgs=null;
	public Polygons(ArrayList<DPolygon> ployg){
		super();
		pgs=ployg;
	}
	public Polygons(){
		super();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for(DPolygon pg:pgs){
			Path2D path = new Path2D.Double();
			path.moveTo(pg.polygon.get(0).x, pg.polygon.get(0).y);
			for(int i = 1; i < pg.polygon.size(); ++i) {
			   path.lineTo(pg.polygon.get(i).x, pg.polygon.get(i).y);
			}
			path.closePath();
			g2.draw(path);
		}
	}
}
