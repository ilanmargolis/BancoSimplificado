package Model;

public class Conta {

	private String numero;
	private double saldo;
	private Tipo tipoCliente;
	private Cliente cliente;

	public Conta() {
	}

	public Conta(String numero, double saldo, Tipo tipoCliente, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.tipoCliente = tipoCliente;
		this.cliente = cliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Tipo getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(Tipo tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void creditar(double valor) {
		this.saldo += valor;
	}

	public boolean debitar(double valor) {
		if (this.getSaldo() >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}

	public void transferir(Conta conta, double valor) {
		if (this.debitar(valor)) {
			conta.creditar(valor);
		} else {
			System.out.println("Saldo da conta de origem é insuficiente para o valor a ser transferido");
		}
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente + ", Tipo=" + "]";
	}

}
