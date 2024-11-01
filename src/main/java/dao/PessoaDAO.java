package dao;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO {

    private EntityManager entityManager;

    public void inserir(Pessoa pessoa){
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }

    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Pessoa consutar(Long id){
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listar(){

        String consulta = "select p from Pessoa p";

        Query query= entityManager.createQuery(consulta);

        return query.getResultList();
    }

    public void excluir(Long id){

        entityManager.getTransaction().begin();

        Pessoa pessoa= entityManager.find(Pessoa.class, id);

        entityManager.remove(pessoa);

        entityManager.getTransaction().commit();

    }

    public void alterar(Pessoa pessoa){

        entityManager.getTransaction().begin();

        Pessoa pessoaBD= entityManager.find(Pessoa.class, pessoa.getId());

        pessoaBD.setEmail(pessoa.getEmail());

        pessoaBD.setNome(pessoa.getNome());

        pessoaBD.setCpf(pessoa.getCpf());

        pessoaBD.setTelefone(pessoa.getTelefone());

        entityManager.persist(pessoaBD);

        entityManager.getTransaction().commit();

    }


}
