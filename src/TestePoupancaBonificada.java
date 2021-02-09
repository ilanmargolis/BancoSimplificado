import Model.Conta;
import Model.ContaBonificada;
import Model.Poupanca;
import Model.Tipo;
import Repositorios.RepositorioClientesArray;
import Repositorios.RepositorioContasArray;

public class TestePoupancaBonificada {

	public static void main(String[] args) {
		
		new RepositorioClientesArray();
		
		System.out.println("### Instanciando os novo tipos de conta usando as novas classes ###");
		ContaBonificada cb = new ContaBonificada("28732-0", 100, Tipo.VIP, RepositorioClientesArray.getCliente(2));
		Poupanca cp = new Poupanca("10398-0", 200, Tipo.ESPECIAL, RepositorioClientesArray.getCliente(3));
		
		System.out.println(cb.toString());
		System.out.println(cp.toString());
		
		cp.setRentabilidade(2);
		cp.renderJuros();
		cb.renderBonus();
		
		System.out.println(cb.toString());
		System.out.println(cp.toString());
				
		System.out.println("\n### Instanciando contas diferentes usando conceitos de herança ###");
		new RepositorioContasArray();
		
		RepositorioContasArray.gerarContas(Conta.class);
		RepositorioContasArray.gerarContas(Poupanca.class);
		RepositorioContasArray.gerarContas(ContaBonificada.class);

		for(int c = 0; c < RepositorioContasArray.getTamanhoAtual(); c++) {
			System.out.println(c + " -> " + RepositorioContasArray.getConta(c));
		}
		
		
		System.out.println("\n### Testando os métodos entre as contas ###");
        RepositorioContasArray.getConta(0).transferir(RepositorioContasArray.getConta(5), 150);
        ((Poupanca) RepositorioContasArray.getConta(3)).setRentabilidade(5);
        ((Poupanca) RepositorioContasArray.getConta(3)).renderJuros();
        ((ContaBonificada) RepositorioContasArray.getConta(4)).renderBonus();
        RepositorioContasArray.getConta(1).transferir(RepositorioContasArray.getConta(2), 250);
        
		for(int c = 0; c < RepositorioContasArray.getTamanhoAtual(); c++) {
			System.out.println(c + " -> " + RepositorioContasArray.getConta(c));
		}
	}

}
