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
 *
 * @author SamDan
 */
public class LivroServico {
    
    private LivroDAO livroDAO = new LivroDAOArquivo();
    
    public void consultaLivro(Livro livro) throws ServicoException{
    }
    
    public void registrarLivro(Livro livro) throws ServicoException{
        this.livroDAO.registrarLivro(livro);
    }
    public void alterarLivro() throws ServicoException{
    
    }
    
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioTemporarioDeLivro(livro);
    }
    
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        this.livroDAO.bloqueioPermanenteDeLivro(livro);
    }
    public void excluirLivro(Livro livro) throws ServicoException{
        this.livroDAO.excluirLivro(livro);
    }
    
}
