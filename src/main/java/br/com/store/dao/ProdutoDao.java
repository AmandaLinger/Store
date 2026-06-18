package br.com.store.dao;

import br.com.store.modelo.Produto;

import javax.persistence.EntityManager;
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
}
