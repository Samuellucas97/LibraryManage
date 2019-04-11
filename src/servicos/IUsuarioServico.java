/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.List;

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
     * @return 
     * @throws dados.ServicoException 
     */
    public Object consulta(Object objeto) throws ServicoException;
    
    /**
     * Realiza consulta de listas
     * @param   objeto  Objeto a ser consultado
     * @param params
     * @param keys
     * @return 
     * @throws dados.ServicoException 
     */
    public Object consultaLista(Object objeto, List<String> params, List<String> keys) throws ServicoException;
    
    /**
     * Realiza consulta de listas
     * @param   objeto  Objeto a ser consultado
     * @param param
     * @param key
     * @return 
     * @throws dados.ServicoException 
     */
    public Object consultaLista(Object objeto, String param, String key) throws ServicoException;
    
    
    /**
     * Registra objeto
     * @param   objeto  Objeto a ser registrado
     * @throws dados.ServicoException
     */
    public void registrar(Object objeto) throws ServicoException;

    /**
     * Altera o objeto
     * @param id    Identificação do objeto
     * @param objeto    Objeto a ser alterado
     * @param param
     * @param key
     * @throws dados.ServicoException
     */
    public void alterar(String id, Object objeto,String param, String key) throws ServicoException;
    
    /**
     * Excluir o objeto
     * @param objeto    Objeto a ser excluído 
     * @throws dados.ServicoException 
     */
    public void excluir(Object objeto) throws ServicoException;

}
