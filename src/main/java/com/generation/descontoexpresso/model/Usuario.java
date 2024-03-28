package com.generation.descontoexpresso.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeUsuario é obrigatório.")
    @Size(min = 1, max = 70, message = "O atributo nomeUsuario deve conter no minimo 05 e no máximo 70 caracteres")
    private String nomeUsuario;

    @NotNull(message = "O atributo sobrenomeUsuario é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo sobrenomeUsuario deve conter no minimo 05 e no máximo 100 caracteres")
    private String sobrenomeUsuario;

    @NotNull(message = "O atributo cadastroUnico é obrigatório.")
    @Digits(integer = 9, fraction = 0, message = "O atributo cadastroUnico deve conter até 9 caracteres")
    private BigInteger cadastroUnico;

    @NotNull(message = "O atributo dataNascimento é obrigatório.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull(message = "O atributo telefone é obrigatório.")
    @Digits(integer = 16, fraction = 0, message = "O atributo telefone deve conter até 16 caracteres")
    private BigInteger telefone;

    @NotNull(message = "O atributo cidade é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo cidade deve conter no minimo 5 e no máximo 100 caracteres")
    private String cidade;

    @NotNull(message = "O atributo bairro é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo bairro deve conter no minimo 5 e no máximo 100 caracteres")
    private String bairro;

    @NotNull(message = "O atributo cep é obrigatório.")
    @Size(min = 8, max = 8, message = "O atributo cep deve conter 8 caracteres")
    private String cep;

    @NotNull(message = "O atributo rua é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo rua deve conter no minimo 5 e no máximo 100 caracteres")
    private String rua;

    @NotNull(message = "O atributo numeroCasa é obrigatório.")
    @Size(min = 1, max = 5, message = "O numeroCasa numero deve conter no minimo 1 e no máximo 5 caracteres")
    private String numeroCasa;

    @Schema(example = "email@email.com.br")
    @Email(message = "Deve ser um email válido!")
    @NotNull(message = "O atributo email é obrigatório.")
    @Size(min = 5, max = 100, message = "O atributo emailUsuario deve conter no minimo 5 e no máximo 100 caracteres")
    private String emailUsuario;

    private String fotoUsuario;

    @NotNull(message = "O atributo senhaUsuario é obrigatório.")
    @Size(min = 5, max = 1000, message = "O atributo senhaUsuario deve conter no minimo 5 e no máximo 100 caracteres")
    private String senhaUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Produto> produto;

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

    public BigInteger getCadastroUnico() {
        return cadastroUnico;
    }

    public void setCadastroUnico(BigInteger cadastroUnico) {
        this.cadastroUnico = cadastroUnico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
