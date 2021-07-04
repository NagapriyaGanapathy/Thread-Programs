package hit.date30june;

public class OptimisticLock {
	public static void main(String[] args) {
		CounsellingHall university=new CounsellingHall();
		Thread student1 =new Thread(new CounsellingJob(university),"student1");
		Thread student2 =new Thread(new CounsellingJob(university),"student2");
		student1.start();
		student2.start();
		
	}

}
class CounsellingJob implements Runnable{
	public CounsellingJob(CounsellingHall university) {
		this.university=university;
	}
	CounsellingHall university;
	@Override
	public void run() {
		//synchronized (university) {
			
		
		if(Thread.currentThread().getName().equals("student1")) {
		university.table1();university.table2();
		}
		else if (Thread.currentThread().getName().equals("student2")) {
		university.water();
		}
			
		
	}
}
//}
class CounsellingHall{
	synchronized void table1() {
		System.out.println("entered table1.."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
}
	synchronized void table2() {
		System.out.println("entered table2.."+Thread.currentThread().getName());
}
	public void water() {
		System.out.println("entered water.."+Thread.currentThread().getName());
		}
	
}
