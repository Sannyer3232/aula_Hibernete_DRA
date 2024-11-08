package dao;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenericoDAO<Tipo> {

    private EntityManager entityManager;
    private Class<Tipo> classe;

    public GenericoDAO(Class<Tipo> classe, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.classe = classe;
    }

    public void inserir(Tipo objeto){
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
    }

    public Tipo consultar(Long id){
        return entityManager.find(classe, id);

    }

    public List<Tipo> listar(){

        String consulta = "select o from " + classe.getName() + " o";

        Query query= entityManager.createQuery(consulta);

        return query.getResultList();

    }

    public void alterar(Tipo objeto){

        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();

    }

    public void remover(Long id){

        Tipo objeto = consultar(id);
        entityManager.getTransaction().begin();
        entityManager.remove(objeto);
        entityManager.getTransaction().commit();

    }
}
