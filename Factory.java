import java.util.Scanner;

public class Factory
{
	static int camtur, aguatur, numtur, intertur, maxtur;

	static int idpas, numpas, maxpas, interpas, beberpas;
	
	public static void main(String args[]) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		String valores = input.nextLine();
		Scanner separador = new Scanner(valores);
		
		numtur = separador.nextInt(); //Número de turistas
		intertur = separador.nextInt(); //Valor para banhista iniciar trajeto
		
		camtur = separador.nextInt(); // Tempo de demora para chegar a margem da piscina
		maxtur = separador.nextInt(); // Máximo de turistas dentro da piscina

		aguatur = separador.nextInt(); // Tempo para cada turista dentro da piscina
		numpas = separador.nextInt(); //Número de pássaros
		
		interpas = separador.nextInt(); // Valor para passaro iniciar trajeto
		maxpas = separador.nextInt(); // Máx pássaros que podem estar bebendo água
		beberpas = separador.nextInt(); // Tempo para beber água

		//10 3 3 4 15 20 4 4 5
		System.out.println(SleepUtilities.horario()  + ": Início da observação [" + 
				BoundedBufferTurista.contadorT(0) + " turistas e " + BoundedBufferPassarinho.contadorP(0) + " passarinhos]");

		int n = 2; 
		Thread[] threadsCriadoras = new Thread[n];
		threadsCriadoras[0] = new Thread(new CriaTuristas());
		threadsCriadoras[1] = new Thread(new CriaPassarinhos()); 

		for(int a = 0; a < n; a++) threadsCriadoras[a].start();

		for(int a = 0; a < n; a++) threadsCriadoras[a].join();

		System.out.println(SleepUtilities.horario()  + ": Término da observação [" + BoundedBufferTurista.contadorT(0) 
				+ " turistas e " + BoundedBufferPassarinho.contadorP(0) + " passarinhos]");
		
		input.close();
		separador.close();
	}
}
