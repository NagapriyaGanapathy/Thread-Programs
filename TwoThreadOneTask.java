package hit.date1july;

public class TwoThreadOneTask {
	public static void main(String[] args) {
		Canon gun =new Canon();
		Thread t=new Thread(new ShootingJob(gun),"Filler");
		Thread t1=new Thread(new ShootingJob(gun),"Shooter");
		t.start();
		t1.start();

		
	}
	
	}
class ShootingJob implements Runnable{
	Canon gun;
	public ShootingJob(Canon gun) {
		this.gun=gun;
	}
	@Override
	public void run() {
		Thread t=Thread.currentThread();
		if(t.getName().equals("Filler")) {
			for(int i=0;i<5;i++) {
			gun.fill();
			}
		}
		else if(t.getName().equals("Shooter")) {
			for(int i=0;i<5;i++) {
			gun.shot();
			}
		}
		
	}
}
class Canon{
	boolean flag;
	synchronized public void fill() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		if(flag) {
			try {
				wait();
			}catch (Exception e) {}
			
		}
		System.out.println(name+" :Fills the gun");
		flag=true;
		notify();
	}
	synchronized void shot(){
		Thread t1=Thread.currentThread();
		String name =t1.getName();
		if(!flag) {
			try {
				wait();
			}catch(Exception e) {}
		}
		
	System.out.println(name+":shot the gun");
	flag=false;
	notify();
	}
}
		