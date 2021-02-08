package Repositorios;
import Model.Cliente;

public class RepositorioClientesArray {

	private int tamanhoCache;
	private static int tamanhoAtual;
	private static Cliente clienteList[];

	public RepositorioClientesArray() {
		this.tamanhoCache = 100;
		this.tamanhoAtual = 0;

		clienteList = new Cliente[tamanhoCache];

		this.inserir(new Cliente("João", "9382773827-21"));
		this.inserir(new Cliente("Maria", "23837737722-15"));
		this.inserir(new Cliente("André", "93826763522-09"));
		this.inserir(new Cliente("Gustavo", "73663552663-73"));
		this.inserir(new Cliente("Joaquim", "565635636636-32"));
	}

	public static Cliente getCliente(int index) {
		return clienteList[index];
	}

	public static void inserir(Cliente cliente) {
		RepositorioClientesArray.clienteList[tamanhoAtual++] = cliente;
	}

	public static int procurarIndice(String cpf) {

		int index = 0;

		for (Cliente c : RepositorioClientesArray.clienteList) {
			if (c != null && c.getCpf().equals(cpf)) {
				return index;
			} else {
				index++;
			}
		}

		return -1;
	}

	public boolean existe(String cpf) {
		return (procurarIndice(cpf) >= 0);
	}

	public Cliente procurar(String cpf) {
		int index = procurarIndice(cpf);

		if (index == -1) {
			System.out.println("Cliente não existe");
			return null;
		} else {
			return clienteList[index];
		}
	}

	public static void atualizar(Cliente novoCliente) {
		int index = procurarIndice(novoCliente.getCpf());

		if (index == -1) {
			System.out.println("Cliente não existe");
		} else {
			clienteList[index] = novoCliente;
		}
	}

	public void remover(String cpf) {
		int index = procurarIndice(cpf);

		if (index == -1) {
			System.out.println("Cliente não existe");
		} else {
			clienteList[index] = null;
		}
	}

	public int getTamanhoCache() {
		return tamanhoCache;
	}

	public void setTamanhoCache(int tamanhoCache) {
		this.tamanhoCache = tamanhoCache;
	}

	public static int getTamanhoAtual() {
		return tamanhoAtual;
	}

	public static void setTamanhoAtual(int tamanho) {
		tamanhoAtual = tamanho;
	}
}
