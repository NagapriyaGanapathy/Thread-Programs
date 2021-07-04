package hit.date29june;

public class ThreadClass2 {
	/*Objectives of this exercise
	 * How to make two threads work on a single object?
	 * How to create two threads and assign two jobs?
	 * How to control threads?
	 */
	
		public static void main(String[] args) {
			Thread t=Thread.currentThread();
			t.setName("priya");
			System.out.println("Reservation counter starting working  "+t.getName());
			
			ReservationCounter central=new ReservationCounter();
			
			Thread sri =new Thread(new BookingJob(central,1000),"sri");
			Thread madhu = new Thread(new BookingJob(central,500),"madhu");
			sri.start();
			madhu.start();
			
		}
}
class BookingJob implements Runnable{
	ReservationCounter central ;int amt;
	public BookingJob(ReservationCounter central,int amt) {
		this.central=central;
		this.amt=amt;
	}
	@Override
	public void run() {
		central.bookTicket(amt);
		central.getChange();
		
		
	}
}
class ReservationCounter{
	int amt;
	public void bookTicket(int amt){
		Thread t =Thread.currentThread();
		this.amt=amt;
	    String name=t.getName();
	    System.out.println(name+"has come to book ticket");
	    System.out.println(name+"brought.."+amt);
		
	}
	public void getChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+"has get chage");
		System.out.println(name+"takes .."+(amt-100));
	}
}
			
