/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 * Interface de manipulação de dados
 * @author Samuel Lucas de Moura Ferino
 *         José Welliton 
 */
public interface UsuarioDAO {

    public boolean autenticacao(String login, String senha);
    
}
