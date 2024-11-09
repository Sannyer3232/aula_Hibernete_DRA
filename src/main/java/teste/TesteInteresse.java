package teste;

import dao.GenericoDAO;
import model.Interesse;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TesteInteresse {

    public static void main(String[] args) {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        GenericoDAO<Pessoa> pessoaGenericoDAO = new GenericoDAO<>(Pessoa.class, entityManager);
        GenericoDAO<Interesse> interesseGenericoDAO = new GenericoDAO<>(Interesse.class, entityManager);


        Interesse i1 = interesseGenericoDAO.consultar(3L);
        i1.setPessoas(pessoaGenericoDAO.listar());
        interesseGenericoDAO.alterar(i1);

        entityManager.close();
        ConexaoUtil.fecharFabrica();

    }

}
