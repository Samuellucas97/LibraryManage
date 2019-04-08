/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.List;
import servicos.Livro;

/**
 *
 * @author SamDan
 */
public interface LivroDAO {
    
    public Livro consultaLivro(String idLivro) throws ServicoException;
    
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException;
    public List<Livro> consultaLivros(String param, String key) throws ServicoException;
    
    public void adicionarQuantidadeLivro(String idLivro, int quantidade) throws ServicoException;
    public void removerQuantidadeLivro(String idLivro, int quantidade) throws ServicoException;
    
    public void registrarLivro(Livro livro) throws ServicoException;
    public void alterarLivro(Livro livro,  Livro livroAlterado) throws ServicoException;
    public void excluirLivro(Livro livro) throws ServicoException;
    
    //public void alterarLivro() throws ServicoException;
    
    //public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException;
    //public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException;
    
    //public void emprestimoDeLivro(Livro livro);
    //public void efetuarDevolucaoDeLivro(Livro livro);
    

    
}
