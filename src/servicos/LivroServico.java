/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.LivroDAO;
import dados.LivroDAOArquivo;
import dados.ServicoException;
import java.util.List;

/**
 * Implementa a lógica de negócios relativa a Livro
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class LivroServico implements ILivroServico{
    
    private final LivroDAO livroDAO = new LivroDAOArquivo();
    
    /**
     * Construtor padrão
     */
    public LivroServico(){
        /// VAZIO
    }
    
    /**
     * Livro a ser consultado
     * @param idLivro   Identificador do livro a ser consultado
     * @return  Livro com o id dado
     * @throws ServicoException 
     */
    @Override
    public Livro consultaLivro(String idLivro) throws ServicoException{
        return livroDAO.consultaLivro(idLivro);
    }
    
    /**
     * Registra o livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    @Override
    public void registrarLivro(Livro livro) throws ServicoException{
        this.livroDAO.registrarLivro(livro);
    }
    
    /**
     * Altera o estado do livro
     * @param livro Livro a ser emprestado ou devolvido
     * @throws ServicoException 
     */
    @Override
    public void alterarLivro(Livro livro) throws ServicoException{
        this.livroDAO.alterarLivro(livro);
        //// Dúvida: está certo esse método?
    }
    
    /**
     * Muda-se o status do livro para bloqueado temporariamente
     * @param livro Livro a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioTemporarioDeLivro(livro);
    }
    
    /**
     * Bloqueia-se permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioPermanenteDeLivro(livro);
    }
    
    /**
     * Exclui o livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    @Override
    public void excluirLivro(Livro livro) throws ServicoException{
        this.livroDAO.excluirLivro(livro);
    }

    /**
     * Efetua o devolução do livro
     * @param livro Livro a ser devolvido
     */
    @Override
    public void efetuarDevolucaoDeLivro(Livro livro) {
        this.livroDAO.efetuarDevolucaoDeLivro(livro);
    }

    /**
     * Empresta o livro
     * @param livro Livro a ser emprestado
     */
    @Override
    public void emprestimoDeLivro(Livro livro) {
        this.livroDAO.emprestimoDeLivro(livro);
    }

    public List<Livro> consultaLivros(String param, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Livro> consultaLivros(List<String> params, List<String> keys) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Livro> listaLivrosAvaliados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
