package teste;

import dao.PessoaDAO;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoaMaisOrganizado {

    private static void persistir(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

       Pessoa pessoa = new Pessoa("Sannyer Cardoso","92999827524", "nerysannyer@gmail.com", "03536054251");

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        pessoaDAO.inserir(pessoa);

        entityManager.close();
    }

    private static void listar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        List<Pessoa> pessoas = pessoaDAO.listar();

        for(Pessoa pessoa: pessoas){
           System.out.println(pessoa.getId());
           System.out.println(pessoa.getNome());
           System.out.println(pessoa.getEmail());
           System.out.println(pessoa.getTelefone());
           System.out.println(pessoa.getCpf());
           System.out.println("*********************************");
        }

        entityManager.close();
    }

    private static void consultar(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        Pessoa pessoa= pessoaDAO.consutar(id);

        System.out.println(pessoa.getId());
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getEmail());
        System.out.println(pessoa.getTelefone());
        System.out.println(pessoa.getCpf());
        System.out.println("*********************************");

        entityManager.close();


    }

    private static void remover(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        pessoaDAO.excluir(id);

        entityManager.close();
    }

    private static void alterar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        Pessoa pessoa = new Pessoa(1L,"03536054250", "Fani Alterado", "92999827524", "carvalhosannyer@gmail.com");

        pessoaDAO.alterar(pessoa);

        entityManager.close();

    }

    private static void mesclar(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Sannyer Cardoso");
        pessoa.setTelefone("9982-7524");
        pessoa.setEmail("carvalhosannyer@gmail.com");

        entityManager.getTransaction().begin();

        entityManager.merge(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();


        System.out.println("Nome: " + pessoa.getId());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getTelefone());
    }



    public static void main(String[] args){

        persistir();
        //consultar(2L);
        //remover(3L);
        //alterar(4L);
        //mesclar(4L);
        //listar();

        ConexaoUtil.fecharFabrica();
    }
}
