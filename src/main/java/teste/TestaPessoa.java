package teste;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoa {

    private static void persistir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa("Fani Tamires","92999827524", "carvalhosannyer@gmail.com", "03536054250");

        em.getTransaction().begin();

        em.persist(pessoa);

        em.getTransaction().commit();

        em.close();

        fabrica.close();
    }

    private static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

       String consulta = "select p from Pessoa p";

       Query query= em.createQuery(consulta);

       List<Pessoa> pessoas = query.getResultList();

       for(Pessoa pessoa: pessoas){
           System.out.println(pessoa.getId());
           System.out.println(pessoa.getNome());
           System.out.println(pessoa.getEmail());
           System.out.println(pessoa.getTelefone());
           System.out.println(pessoa.getCpf());
           System.out.println("*********************************");
       }


        em.close();

        fabrica.close();
    }

    private static void consultar(long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

        Pessoa pessoa= em.find(Pessoa.class, id);


            System.out.println(pessoa.getId());
            System.out.println(pessoa.getNome());
            System.out.println(pessoa.getEmail());
            System.out.println(pessoa.getTelefone());
            System.out.println(pessoa.getCpf());
            System.out.println("*********************************");



        em.close();

        fabrica.close();
    }

    private static void remover(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

        Pessoa pessoa= em.find(Pessoa.class, id);

        em.getTransaction().begin();
        em.remove(pessoa);

        em.getTransaction().commit();
        em.close();

        fabrica.close();



    }

    private static void alterar(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

        Pessoa pessoa= em.find(Pessoa.class, id);

        em.getTransaction().begin();

        pessoa.setEmail("nerysannyer@gmail.com");
        pessoa.setNome("Sannyer Cardoso Alterado");

        em.persist(pessoa);
        em.getTransaction().commit();

        em.close();

        fabrica.close();


    }

    private static void mesclar(Long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Banco01PU");
        EntityManager em = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Sannyer Cardoso");
        pessoa.setTelefone("9982-7524");
        pessoa.setEmail("carvalhosannyer@gmail.com");

        em.getTransaction().begin();

        em.merge(pessoa);

        em.getTransaction().commit();

        em.close();

        fabrica.close();

        System.out.println("Nome: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getTelefone());
    }



    public static void main(String[] args){

        //persistir();
        //consultar(2L);
        //remover(3L);
        //alterar(4L);
        //mesclar(4L);
        //listar();
    }
}
