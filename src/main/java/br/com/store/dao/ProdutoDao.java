package br.com.store.dao;

import br.com.store.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class,id);//o FIND() sempe vai receber 2 parametros(nomeEntidade.class , id)
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p"; //salvando o comando em uma variavel
        return em.createQuery(jpql , Produto.class).getResultList(); //aplicando a query e mostrando o resultado
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome"; //passando o paramentro :nome para a busca
        return em.createQuery(jpql , Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome"; //realizando o join automatico
        return em.createQuery(jpql , Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoPorNome(String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome"; //retornando apenas o preço
        return em.createQuery(jpql , BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();// metodo para carregar apenas 1 unico registro
    }


}
