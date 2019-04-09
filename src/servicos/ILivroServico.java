/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.List;

/**
 * Interface das regras de negócio de Livro
 * @author Samuel Lucas de Moura Ferino
 */
public interface ILivroServico {
    
    /**
     * Livro a ser consultado
     * @param idLivro   Identificador do livro a ser consultado
     * @return  Livro com o id dado
     * @throws ServicoException 
     */
    public Livro consultaLivro(String idLivro) throws ServicoException;    
    
    /**
     * Registra o livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException;
        
    /**
     * Muda-se o status do livro para bloqueado temporariamente
     * @param livro Livro a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    public void efetuarBloqueioTemporarioDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Bloqueia-se permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void efetuarBloqueioPermanenteDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Exclui o livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    public void excluirLivro(Livro livro) throws ServicoException;
    
    /**
     * Efetua o devolução do livro
     * @param livro Livro a ser devolvido
     * @throws dados.ServicoException
     */
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Empresta o livro
     * @param livro Livro a ser emprestado
     * @throws dados.ServicoException
     */
    public void efetuarEmprestimoDeLivro(Livro livro) throws ServicoException;   
    
    /**
     * Efetua a copia de um livro retornando a instância do livro copiado.
     * @param livro Livro a ser copiado
     * @return Instância do livro copiado
     * @throws dados.ServicoException
     */
    public Livro copia(Livro livro) throws ServicoException;
    
    /**
     * Efetua alteração de livro a partir de uma lista de parâmetros e uma lista de seus respectivos valores.
     * @param livro Livro a ser alterado
     * @param params Lista de parâmetros escolhidos
     * @param keys Lista de seus respectivos valores
     * @throws dados.ServicoException
     */
    public void alterar(Livro livro, List<String> params, List<String> keys) throws ServicoException;
    
    /**
     * Efetua alteração de livro a partir de um parâmetros e um respectivo valor.
     * @param livro Livro a ser alterado
     * @param param parâmetro escolhido
     * @param key valor do parâmetro escolhido
     * @throws dados.ServicoException
     */
    public void alterar(Livro livro, String param, String key) throws ServicoException;
    
}
