package teste;

import model.Cidade;

import javax.persistence.*;
import java.util.List;

public class TesteCidade {



    public static void inserir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = new Cidade("Manaus", "1302603", "Amazonas");

        entityManager.getTransaction().begin();

        entityManager.persist(cidade);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();
    }

    public static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        String consulta = "select c from Cidade c";

        Query query = entityManager.createQuery(consulta);

        List<Cidade> cidades = query.getResultList();

        for(Cidade cidade : cidades){
            System.out.println(cidade.getId());
            System.out.println(cidade.getNome());
            System.out.println(cidade.getIgbe());
            System.out.println(cidade.getEstado());
            System.out.println("************************");

        }
    }

    public static void consultar(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

       Cidade cidade = entityManager.find(Cidade.class, id);

        System.out.println(cidade.getId());
        System.out.println(cidade.getNome());
        System.out.println(cidade.getIgbe());
        System.out.println(cidade.getEstado());
        System.out.println("************************");


    }

    public static void remover(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = entityManager.find(Cidade.class, id);

        entityManager.getTransaction().begin();

        entityManager.remove(cidade);

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();


    }


    public static void alterar(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");

        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = entityManager.find(Cidade.class, id);

        cidade.setNome("Manaus");

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        entityManager.close();

        fabrica.close();


    }


    public static void main(String[] args) {

        //inserir();
        //consultar(1L);
        //remover(1L);
        //alterar(2L);
        listar();
    }
}
