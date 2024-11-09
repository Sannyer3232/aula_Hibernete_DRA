package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Interesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "interesses", fetch = FetchType.EAGER)
    private List<Pessoa> pessoas = new ArrayList<>();

    public Interesse() {
    }

    public Interesse(String nome) {
        this.nome = nome;
    }

    public Interesse(Long id, String nome, List<Pessoa> pessoas) {
        this.id = id;
        this.nome = nome;
        this.pessoas = pessoas;
    }

    public Interesse(String nome, List<Pessoa> pessoas) {
        this.nome = nome;
        this.pessoas = pessoas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
        for(Pessoa pesssoa : pessoas){
            pesssoa.addInteresse(this);
        }
    }

    public void addPessoa(Pessoa pessoa){
        if(!this.pessoas.contains(pessoa)){
            this.pessoas.add(pessoa);
            pessoa.getInteresses().add(this);
        }
    }
}
