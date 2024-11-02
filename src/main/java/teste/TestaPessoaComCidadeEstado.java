package teste;

import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.PessoaDAO;
import model.Cidade;
import model.Estado;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;

public class TestaPessoaComCidadeEstado {


    public static void inserirNovaPessoaNovaCidadeNovoEstado(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        Estado estado = new Estado("Amazonas", "AM");

        Cidade cidade = new Cidade("Manacapuru","1302504");

        Pessoa pessoa = new Pessoa("Irismar Ferreira de Carvalho","92999827524", "carvalhoirismar@gmail.com", "03536054289");

        cidade.setEstado(estado);

        pessoa.setCidade(cidade);

        estadoDAO.inserir(estado);

        cidadeDAO.inserir(cidade);

        pessoaDAO.inserir(pessoa);

        entityManager.close();
    }

    public static void inserirNovaPessoaComCidadeNoBDEstadoNoBD(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);

        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

        EstadoDAO estadoDAO = new EstadoDAO(entityManager);

        Estado estado = estadoDAO.consultar(1L);

        Cidade cidade = cidadeDAO.consultar(1L);

        Pessoa pessoa = new Pessoa("Eduardo Teixeira Nery","92999827524", "neryeduardo@gmail.com", "03537054289");

        cidade.setEstado(estado);

        pessoa.setCidade(cidade);

        pessoaDAO.inserir(pessoa);

        entityManager.close();
    }
    public static void main(String[] args) {

        //inserirNovaPessoaNovaCidadeNovoEstado();
        inserirNovaPessoaComCidadeNoBDEstadoNoBD();

        ConexaoUtil.fecharFabrica();
    }
}
