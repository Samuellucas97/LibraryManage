   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.OperadorDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;

/**
 * Implementa as regras de negócio relativas ao operador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class OperadorServico extends FuncionarioServico{
  
    private final OperadorDAOArquivo operadorDAOArquivo = (OperadorDAOArquivo) UsuarioDAOFactory.getUsuarioDAO("OperadorDAOArquivo");
    private final LivroServico livroServico = new LivroServico();

    /**
     * Construtor da classe IOperadorServico
     */
    public OperadorServico() {
        /// VAZIO
    }
    
    /**
     * Efetua a devolução de um livro
     * @param livro Livro a ser devolvido
     * @throws ServicoException 
     */
    @Override
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException{
        livroServico.efetuarDevolucaoDeLivro(livro);
    }
    /**
     * Efetua o empréstimo de um livro
     * @param livro Livro a ser emprestado
     * @throws ServicoException 
     */
    @Override
    public void emprestimoDeLivro(Livro livro) throws ServicoException{
        livroServico.emprestimoDeLivro(livro);
    }    
    
}
