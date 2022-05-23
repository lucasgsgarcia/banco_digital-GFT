import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface OperacoesOperadores {

    void transferir (Conta contaRemetente, double quantidade, Conta contaDesitno);

    void reabrirConta (Conta conta, Optional<LocalDate> data);

    void sacarParaCliente(Conta conta, double quantidade, String assinaturaCliente);

}
