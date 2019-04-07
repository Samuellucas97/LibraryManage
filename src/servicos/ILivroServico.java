/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

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
     * Altera o estado do livro
     * @param livro Livro a ser emprestado ou devolvido
     * @throws ServicoException 
     */
    public void alterarLivro(Livro livro) throws ServicoException;
    
    /**
     * Muda-se o status do livro para bloqueado temporariamente
     * @param livro Livro a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Bloqueia-se permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Exclui o livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    public void excluirLivro(Livro livro) throws ServicoException;
    /**
     * Efetua o devolução do livro
     * @param livro Livro a ser devolvido
     */
    void efetuarDevolucaoDeLivro(Livro livro);
    
    /**
     * Empresta o livro
     * @param livro Livro a ser emprestado
     */
    void emprestimoDeLivro(Livro livro);   
}
