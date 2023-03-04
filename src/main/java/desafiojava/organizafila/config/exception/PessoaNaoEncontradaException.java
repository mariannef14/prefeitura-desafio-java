package desafiojava.organizafila.config.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends RuntimeException{

	public PessoaNaoEncontradaException(long id){
		super("A pessoa(" + id + ") não foi encontrado");
	}
}