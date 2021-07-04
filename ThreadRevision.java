package hit.date30june;

public class ThreadRevision {
	public ThreadRevision() {
		Thread threadjob=new Thread(new ThreadJob());
		threadjob.start();
	}
	public static void main(String[] args) throws Exception{
		new ThreadRevision();
		Thread t=Thread.currentThread();
		//System.out.println(t);
		for(int i=0;i<5;i++) {
			Thread.sleep(1000);
			System.out.println(i);
		}
		//new ThreadRevision();
	}

}
class ThreadJob implements Runnable{
	@Override
	public void run() {
		System.out.println("child thread called");
		
	}
}








