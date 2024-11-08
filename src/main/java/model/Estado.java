package model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, unique = true)
    private String igbe;




    public Estado(){}

    public Estado(Long id, String nome, String igbe) {
        this.id = id;
        this.nome = nome;
        this.igbe = igbe;
    }

    public Estado(String nome, String igbe) {
        this.nome = nome;
        this.igbe = igbe;
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

    public String getIbge() {
        return igbe;
    }

    public void setIbge(String sigla) {
        this.igbe = sigla;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", igbe='" + igbe + '\'' +
                '}';
    }
}
