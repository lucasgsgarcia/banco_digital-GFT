import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class Operador implements OperacoesOperadores{

    private static int CADASTRO_OPERADOR = 1;
    protected int numero_Operador;
    private String nome;
    private String CPF;
    private String telefone;
    private LocalDate dataContratacao;
    private LocalDate dataDemissao;

    public Operador(String nome, String CPF, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.numero_Operador = CADASTRO_OPERADOR++;
        this.dataContratacao = LocalDate.now();
    }

    @Override
    public void transferir(Conta contaRemetente, double quantidade, Conta contaDesitno) {
        System.out.println("Operador não autorizado para essa operação.");
    }

    @Override
    public void reabrirConta(Conta conta, Optional<LocalDate> date) {
        System.out.println("Operador não autorizado para essa operação.");
    }

    @Override
    public void sacarParaCliente(Conta conta, double quantidade, String assinaturaCliente) {
        System.out.println("Operador não autorizado para essa operação.");
    }

    protected void imprimeDadosOperacao(){
        System.out.format("=== OPERADOR %s ===", this.getNome());
    }

    public void checaSeAtivo(){
        if (dataDemissao != null)
            throw new RuntimeException("Operador inativo");
    }

}
