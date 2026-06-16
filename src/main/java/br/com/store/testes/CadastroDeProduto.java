package br.com.store.testes;

import br.com.store.dao.ProdutoDao;
import br.com.store.modelo.Categoria;
import br.com.store.modelo.Produto;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto("Iphone X", "ótimo custo beneficio", new BigDecimal("2400"), Categoria.CELULARES );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin(); //iniciando transacao
        dao.cadastrar(celular); //fazendo o inserte no banco de dados com o jpa
        em.getTransaction().commit(); //commita a transação
        em.close(); //fecha a transacao
    }
}
