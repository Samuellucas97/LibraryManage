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
 * @author José Welliton Nunes Júnior
 */
public interface LivroDAO {
    
    public Livro consultaLivro(String idLivro) throws ServicoException;
    
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException;
    public List<Livro> consultaLivros(String param, String key) throws ServicoException;
    
    public void adicionarQuantidadeLivro(String idLivro, int quantidade) throws ServicoException;
    public void removerQuantidadeLivro(String idLivro, int quantidade) throws ServicoException;
    
    public void registrarLivro(Livro livro) throws ServicoException;
    public void alterarLivro(String IDlivro,  Livro livroAlterado) throws ServicoException;
    public void excluirLivro(Livro livro) throws ServicoException;
    
}
