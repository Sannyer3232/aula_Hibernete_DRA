package teste;

import dao.GenericoDAO;
import model.Cidade;
import model.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaGenericoDAO {

    private static void inserirEstado(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Cidade.class,entityManager);

        Estado estado = new Estado("Pará", "1234567");

        genricoDAO.inserir(estado);

        entityManager.close();
    }

    private static void listarEstados(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class, entityManager);

        List<Estado> estados = genricoDAO.listar();

        for(Estado estado : estados){
            System.out.println(estado.getNome());
        }
    }


    public static void main(String[] args) {

        //inserirEstado();
        listarEstados();

    }
}
