package dao;

import model.Estado;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDAO {

    private EntityManager entityManager;

    public EstadoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void inserir(Estado estado){
        entityManager.getTransaction().begin();

        entityManager.persist(estado);

        entityManager.getTransaction().commit();
    }

    public List<Estado> listar(){
        String consulta = "select e from Estado e";

        Query query = entityManager.createQuery(consulta);

        return query.getResultList();
    }

    public Estado consultar(Long id){

        return entityManager.find(Estado.class, id);
    }

    public void excluir(Long id){
        entityManager.getTransaction().begin();

        Estado estado = consultar(id);

        entityManager.remove(estado);

        entityManager.getTransaction().commit();
    }

    public void alterar(Estado estado){
        entityManager.getTransaction().begin();

        Estado estadoBD = consultar(estado.getId());

        estadoBD.setNome(estado.getNome());

        estadoBD.setIbge(estado.getIbge());

        entityManager.persist(estadoBD);

        entityManager.getTransaction().commit();
    }

}
