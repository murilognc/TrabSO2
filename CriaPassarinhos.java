
public class CriaPassarinhos implements Runnable{

	public void run() {
		BoundedBufferPassarinho bufferPassarinhos = new BoundedBufferPassarinho(Factory.numpas, Factory.maxpas);
		Thread[] producerThread = new Thread[Factory.numpas]; 
		
		for(int b = 0; b < Factory.numpas; b++){
  			producerThread[b] = new Thread(new Passarinho(bufferPassarinhos, b));
  			producerThread[b].start();
  			
  			try { SleepUtilities.voltarP();}
  			catch (InterruptedException e) { e.printStackTrace(); }
  			
  		}
		synchronized(producerThread){
			for(int b = 0; b < producerThread.length; b++){
					try { producerThread[b].join(); } 
					catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
		
	}
}
