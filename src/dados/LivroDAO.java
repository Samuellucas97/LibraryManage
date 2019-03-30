/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Livro;

/**
 *
 * @author SamDan
 */
public interface LivroDAO {
    
    public void registrarLivro(Livro livro) throws ServicoException;
    public void alterarLivro() throws ServicoException;
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException;
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException;
    public void excluirLivro(Livro livro) throws ServicoException;
}
