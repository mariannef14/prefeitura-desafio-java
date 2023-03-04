package desafiojava.organizafila.controller;

import java.util.List;

import desafiojava.organizafila.dto.PessoaDTO;
import desafiojava.organizafila.model.Pessoa;
import desafiojava.organizafila.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController{

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/")
    public ResponseEntity<List<Pessoa>> listarPessoas(){

        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable long id){

        return ResponseEntity.ok(pessoaService.buscarPessoa(id));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO){

        Pessoa pessoa = new Pessoa();
        pessoa.getId();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setIdade(pessoaDTO.getIdade());
        pessoa.getPosicao();
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastrarPessoa(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarCadastroPessoa(@PathVariable long id, @RequestBody PessoaDTO pessoaAtualizadaDTO){
        
        Pessoa pessoa = pessoaService.buscarPessoa(id);

        pessoa.setNome(pessoaAtualizadaDTO.getNome());
        pessoa.setIdade(pessoaAtualizadaDTO.getIdade());
       

        return ResponseEntity.ok(pessoaService.atualizarCadastroPessoa(id, pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastroPessoa(@PathVariable long id){

        pessoaService.deletarCadastroPessoa(id);
        
        return ResponseEntity.noContent().build();
    }
}