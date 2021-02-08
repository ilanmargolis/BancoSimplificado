import Repositorios.RepositorioClientesArray;
import Repositorios.RepositorioContaArray;

public class Main {

	public static void main(String[] args) {
		
		new RepositorioClientesArray();
		new RepositorioContaArray();
	
		RepositorioContaArray.getConta(0).creditar(100);
		RepositorioContaArray.getConta(1).creditar(50);
		
		mostraContas();
		
		RepositorioContaArray.getConta(0).transferir(RepositorioContaArray.getConta(1), 50);
		
		mostraContas();
		
		System.out.println(RepositorioContaArray.procurar("38243-7"));
	}
	
	private static void mostraContas() {
		for(int c = 0; c < RepositorioContaArray.getTamanhoAtual(); c++) {
			System.out.println(RepositorioContaArray.getConta(c).toString());
		}
		
		System.out.println("\n");
	}
}
