/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Representa um usuário
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton
 */
public class Usuario implements java.io.Serializable{

    public enum Genero{
        MASCULINO,
        FEMININO;
    }
    
    public enum EstadoUsuario{
        DISPONIVEL,
        BLOQUEADO_TEMPORARIAMENTE,
        BLOQUEADO_PERMANENTEMENTE;
    }
    
    protected String login;
    protected String senha;
    protected String nome;
    protected String telefone;
    protected int idade;
    protected Genero genero;
    protected EstadoUsuario estadoUsuario;
    
    /**
     * Construtor padrão
     */
    public Usuario(){
        this.login = new String();
        this.senha = new String();
        this.nome  = new String();
        this.telefone = new String();
        this.idade = 0;
        this.estadoUsuario = EstadoUsuario.DISPONIVEL;
    }

    /**
     * Construtor parametrizado
     * @param login Login do usuário
     * @param senha Senha do usuário 
     */
    public Usuario( String login, String senha){
        
        this.login = login;
        this.senha = senha;
    
        this.nome  = new String();
        this.telefone = new String();
        this.idade = 0;
    }
    
    public Usuario(String login, String senha, String nome, String telefone, int idade){
        
        this.login = login;
        this.senha = senha;
    
        this.nome  = nome;
        this.telefone = telefone;
        this.idade = idade;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws ServicoException {
        if(idade < 0) throw new ServicoException("Valor da idade inválida!");
        this.idade = idade;
    }

    public Genero getGenero() {
        return this.genero;
    }
    

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public EstadoUsuario getEstadoUsuario() {
        return this.estadoUsuario;
    }    

    public void setEstadoUsuario(EstadoUsuario estado) {
        this.estadoUsuario = estado;
    }
}
