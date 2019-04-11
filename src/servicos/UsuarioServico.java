/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.List;

/**
 * Implementa as regras de negócio da interface IUsuarioServico
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public abstract class UsuarioServico implements IUsuarioServico {
 
    /**
     * Autentica o usuário em detrimento do login e da senha
     * @param login Login do usuário
     * @param senha Senha do usuário
     * @throws ServicoException 
     */
    @Override
    public abstract Usuario autenticacao( String login, String senha) throws ServicoException;
    
    /**
     * Realiza consulta
     * @param   objeto  Objeto a ser consultado
     */
    @Override
    public abstract Object consulta(Object objeto);
    
    /**
     * Realiza consulta
     * @param   objeto  Objeto a ser consultado
     * @return 
     */
    @Override
    public abstract List<Object> consultaLista(Object objeto);
    /**
     * Registra objeto
     * @param   objeto  Objeto a ser registrado
     */
    @Override
    public abstract void registrar(Object objeto);

    /**
     * Altera o objeto
     * @param id    Identificação do objeto
     * @param objeto    Objeto a ser alterado
     */
    @Override
    public abstract void alterar(String id, Object objeto);
    
    /**
     * Excluir o objeto
     * @param objeto    Objeto a ser excluído 
     */
    @Override
    public abstract void excluir(Object objeto);
    
}
