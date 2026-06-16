package br.com.store.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

//fazendo o mapeamento da etidade

@Entity //a anotação indica que essa classe é uma entidade no banco de dados
@Table(name="produtos") //informa que no banco de dados o nome é "produtos" e não "Produto" como na classe
public class Produto {

    @Id //informa que o id é igual ao do banco
    @GeneratedValue(strategy= GenerationType.IDENTITY) //informa que o banco vaigerar os ids
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
