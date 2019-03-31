/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.AdministradorDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAO;

/**
 * Implementa as regras de negócio da interface UsuarioServico
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public class UsuarioServicoConcreto implements UsuarioServico {
 
    private UsuarioDAO usuarioDAO;

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
    public void autenticacao( String login, String senha) throws ServicoException{    
        this.usuarioDAO = new AdministradorDAOArquivo();
        usuarioDAO.autenticacao( login, senha );
    }
    
    
}
