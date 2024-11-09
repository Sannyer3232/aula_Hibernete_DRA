package teste;

import dao.GenericoDAO;
import model.Cidade;
import model.Estado;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaOneToMany {


    public static void main(String[] args) {

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Cidade> cidadeDAO = new GenericoDAO<>(Cidade.class, entityManager);

        GenericoDAO<Pessoa> pessoaDAO = new GenericoDAO<>(Pessoa.class, entityManager);

        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(Estado.class, entityManager);


        System.out.println("Consultando Estado");
        Cidade cidade = cidadeDAO.consultar(1L);
        System.out.println(cidade.getNome());

        System.out.println("Listando Pessoas");
        for(Pessoa pessoa : cidade.getPessoas()){
            System.out.println(pessoa.getNome());
        }
        entityManager.close();

        ConexaoUtil.fecharFabrica();

    }
}
