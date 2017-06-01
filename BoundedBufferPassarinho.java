public class BoundedBufferPassarinho{

	public BoundedBufferPassarinho(int BUFFER_SIZES, int MAXPAS) {
	      count = 0;
	      
	      mutex = new Semaphore(1);
	      empty = new Semaphore(MAXPAS);
	      full = new Semaphore(0);
	}
	   private Semaphore mutex;
	   public Semaphore empty;
	   private Semaphore full;

	   static int count;

	   public static synchronized int contadorP(int condicao){
		   if(condicao == 0) return count;
		   
		   else if (condicao == 1) return ++count;
		   
		   else return --count;

	   } 
	   public boolean insert(int passInt) {
	      empty.acquire();
	      mutex.acquire();

	      if(Factory.maxtur == BoundedBufferTurista.contadorT(0)){ //Se a piscina estiver cheia de turistas, passarinho não beberá
	    	  mutex.release();
	    	  empty.release();
	    	  return true;
	      }

	      System.out.println(SleepUtilities.horario()  + ": O passarinho " + passInt + 
	    		  " começou a beber água da piscina [" + contadorP(1) + " passarinhos]");

	      mutex.release();
	      full.release();
	      
	      try { SleepUtilities.beber(); } 
	      catch (InterruptedException e) { e.printStackTrace();	}
	      return false;
	   }

	   public void remove(int passInt) {
	      full.acquire();
	      mutex.acquire();

	      System.out.println(SleepUtilities.horario()  + ": O passarinho " + passInt + 
	    		  " já bebeu água da piscina e não volta mais [" + contadorP(2) + " passarinhos]");
	      
	      mutex.release();
	      empty.release();
	   }
}
