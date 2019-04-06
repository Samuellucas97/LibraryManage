   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.OperadorDAO;
import dados.ServicoException;
import dados.UsuarioDAOFactory;

/**
 * Implementa as regras de negócio relativas ao operador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class OperadorServicoConcreto implements OperadorServico{
  
    private final OperadorDAO operadorDAO = (OperadorDAO) UsuarioDAOFactory.getUsuarioDAO("OperadorDAOArquivo");
    private final LivroServicoConcreto livroServico = new LivroServicoConcreto();

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

    @Override
    public Cliente consultarCliente(String loginCliente) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarCliente(String login, String senha, String nome, String telefone, int idade, String genero) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
