package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="cidnome", nullable = false)
    private String nome;
    @Column(name = "cidibge", unique = true, nullable = false, length = 7)
    private String igbe;
    @ManyToOne
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Pessoa> pessoas = new ArrayList<>();




    public Cidade(){}

    public Cidade(Long id, String nome, String igbe) {
        this.id = id;
        this.nome = nome;
        this.igbe = igbe;
    }

    public Cidade(String nome, String igbe) {
        this.nome = nome;
        this.igbe = igbe;
    }

    public Cidade(String nome, String igbe, Estado estado) {
        this.nome = nome;
        this.igbe = igbe;
        this.estado = estado;
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

    public String getIgbe() {
        return igbe;
    }

    public void setIgbe(String igbe) {
        this.igbe = igbe;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void addPessoa(Pessoa pessoa){
        if(!this.pessoas.contains(pessoa)){
            this.pessoas.add(pessoa);
            pessoa.setCidade(this);
        }
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", igbe='" + igbe + '\'' +
                ", estado=" + estado +
                ", pessoas=" + pessoas +
                '}';
    }
}
