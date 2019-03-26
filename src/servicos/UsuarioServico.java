/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import dados.UsuarioDAO;
import dados.UsuarioDAOArquivo;

/**
 *
 * @author SamDan
 */
public class UsuarioServico {

    private UsuarioDAO usuarioDAO = new UsuarioDAOArquivo();

    public UsuarioServico() {
    }
    
    public boolean autenticacao( String login, String senha){
        
        boolean resultado = false;
        
        try{
            resultado = usuarioDAO.autenticacao( login, senha );
        }catch( ServicoException e){
            System.err.println( e.getMessage() );
        }
        
        return resultado;
    }
    
//    public boolean realizarLogout(){
//    
//    }
//    
}
