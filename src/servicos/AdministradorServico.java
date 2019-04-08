/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.AdministradorDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;

/**
 * Implementa as regras de negócio de Administrador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton Nunes Junior
 * @author Thiago da Costa Monteiro
 */
public class AdministradorServico extends FuncionarioServico implements IAdministradorServico{
    
    private final AdministradorDAOArquivo administradorDAO = (AdministradorDAOArquivo) UsuarioDAOFactory.getUsuarioDAO("AdministradorDAOArquivo");
    private final LivroServico livroServico = new LivroServico();
    
    /**
     * Construtor padrão
     */
    public AdministradorServico(){
        super();
    }
    
    /**
     * Exclui livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    @Override
    public void excluirLivro(Livro livro) throws ServicoException{
        this.livroServico.excluirLivro(livro);
    }
    
    /**
     * Consulta o funcionário
     * @param nome  Nome do funcionário
     * @return  Funcionario buscado
     * @throws ServicoException 
     */
    @Override
    public Funcionario consultarFuncionario(String nome) throws ServicoException{
        /// O retorno desse método deve ser um Funcionario
        return this.administradorDAO.consultarFuncionario(nome);
    }

    /**
     * Altera o funcionário
     * @param login Login do funcionário
     * @param funcionario   Funcionário a ser alterado
     * @throws ServicoException
     */
    @Override
    public void alterarFuncionario(String login, Funcionario funcionario) throws ServicoException{
        /// O que esse método faz?
        this.administradorDAO.alterarFuncionario( login, funcionario );
    }
    
    /**
     * Registra o funcionário
     * @param funcionario   Funcionário a ser registrado
     * @throws ServicoException 
     */
    @Override
    public void registrarFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.registrarFuncionario(funcionario);
    }
    
    /**
     * Exclui usuário
     * @param usuario   Usuário a ser excluído
     * @throws ServicoException 
     */
    @Override
    public void excluirUsuario(Usuario usuario) throws ServicoException{
        this.administradorDAO.excluirUsuario(usuario);
    }
    
    /**
     * Bloqueia permanentemente o funcionário
     * @param funcionario Funcionário a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.bloqueioPermanenteDeFuncionario(funcionario);
    }
    
    /**
     * Bloqueia temporariamente o funcionário
     * @param funcionario Funcionário a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    @Override
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.bloqueioTemporarioDeFuncionario(funcionario);
    }

}
