/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.UsuarioDAO;
import dados.UsuarioDAOArquivo;

/**
 *
 * @author SamDan
 */
public class UsuarioServico {

    private UsuarioDAO usuarioDAO = new UsuarioDAOArquivo();
    
    public boolean autenticacao( String login, String senha){
        return usuarioDAO.autenticacao( login, senha );
    }
    
//    public boolean realizarLogout(){
//    
//    }
//    
}
