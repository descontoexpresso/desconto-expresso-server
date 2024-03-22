package com.generation.descontoexpresso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeProduto é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo nomeProduto deve conter no minimo 05 e no máximo 100 caracteres")
    private String nomeProduto;

    @NotNull(message = "O atributo descricaoProduto é obrigatório.")
    @Size(min = 10, max = 255, message = "O atributo descricaoProduto deve conter no minimo 10 e no máximo 255 caracteres")
    private String descricaoProduto;

    @NotNull(message = "O atributo estoque é obrigatório.")
    private int estoque;

    @NotNull(message = "O atributo preco é obrigatório.")
    private float preco;

    //@NotNull(message = "O atributo dataValidade é obrigatório.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataValidade;

    @NotNull(message = "O atributo fotoProduto é obrigatório.")
    private String fotoProduto;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    @ManyToOne
    @JsonIgnoreProperties("usuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}