package baseballGame;

public class theGame{
	public static void main(String[] args) throws InterruptedException {
//		player n1 = new player();
//		player n2= new player();
	Thread t1 = new Thread(new baseball(new player(), new player()));
	t1.start();
//	Thread t2 = new Thread(new baseball(n1, n2));
//		t2.start();
//		t2.join();
//		
//	Thread t3 = new Thread(new baseball(n2, n1));
//		t3.start();
//		t3.join();
//
	}
}