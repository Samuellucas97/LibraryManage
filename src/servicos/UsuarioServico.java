/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import dados.UsuarioDAO;
import dados.UsuarioDAOFactory;

/**
 * Implementa as regras de negócio da interface IUsuarioServico
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public class UsuarioServico implements IUsuarioServico {
 
    private final UsuarioDAO usuarioDAO = UsuarioDAOFactory.getUsuarioDAO("UsuarioDAOArquivo");

    /**
     * Construtor padrão
     */    
    public UsuarioServico() {
        /// VAZIO
    }
    
    /**
     * Autentica o usuário em detrimento do login e da senha
     * @param login Login do usuário
     * @param senha Senha do usuário
     * @throws ServicoException 
     */
    public Usuario autenticacao( String login, String senha) throws ServicoException{    
        return usuarioDAO.autenticacao( login, senha );
    }
    
}
