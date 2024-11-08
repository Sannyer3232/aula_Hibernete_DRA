package teste;

import dao.GenericoDAO;
import model.Cidade;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaOneToMany {

    private static void listaCidade(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        GenericoDAO genericoDAO = new GenericoDAO(Cidade.class, entityManager);
        System.out.println(genericoDAO.consultar(1L));
    }

    public static void main(String[] args) {
        listaCidade();
    }
}
