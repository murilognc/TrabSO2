public class Passarinho implements Runnable{
	
	   int idpas;
	   private  BoundedBufferPassarinho buffer;

	   public Passarinho(BoundedBufferPassarinho b, int idpas) {
	      buffer = b;
	      this.idpas = idpas;
	   }
	   
	   public void run()
	   {
	         System.out.println(SleepUtilities.horario()  + ": O passarinho " + idpas + 
	        		 " chegou à margem pela primeira vez [" + BoundedBufferPassarinho.contadorP(0) + " passarinhos]");

	         while(buffer.insert(idpas)){	 
	        	//Se entrar -> Falhou em beber água
	        	
	        	System.out.println(SleepUtilities.horario()  + ": O passarinho " + idpas + 
	        			" teve que ir embora porque há muitos turistas [" + BoundedBufferPassarinho.contadorP(0) + " passarinhos]");

	        	try { SleepUtilities.voltarP(); } 
	        	catch (InterruptedException e) { e.printStackTrace(); }
	        	
				System.out.println(SleepUtilities.horario() + ": O passarinho " + idpas 
						+ " voltou à margem da piscina [" + BoundedBufferPassarinho.contadorP(0) + " passarinhos]");
	         }
	         
	         //Se chegou até aqui é porque tem espaço na piscina para ele beber água
	         buffer.remove(idpas);

	   }
}
