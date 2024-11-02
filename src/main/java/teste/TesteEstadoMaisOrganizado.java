package teste;

import dao.EstadoDAO;
import model.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TesteEstadoMaisOrganizado {


    private static void inserir(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        Estado estado = new Estado("Amazonas", "AM");

        estadoDAO.inserir(estado);

        entityManager.close();
    }

    private static void listar(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        List<Estado> estados = estadoDAO.listar();

        for(Estado estado : estados){
            System.out.println("ID: " + estado.getId());
            System.out.println("Nome: "+estado.getNome());
            System.out.println("Sigla: " + estado.getIbge());
            System.out.println("*******************************");
        }

        entityManager.close();

    }

    private static void consultar(Long id){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        Estado estado = estadoDAO.consultar(id);

        System.out.println("ID: " + estado.getId());
        System.out.println("Nome: "+estado.getNome());
        System.out.println("Sigla: " + estado.getIbge());
        System.out.println("*******************************");

        entityManager.close();

    }

    private static void remover(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        estadoDAO.excluir(id);

        entityManager.close();
    }

    private static void alterar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        Estado estado = new Estado(2L,"Amazonas", "AM");

        estadoDAO.alterar(estado);

        entityManager.close();
    }



    public static void main(String[] args) {

        //inserir();
       // alterar();
        //listar();
        //consultar(1L);
        remover(2L);

        ConexaoUtil.fecharFabrica();
    }
}
