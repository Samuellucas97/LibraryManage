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
    
    private final LivroDAO livroDAO = LivroDAOArquivo.getInstancia();
    
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
     * Muda-se o status do livro para bloqueado temporariamente
     * @param livro Livro a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        
        Livro livroAlterado = new Livro(livro);
        livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_TEMPORARIAMENTE); 
        this.livroDAO.alterarLivro(livro.getId(), livroAlterado);
    }
    
    /**
     * Bloqueia-se permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        
        Livro livroAlterado = new Livro(livro);
        livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_PERMANENTEMENTE); 
        this.livroDAO.alterarLivro(livro, livroAlterado);
        
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
     * @throws dados.ServicoException
     */
    @Override
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException  {
    
        Livro livroAlterado = livro;
        
        this.livroDAO.adicionarQuantidadeLivro(livro.getId(), 1);
        livroAlterado.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
        this.livroDAO.alterarLivro( livro, livroAlterado);
        
    }

    /**
     * Empresta o livro
     * @param livro Livro a ser emprestado
     * @throws dados.ServicoException
     */
    @Override
    public void emprestimoDeLivro(Livro livro) throws ServicoException {
        
        Livro livroAlterado = livro;
        
        this.livroDAO.removerQuantidadeLivro(livro.getId(), 1);
        livroAlterado.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
        this.livroDAO.alterarLivro( livro, livroAlterado);
    
    }

    public List<Livro> consultaLivros(String param, String key) throws ServicoException {
        return this.livroDAO.consultaLivros(param, key);
    }

    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException {
        return this.livroDAO.consultaLivros(params, keys);
    }

    @Override
    public void renomearAssunto(String idLivro, ArrayList<String> novoAssunto) throws ServicoException {
        Livro livroAlterado = this.consultaLivro(idLivro);
        livroAlterado.setAssunto(novoAssunto);
        this.livroDAO.alterarLivro(idLivro, livroAlterado);
    
    
    @Override
    public void renomearAssunto(String idLivro, ArrayList<String> novoAssunto) throws ServicoException {
        Livro livroAlterado = this.consultaLivro(idLivro);
        livroAlterado.setAssunto(novoAssunto);
        this.livroDAO.alterarLivro(idLivro, livroAlterado);
    }
    
    @Override
    public void renomearTitulo(String idLivro, String novoTitulo) throws ServicoException {
        Livro livroAlterado = this.consultaLivro(idLivro);
        livroAlterado.setTitulo(novoTitulo);
        this.livroDAO.alterarLivro(idLivro, livroAlterado);
    }
    
}
