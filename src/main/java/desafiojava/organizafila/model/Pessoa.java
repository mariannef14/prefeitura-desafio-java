package desafiojava.organizafila.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int idade; 
	private int posicao;
	

	public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
	
	 public void setNome(String nome) {
        this.nome = nome;
    }
	
	public int getIdade() {
        return idade;
    }
	
	 public void setIdade(int idade) {
        this.idade = idade;
    }
	
	public int getPosicao() {
        return posicao;
    }
	
	 public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}