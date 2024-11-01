package teste;

import dao.CidadeDAO;
import dao.PessoaDAO;
import model.Cidade;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaPessoaComCidade {


    public static void inserirNovaPessoaNovaCidade(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        Cidade cidade = new Cidade("Manacapuru","1302504","Amazonas");

        Pessoa pessoa = new Pessoa("Irismar Ferreira de Carvalho","92999827524", "carvalhoirismar@gmail.com", "03536054289");

        cidadeDAO.inserir(cidade);

        pessoa.setCidade(cidade);

        pessoaDAO.inserir(pessoa);

        entityManager.close();
    }

    public static void inserirNovaPessoaComCidadeNoBD(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        Cidade cidade = cidadeDAO.consultar(2L);

        Pessoa pessoa = new Pessoa("Eduardo Teixeira Nery","92999827524", "neryeduardo@gmail.com", "03537054289");

        pessoa.setCidade(cidade);

       pessoaDAO.inserir(pessoa);

       entityManager.close();
    }
    public static void main(String[] args) {

        inserirNovaPessoaNovaCidade();
        //inserirNovaPessoaComCidadeNoBD();

        ConexaoUtil.fecharFabrica();
    }
}
