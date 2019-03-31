/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.LivroDAO;
import dados.LivroDAOArquivo;
import dados.ServicoException;

/**
 * Implementa a lógica de negócios relativa a Livro
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class LivroServicoConcreto implements LivroServico{
    
    private LivroDAO livroDAO = new LivroDAOArquivo();
    
    public LivroServicoConcreto(){
    }
    
    /**
     * Livro a ser consultado
     * @param idLivro   Identificador do livro a ser consultado
     * @return  Livro com o id dado
     * @throws ServicoException 
     */
    public Livro consultaLivro(String idLivro) throws ServicoException{
        return livroDAO.consultaLivro(idLivro);
    }
    
    /**
     * Registra o livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException{
        this.livroDAO.registrarLivro(livro);
    }
    
    public void alterarLivro() throws ServicoException{
    
    }
    
    /**
     * Muda-se o status do livro para bloqueado temporariamente
     * @param livro Livro a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioTemporarioDeLivro(livro);
    }
    
    /**
     * Bloqueia-se permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioPermanenteDeLivro(livro);
    }
    
    /**
     * Exclui o livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    public void excluirLivro(Livro livro) throws ServicoException{
        this.livroDAO.excluirLivro(livro);
    }

    /**
     * Efetua o devolução do livro
     * @param livro Livro a ser devolvido
     */
    public void efetuarDevolucaoDeLivro(Livro livro) {
        this.livroDAO.efetuarDevolucaoDeLivro(livro);
    }

    /**
     * Empresta o livro
     * @param livro Livro a ser emprestado
     */
    public void emprestimoDeLivro(Livro livro) {
        this.livroDAO.emprestimoDeLivro(livro);
    }
    
}
