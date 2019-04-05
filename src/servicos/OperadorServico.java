/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface com as regra de negócio de Operador
 * @author Samuel Lucas de Moura Ferino
 */
public interface OperadorServico extends Terminal{
    
    /**
     * Efetua a devolução de um livro
     * @param livro Livro a ser devolvido
     * @throws ServicoException 
     */
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Efetua o empréstimo de um livro
     * @param livro Livro a ser emprestado
     * @throws ServicoException 
     */
    public void emprestimoDeLivro(Livro livro) throws ServicoException;   
   
}
