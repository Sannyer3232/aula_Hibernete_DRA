package model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pescpf",nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name ="pesnome", nullable = false)
    private String nome;
    @Column(name ="pestelefone", nullable = false)
    private String telefone;
    @Column(name="pesemail", nullable = false, unique = true)
    private String email;
    @ManyToOne
    private Cidade cidade;
    @ManyToMany
    private List<Interesse> interesses = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(long id, String cpf, String nome, String telefone, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(String cpf, String nome, String telefone, String email, Cidade cidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
        cidade.addPessoa(this);
    }

    public List<Interesse> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Interesse> interesses) {

        this.interesses = interesses;

        for(Interesse interesse : interesses){
            interesse.addPessoa(this);
        }
    }

    public void addInteresse(Interesse interesse){
        if(!this.interesses.contains(interesse)){
            this.interesses.add(interesse);
            interesse.addPessoa(this);
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
