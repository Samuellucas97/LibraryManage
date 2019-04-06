/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface das regras de negócio de usuário
 * @author Samuel Lucas de Moura Ferino
 */
public interface UsuarioServico {
    
    /**
     * Autentica o usuário em detrimento do login e da senha
     * @param login Login do usuário
     * @param senha Senha do usuário
     * @throws ServicoException 
     */
    public Usuario autenticacao( String login, String senha) throws ServicoException;
    
}
