package teste;

import dao.GenericoDAO;
import model.Cidade;
import model.Estado;
import model.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TestaGenericoDAO {

    private static void inserirEstado(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class,entityManager);

        Estado estado = new Estado("Amazonas", "1234577");

        genricoDAO.inserir(estado);

        entityManager.close();
    }

    private static void inserirEstado(Estado estado){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class,entityManager);

        genricoDAO.inserir(estado);

        entityManager.close();
    }

    public void listarEstados(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class, entityManager);

        List<Estado> estados = genricoDAO.listar();

        for(Estado estado : estados){
            System.out.println(estado);
        }
    }
    private static void alterarEstado(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class, entityManager);

        Estado estado = genricoDAO.consultar(2L);

        estado.setNome("Para Alterado");

        genricoDAO.alterar(estado);

        entityManager.close();
    }

    private static void consultarEstado(Long id){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class, entityManager);

        Estado estado = genricoDAO.consultar(id);
        System.out.println(estado);
        entityManager.close();

    }

    private static void removerEstado(Long id){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Estado> genricoDAO = new GenericoDAO<>(Estado.class, entityManager);

        genricoDAO.remover(id);

        entityManager.close();
    }

    public static void inserirCidadeNovoEstado(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(Cidade.class, entityManager);

        Estado estado = new Estado("Amazonas","4568748");

        Cidade cidade = new Cidade("Manaus","4567891", estado);

        inserirEstado(estado);

        genericoDAO.inserir(cidade);

    }

    private static void inserirCidadeEstadoNoBD(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(Cidade.class, entityManager);

        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(Estado.class, entityManager);

        Estado estado = estadoDAO.consultar(2L);

        Cidade cidade = new Cidade("Manaus","4527891", estado);

        genericoDAO.inserir(cidade);

    }

    private static void alterarCidade(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(Cidade.class, entityManager);

        GenericoDAO<Estado> estadoDAO = new GenericoDAO<>(Estado.class, entityManager);

    }

    public static void listarCidades(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Cidade> genericoDAO = new GenericoDAO<>(Cidade.class, entityManager);

        List<Cidade> cidades = genericoDAO.listar();

        for(Cidade cidade : cidades){
            System.out.println(cidade);
        }
    }

    private static void inserirPessoa(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericoDAO<Pessoa> genericoDAO = new GenericoDAO<>(Pessoa.class, entityManager);

        GenericoDAO<Cidade> cidadeDAO = new GenericoDAO<>(Cidade.class, entityManager);

        Cidade cidade = cidadeDAO.consultar(1L);

        Pessoa pessoa = new Pessoa("Fani Tamires","999827524","tamiresFani@gmail.com","03536054252");

        pessoa.setCidade(cidade);

        genericoDAO.inserir(pessoa);

        entityManager.close();

    }



    public static void main(String[] args) {

        //inserirEstado();
        //alterarEstado();
        //listarEstados();
        //consultarEstado(1L);
        //removerEstado(1L);
        //inserirCidadeNovoEstado();
        //inserirCidadeEstadoNoBD();
       // listarCidades();
       inserirPessoa();

        ConexaoUtil.fecharFabrica();

    }
}
