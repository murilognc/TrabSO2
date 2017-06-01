
public class Turista implements Runnable
{
   int idtur;
   public Turista(BoundedBufferTurista b, int idtur) {
      buffer = b;
      this.idtur = idtur;
   }
   
   public void run()
   {
         System.out.println(SleepUtilities.horario() + ": O turista " + idtur  + 
        		 " inicia a caminhada à piscina [" + BoundedBufferTurista.contadorT(0) + " turistas]");
         
         try { SleepUtilities.caminhar(); } 
         catch (InterruptedException e) { e.printStackTrace(); }
   
         System.out.println(SleepUtilities.horario()  + ": O turista " + idtur + 
        		 " terminou a caminhada e chegou à margem da piscina [" + BoundedBufferTurista.contadorT(0) + " turistas]");
           
         buffer.insert(idtur);
         
         try { SleepUtilities.banhar(); } 
         catch (InterruptedException e) { e.printStackTrace(); }
         
         buffer.remove(idtur);
   }
   
   private BoundedBufferTurista buffer;
}
