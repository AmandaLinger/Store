package br.com.store.testes;

import br.com.store.modelo.Categoria;
import br.com.store.util.JPAUtil;
import javax.persistence.EntityManager;


public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("celulares");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(celulares);
        celulares.setNome("XPTO");
        em.getTransaction().commit();
        em.close(); //fecha a transacao
    }
}
