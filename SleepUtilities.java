import java.util.Date;

/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 *
 */

public class SleepUtilities
{

	public static void caminhar() throws InterruptedException{
		try{ Thread.sleep(Factory.camtur * 1000); }
		catch(InterruptedException e){ }
	}
	
	public static void banhar() throws InterruptedException{
		try{ Thread.sleep(Factory.aguatur * 1000); }
		catch(InterruptedException e){ }
	}
	
	public static void beber() throws InterruptedException{
		try{ Thread.sleep(Factory.beberpas * 1000); }
		catch(InterruptedException e){ }
	}
	
	public static void voltarP() throws InterruptedException{
		try{ Thread.sleep(Factory.interpas * 1000); }
		catch(InterruptedException e){ }
	}
	
	public static void proxTur() throws InterruptedException{
		try{ Thread.sleep(Factory.intertur * 1000); }
		catch(InterruptedException e){ }
	}
	
	public static Date horario(){
		return new Date();
	}

}
