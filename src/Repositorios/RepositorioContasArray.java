package Repositorios;

import Model.Conta;
import Model.Tipo;

public class RepositorioContasArray {

	private static int tamanhoCache;
	private static int tamanhoAtual;
	private static Conta contaList[];

	public RepositorioContasArray() {
		tamanhoCache = 100;
		tamanhoAtual = 0;

		contaList = new Conta[tamanhoCache];

		inserir(new Conta("38273-7", 0, Tipo.CLASS, RepositorioClientesArray.getCliente(0)));
		inserir(new Conta("90551-2", 0, Tipo.VIP, RepositorioClientesArray.getCliente(1)));
	}

	public static Conta getConta(int index) {
		return contaList[index];
	}

	public static void inserir(Conta conta) {
		contaList[tamanhoAtual++] = conta;
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
