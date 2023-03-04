package desafiojava.organizafila.service;

import java.util.List;
import java.util.Optional;

import desafiojava.organizafila.config.exception.PessoaNaoEncontradaException;
import desafiojava.organizafila.model.Pessoa;
import desafiojava.organizafila.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPessoa(long id) throws PessoaNaoEncontradaException{
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        
        if(pessoa.isPresent())
            return pessoa.get();  
        else
           throw new PessoaNaoEncontradaException(id);
	}	
	
	public Pessoa cadastrarPessoa(Pessoa pessoa){
		int posicao = 1;

		for (Pessoa p : listarPessoas()) {
			if(p.getPosicao() != 0)
				posicao ++;
		}

		pessoa.setPosicao(posicao);
		return pessoaRepository.save(pessoa);	
	}
	
	public Pessoa atualizarCadastroPessoa(long id, Pessoa pessoaAtualizada){

		for (Pessoa p : listarPessoas()) {
			
			if(p.getPosicao() == 0)
				deletarCadastroPessoa(p.getId());
			else
				p.setPosicao(p.getPosicao() - 1);
		}

		Pessoa pessoa = buscarPessoa(id);

		return pessoaRepository.save(pessoa);	
	}
	
	public void deletarCadastroPessoa(long id){
		
		Pessoa pessoa = buscarPessoa(id);
		
		pessoaRepository.delete(pessoa);	
	}
}