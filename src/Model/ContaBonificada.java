package Model;

public class ContaBonificada extends Conta{
	private final double percBonus = .01;
	
	public ContaBonificada(String numero, double saldo, Tipo tipoCliente, Cliente cliente) {
		super(numero, saldo, tipoCliente, cliente);
	}

	public void renderBonus() {
		super.creditar(super.getSaldo() * percBonus);
	}
}
