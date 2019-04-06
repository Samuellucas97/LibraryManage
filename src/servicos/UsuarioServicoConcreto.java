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
 * Implementa as regras de negócio da interface UsuarioServico
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public class UsuarioServicoConcreto implements UsuarioServico {
 
    private final UsuarioDAO usuarioDAO = UsuarioDAOFactory.getUsuarioDAO("USuarioDAOArquivo");

    /**
     * Construtor padrão
     */    
    public UsuarioServicoConcreto() {
    }
    
    /**
     * Autentica o usuário em detrimento do login e da senha
     * @param login Login do usuário
     * @param senha Senha do usuário
     * @throws ServicoException 
     */
    public Usuario autenticacao( String login, String senha) throws ServicoException{    
        usuarioDAO.autenticacao( login, senha );
    }
    
    
}
