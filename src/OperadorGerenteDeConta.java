import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class OperadorGerenteDeConta extends Operador{

    private static int CADASTRO_OPERADOR = 1;
    protected int numero_Operador;
    private String nome;
    private String CPF;
    private String telefone;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;
    private OperadorGerenteGeral operadorResponsavel;

    public OperadorGerenteDeConta(String nome, String CPF, String telefone, OperadorGerenteGeral operadorResponsavel) {
        super(nome, CPF, telefone);
        this.numero_Operador = CADASTRO_OPERADOR++;
        this.dataContratacao = LocalDate.now();
        this.operadorResponsavel = operadorResponsavel;
        this.dataDemissao = null;
    }


    @Override
    public void transferir(Conta contaRemetente, double quantidade, Conta contaDesitno) {
        checaSeAtivo();
        contaRemetente.sacar(quantidade);
        contaDesitno.depositar(quantidade);
    }

    @Override
    public void reabrirConta(Conta conta, Optional<LocalDate> date) {
        checaSeAtivo();
        conta.dataReabertura = Optional.of(LocalDate.now());
    }

    @Override
    public void sacarParaCliente(Conta conta, double quantidade, String assinaturaCliente) {
        checaSeAtivo();
        imprimeDadosOperacao();
        if (!assinaturaCliente.isEmpty() && conta.getCliente().getNome().equalsIgnoreCase(assinaturaCliente)){
            conta.sacar(quantidade);
        } else {
            System.out.println("Assinatura do cliente inexistente ou incorreta.");
        }
    }

    public void checaSeAtivo(){
        if (dataDemissao != null)
            throw new RuntimeException("Operador inativo para realizar operações!");
    }


}
