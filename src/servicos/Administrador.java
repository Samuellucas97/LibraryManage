/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 * Representa um administrador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public class Administrador extends Funcionario implements java.io.Serializable{
    
    /**
     * Construtor padrão
     */
    public Administrador(){
        super();
    }
    
    /**
     * Construtor parametrizado
     * @param login Login do administrador
     * @param senha Senha do administrador
     */
    public Administrador(String login, String senha){
        super(login, senha);
    }
    
}
