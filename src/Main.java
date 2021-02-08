import Repositorios.RepositorioClientesArray;
import Repositorios.RepositorioContasArray;

public class Main {

	public static void main(String[] args) {
		
		new RepositorioClientesArray();
		new RepositorioContasArray();
	
		RepositorioContasArray.getConta(0).creditar(100);
		RepositorioContasArray.getConta(1).creditar(50);
		
		mostraContas();
		
		RepositorioContasArray.getConta(0).transferir(RepositorioContasArray.getConta(1), 50);
		
		mostraContas();
		
		System.out.println(RepositorioContasArray.procurar("38243-7"));
		System.out.println(RepositorioClientesArray.procurar("93826763522-09"));
	}
	
	private static void mostraContas() {
		for(int c = 0; c < RepositorioContasArray.getTamanhoAtual(); c++) {
			System.out.println(RepositorioContasArray.getConta(c).toString());
		}
		
		System.out.println("\n");
	}
}
