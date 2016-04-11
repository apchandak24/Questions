
public class MyThread implements Runnable{
	 int x=0;
	@Override
	public void run() {
		x++;
		System.out.println(x);
	}

}
