
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, Operador operador) {
		super(cliente, operador);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
