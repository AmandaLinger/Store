package br.com.store.testes;

import br.com.store.dao.ProdutoDao;
import br.com.store.modelo.Produto;
import br.com.store.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Iphone X");
        celular.setDescricao("ótimo custo beneficio");
        celular.setPreco(new BigDecimal("2400"));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin(); //iniciando transacao
        dao.cadastrar(celular); //fazendo o inserte no banco de dados com o jpa
        em.getTransaction().commit(); //commita a transação
        em.close(); //fecha a transacao
    }
}
