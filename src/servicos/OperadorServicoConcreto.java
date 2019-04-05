/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.OperadorDAO;
import dados.OperadorDAOArquivo;
import dados.ServicoException;

/**
 * Implementa as regras de negócio relativas ao operador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class OperadorServicoConcreto extends FuncionarioServicoConcreto implements OperadorServico{
  
    private OperadorDAO operadorDAO = new OperadorDAOArquivo();
    private LivroServicoConcreto livroServico = new LivroServicoConcreto();

    /**
     * Construtor da classe OperadorServico
     */
    public OperadorServicoConcreto() {
        /// VAZIO
    }
    
    /**
     * Efetua a devolução de um livro
     * @param livro Livro a ser devolvido
     * @throws ServicoException 
     */
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException{
        livroServico.efetuarDevolucaoDeLivro(livro);
    }
    /**
     * Efetua o empréstimo de um livro
     * @param livro Livro a ser emprestado
     * @throws ServicoException 
     */
    public void emprestimoDeLivro(Livro livro) throws ServicoException{
        livroServico.emprestimoDeLivro(livro);
    }
    
    
}
