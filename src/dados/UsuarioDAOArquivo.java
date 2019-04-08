/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import servicos.Administrador;
import servicos.Cliente;
import servicos.Usuario;

/**
 * Representa um 
 * @author  Samuel Lucas de Moura Ferino
 *          José Wellinton
 */
public abstract class UsuarioDAOArquivo implements UsuarioDAO{
    private final UsuarioDAOArquivo clienteDAO;    
    private final UsuarioDAOArquivo OperadorDAO;
    private final UsuarioDAOArquivo AdministradorDAO;
    
    public UsuarioDAOArquivo(){
        this.clienteDAO = new ClienteDAOArquivo();
        this.OperadorDAO = new OperadorDAOArquivo();
        this.AdministradorDAO = new AdministradorDAOArquivo();
    
    }
    
    protected abstract void transformaStringEmHashMap(String conteudoArquivo );    
     
    protected abstract String autenticar( String login, String senha);
    
    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException{

        if(this.clienteDAO.autenticar(login, senha).equals("OK")){
            Usuario cliente = this.clienteDAO.buscar(login);
            return cliente;            
        }
        if(this.AdministradorDAO.autenticar(login, senha).equals("OK")){
            Usuario administrador = this.AdministradorDAO.buscar(login);
            return administrador;
        }
        if(this.OperadorDAO.autenticar(login, senha).equals("OK")){
            Usuario operador = this.OperadorDAO.buscar(login);
            return operador;
        }
        
        throw new ServicoException( this.autenticar(login, senha) );      
    }   
    	
    protected abstract void lerArquivo(String nomeDoArquivo) throws ServicoException;
    
    protected boolean salvarArquivo(String nomeArquivo) throws ServicoException{
        Serializator.serialize(this.hMapLivro, nomeArquivo);
        return true;
    } 
    
}
