package br.com.store.testes;

import br.com.store.dao.CategoriaDao;
import br.com.store.dao.ProdutoDao;
import br.com.store.modelo.Categoria;
import br.com.store.modelo.Produto;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("Iphone X", "ótimo custo beneficio", new BigDecimal("2400"), celulares );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);  //salvando a categoria no banco de dados
        produtoDao.cadastrar(celular); //salvando o profuto no banco de dados

        em.getTransaction().commit();
        em.close(); //fecha a transacao
    }
}
