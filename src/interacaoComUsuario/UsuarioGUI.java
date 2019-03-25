/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

/**
 * Interface da apresentação do usuário
 * @author SamDan
 */
public interface UsuarioGUI {

//    public abstract void realizarLogin(String login, String senha);
    public abstract void autenticacao( String login, String senha);
    public abstract void realizarLogout();
    
}



