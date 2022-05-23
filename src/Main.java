import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws Exception {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		OperadorGerenteGeral boss = new OperadorGerenteGeral("João", "321", "123");
		Operador operador = new OperadorGerenteDeConta("Lucas", "123", "321", boss);
		Conta cc = new ContaCorrente(venilton, operador);
		Conta poupanca = new ContaPoupanca(venilton, operador);

		boss.demitirOperador(operador);

		cc.depositar(200);
		
		cc.imprimirExtrato();

		operador.sacarParaCliente(cc, 200, "venilton");
		cc.imprimirExtrato();


	}

}
