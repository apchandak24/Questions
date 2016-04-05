import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestPoints {
	
	public KClosestPoints() {
		ArrayList<Point> points  = new ArrayList<>();
		
		 	points.add(new Point(1, 1));
	        points.add(new Point(1, 3));
	        points.add(new Point(-1, 1));
	        points.add(new Point(-1, 3));
	        points.add(new Point(1, -1));
	        points.add(new Point(3, -1));
	        points.add(new Point(-1, -1));
	        points.add(new Point(-1, 3));
	        points.add(new Point(2, 2));
		
		int k=5;
		findKClosestPair(k,points);
	}

	private void findKClosestPair(int k,ArrayList<Point> points) {
		PriorityQueue<Point> queue = new PriorityQueue<>(k);
		for(Point p:points){
			
			if(queue.size()<k){
				queue.offer(p);
			}else{
				if(queue.peek().getDistance()>p.getDistance()){
					queue.poll();
					queue.offer(p);
				}
			}
		}
		
		for(Point p:queue){
			System.out.println(p.x+" "+p.y);
		}
	}
	

}
class Point implements Comparable<Point>{
	double x;
	double y;
	public Point(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public double getDistance(){
		return Math.sqrt(x*x + y*y);
	}
	
	@Override
	public int compareTo(Point o) {
		return Double.compare(o.getDistance(), this.getDistance());
	}
	
	
}
