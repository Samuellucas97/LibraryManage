/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface das regras de negócio de usuário
 * @author  Samuel Lucas de Moura Ferino
 *          José Wellinton 
 *          Thiago da Costa Monteiro
 */
public interface IUsuarioServico {
    
    /**
     * Autentica o usuário em detrimento do login e da senha
     * @param login Login do usuário
     * @param senha Senha do usuário
     * @return Usuario referente a sessão
     * @throws ServicoException 
     */
    public Usuario autenticacao( String login, String senha) throws ServicoException;
    
    
    /**
     * Realiza consulta
     * @param   objeto  Objeto a ser consultado
     */
    public void consulta(Object objeto);
    
    /**
     * Registra objeto
     * @param   objeto  Objeto a ser registrado
     */
    public void registrar(Object objeto);

    /**
     * Altera o objeto
     * @param id    Identificação do objeto
     * @param objeto    Objeto a ser alterado
     */
    public void alterar(String id, Object objeto);
    
    /**
     * Excluir o objeto
     * @param objeto    Objeto a ser excluído 
     */
    public void excluir(Object objeto);

}
