package Model;

public class Poupanca extends Conta {
	private static double rentabilidade;

	public Poupanca(double rentabilidade) {
		super();
		this.rentabilidade = rentabilidade;
	}

	public Poupanca(String numero, double saldo, Tipo tipoCliente, Cliente cliente) {
		super(numero, saldo, tipoCliente, cliente);
		// TODO Auto-generated constructor stub
	}

	public double getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(double rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public void renderJuros() {
		if (this.rentabilidade > 0) {
			super.creditar(super.getSaldo() * this.rentabilidade / 100);
		}
	}
}
