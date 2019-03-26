/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Usuario;

/**
 * Interface de manipulação de dados
 * @author Samuel Lucas de Moura Ferino
 *         José Welliton 
 */
public interface UsuarioDAO {

    public boolean autenticacao(String login, String senha) throws ServicoException;
    public Usuario buscar( String login ) throws NullPointerException;
    
}
