import lombok.Getter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
public class OperadorGerenteGeral extends Operador{

    private static int CADASTRO_OPERADOR = 1;
    protected int numero_Operador;
    private String nome;
    private String CPF;
    private String telefone;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public OperadorGerenteGeral(String nome, String CPF, String telefone) {
        super(nome, CPF, telefone);
        this.numero_Operador = CADASTRO_OPERADOR++;
        this.dataContratacao = LocalDate.now();
    }

    @Override
    public void transferir(Conta contaRemetente, double quantidade, Conta contaDesitno) {
        contaRemetente.sacar(quantidade);
        contaDesitno.depositar(quantidade);
    }

    @Override
    public void reabrirConta(Conta conta, Optional<LocalDate> date) {
        conta.dataReabertura = Optional.of(LocalDate.now());
    }

    @Override
    public void sacarParaCliente(Conta conta, double quantidade, String assinaturaCliente) {
        imprimeDadosOperacao();
        if (!assinaturaCliente.isEmpty() && conta.getCliente().getNome().equalsIgnoreCase(assinaturaCliente)){
            conta.sacar(quantidade);
        } else {
            System.out.println("Assinatura do cliente inexistente ou incorreta.");
        }
    }

    public void demitirOperador(Operador op){
        op.setDataDemissao(LocalDate.now());
    }


}
