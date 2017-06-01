
public class CriaTuristas implements Runnable{

	public void run() {
		BoundedBufferTurista bufferTuristas = new BoundedBufferTurista(Factory.numtur, Factory.maxtur);
		Thread[] producerThread = new Thread[Factory.numtur];
  		for(int a = 0; a < Factory.numtur; a++){
      		producerThread[a] = new Thread(new Turista(bufferTuristas, a));
      		producerThread[a].start();
      		
      		try { SleepUtilities.proxTur(); } 
      		catch (InterruptedException e) { e.printStackTrace(); }
  		}
		synchronized(producerThread){
			
			for(int b = 0; b < producerThread.length; b++){
				try { producerThread[b].join(); } 
				catch (InterruptedException e) { e.printStackTrace();	}
			}
			
		}
	}
}
