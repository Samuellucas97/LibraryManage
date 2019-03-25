/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

/**
 *
 * @author SamDan
 */
public abstract class UsuarioGUI {

//    
//    public void setTipoDeUsuario(String tipoDeUsuario) {
//            this.tipoDeUsuario = tipoDeUsuario;
//    }
    public abstract void realizarLogin(String login, String senha);

    /**
     *
     * @param login
     * @param senha
     */
    public abstract void autenticacao( String login, String senha);
    public abstract void realizarLogout();


}



