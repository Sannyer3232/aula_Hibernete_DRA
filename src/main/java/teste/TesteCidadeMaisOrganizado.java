package teste;

import dao.CidadeDAO;
import model.Cidade;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TesteCidadeMaisOrganizado {



    public static void inserir(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        Cidade cidade = new Cidade("Manaus", "1302603", "Amazonas");

        cidadeDAO.inserir(cidade);

        entityManager.close();
    }

    public static void listar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        List<Cidade> cidades = cidadeDAO.listar();

        for(Cidade cidade : cidades){
            System.out.println(cidade.getId());
            System.out.println(cidade.getNome());
            System.out.println(cidade.getIgbe());
            System.out.println(cidade.getEstado());
            System.out.println("************************");

        }

        entityManager.close();
    }

    public static void consultar(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        Cidade cidade = cidadeDAO.consultar(id);

        System.out.println(cidade.getId());
        System.out.println(cidade.getNome());
        System.out.println(cidade.getIgbe());
        System.out.println(cidade.getEstado());
        System.out.println("************************");

        entityManager.close();

    }

    public static void remover(Long id){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        cidadeDAO.excluir(id);

        entityManager.close();

    }


    public static void alterar(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        Cidade cidade = new Cidade( 1l ,"Manaus", "1302603", "Amazonas");

        cidadeDAO.alterar(cidade);

        entityManager.close();
    }


    public static void main(String[] args) {

        inserir();
        //consultar(1L);
        //remover(1L);
        //alterar();
        //listar();

        ConexaoUtil.fecharFabrica();
    }
}
