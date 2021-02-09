package Repositorios;

import Model.Conta;
import Model.ContaBonificada;
import Model.Poupanca;
import Model.Tipo;

public class RepositorioContasArray {

	private static int tamanhoCache;
	private static int tamanhoAtual;
	private static Conta contaList[];

	public RepositorioContasArray() {
		tamanhoCache = 100;
		tamanhoAtual = 0;

		contaList = new Conta[tamanhoCache];
	}

	public static Conta getConta(int index) {
		return contaList[index];
	}

	public static void inserir(Conta conta) {
		contaList[tamanhoAtual++] = conta;
	}

	public static void gerarContas(Object obj) {

		if (obj.equals(Conta.class)) {
			inserir(new Conta("38273-7", 250, Tipo.CLASS, RepositorioClientesArray.getCliente(0)));
			inserir(new Conta("90551-2", 450, Tipo.VIP, RepositorioClientesArray.getCliente(1)));
		} else if (obj.equals(Poupanca.class)) {
			inserir(new Poupanca("1892-2", 100, Tipo.ESPECIAL, RepositorioClientesArray.getCliente(2)));
			inserir(new Poupanca("21093-4", 200, Tipo.VIP, RepositorioClientesArray.getCliente(3)));
		} else if (obj.equals(ContaBonificada.class)) {
			inserir(new ContaBonificada("54435-1", 300, Tipo.CLASS, RepositorioClientesArray.getCliente(1)));
			inserir(new ContaBonificada("19023-3", 400, Tipo.ESPECIAL, RepositorioClientesArray.getCliente(2)));
		}
	}

	public static int procurarIndice(String numero) {

		int index = 0;

		for (Conta c : contaList) {
			if (c != null && c.getNumero().equals(numero)) {
				return index;
			} else {
				index++;
			}
		}

		return -1;
	}

	public boolean existe(String numero) {
		return (procurarIndice(numero) >= 0);
	}

	public static Conta procurar(String numero) {
		int index = procurarIndice(numero);

		if (index == -1) {
			System.out.println("Conta não existe");
			return null;
		} else {
			return contaList[index];
		}
	}

	public static void atualizar(Conta novaConta) {
		int index = procurarIndice(novaConta.getNumero());

		if (index == -1) {
			System.out.println("Conta não existe");
		} else {
			contaList[index] = novaConta;
		}
	}

	public static void remover(String numero) {
		int index = procurarIndice(numero);

		if (index == -1) {
			System.out.println("Conta não existe");
		} else {
			contaList[index] = null;
		}
	}

	public int getTamanhoCache() {
		return tamanhoCache;
	}

	public void setTamanhoCache(int tamanho) {
		tamanhoCache = tamanho;
	}

	public static int getTamanhoAtual() {
		return tamanhoAtual;
	}

	public static void setTamanhoAtual(int tamanho) {
		tamanhoAtual = tamanho;
	}
}
