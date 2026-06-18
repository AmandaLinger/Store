package br.com.store.testes;

import br.com.store.dao.CategoriaDao;
import br.com.store.dao.ProdutoDao;
import br.com.store.modelo.Categoria;
import br.com.store.modelo.Produto;
import br.com.store.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager(); //EntityManager é a interface que faz a conexao do java com o bd
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1L);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach( p2 -> System.out.println(p.getNome()));
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

        EntityManager em = JPAUtil.getEntityManager(); //EntityManager é a interface que faz a conexao do java com o bd
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin(); //inicia a transacao no bd

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}