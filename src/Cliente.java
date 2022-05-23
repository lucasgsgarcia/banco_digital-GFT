import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cliente {

	private String nome;

	private Conta conta;

	private List<Conta> contas;


}
