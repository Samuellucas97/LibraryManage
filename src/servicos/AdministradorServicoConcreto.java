/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.AdministradorDAO;
import dados.ServicoException;
import dados.UsuarioDAOFactory;

/**
 * Implementa as regras de negócio de Administrador
 * @author Samuel Lucas de Moura Ferino
 */
public class AdministradorServicoConcreto implements AdministradorServico{
    
    private final AdministradorDAO administradorDAO = (AdministradorDAO) UsuarioDAOFactory.getUsuarioDAO("AdministradorDAOArquivo");
    private final LivroServicoConcreto livroServico = new LivroServicoConcreto();
    
    /**
     * Construtor padrão
     */
    public AdministradorServicoConcreto(){
        super();
    }
    
    /**
     * Exclui livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    @Override
    public void excluirLivro(Livro livro) throws ServicoException{
        livroServico.excluirLivro(livro);
    }
    
    public void consultarFuncionario() throws ServicoException{}
    public void alterarFuncionario() throws ServicoException{}
    
    public void registrarFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.registrarFuncionario();
    }
    
    public void excluirUsuario(Usuario usuario) throws ServicoException{
//        administradorDAO.excluirUsuario(usuario);
    }
    
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.bloqueioPermanenteDeFuncionario(funcionario);
    }
    
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.bloqueioTemporarioDeFuncionario(funcionario);
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
