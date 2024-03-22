package com.generation.descontoexpresso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeUsuario é obrigatório.")
    @Size(min = 5, max = 70, message = "O atributo nomeUsuario deve conter no minimo 05 e no máximo 70 caracteres")
    private String nomeUsuario;

    @NotNull(message = "O atributo sobrenomeUsuario é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo sobrenomeUsuario deve conter no minimo 05 e no máximo 100 caracteres")
    private String sobrenomeUsuario;

    @NotNull(message = "O atributo cadastroUnico é obrigatório.")
    @Size(min = 8, max = 8, message = "O atributo cadastroUnico deve conter 8 caracteres")
    private int cadastroUnico;

    @NotNull(message = "O atributo dataNascimento é obrigatório.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;


    @Size(min = 8, max = 14, message = "O atributo telefone deve conter no minimo 8 e no máximo 14 caracteres ")
    private int telefone;

    @NotNull(message = "O atributo enderecoCras è obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo enderecoCras deve conter")
    private String enderecoCras;

    @NotNull(message = "O atributo email é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo emailUsuario deve conter ")
    private String emailUsuario;

    @NotNull(message = "O atributo senha é obrigatório.")
    @Size(min = 5, max = 1000, message = "O atributo sobrenomeUsuario deve conter")
    private String senhaUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Produto> produto;

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public int getCadastroUnico() {
        return cadastroUnico;
    }

    public void setCadastroUnico(int cadastroUnico) {
        this.cadastroUnico = cadastroUnico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEnderecoCras() {
        return enderecoCras;
    }

    public void setEnderecoCras(String enderecoCras) {
        this.enderecoCras = enderecoCras;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
