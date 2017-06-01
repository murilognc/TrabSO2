
public class BoundedBufferTurista{

	   private Semaphore mutex;
	   private Semaphore empty;
	   private Semaphore full;

	   static int count;

	   public static synchronized int contadorT(int condicao){
		   if(condicao == 0) return count;
		   
		   else if (condicao == 1) return ++count;
		   
		   else return --count;
	   } 
	   public BoundedBufferTurista(int BUFFER_SIZE, int MAXTUR)
	   {
	      count = 0;

	      mutex = new Semaphore(1);
	      empty = new Semaphore(MAXTUR);
	      full = new Semaphore(0);
	   }

	   public void insert(int turInt) {
	      empty.acquire();
	      mutex.acquire();

	      System.out.println(SleepUtilities.horario()  + ": O turista " + turInt + 
	    		  " entrou na piscina [" + contadorT(1) + " turistas]");

	      mutex.release();
	      full.release();
	      
	   }

	   public void remove(int turInt) {
	      full.acquire();
	      mutex.acquire();

	      System.out.println(SleepUtilities.horario()  + ": O turista " + turInt + 
	    		  " saiu da piscina [" + contadorT(2) + " turistas]");

	      mutex.release();
	      empty.release();

	   }
}
