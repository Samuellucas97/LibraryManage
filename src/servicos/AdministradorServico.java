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
 * @author José Wellinton Nunes Junior
 * @author Thiago da Costa Monteiro
 */
public class AdministradorServico extends FuncionarioServico implements IAdministradorServico{
    
    private final AdministradorDAO administradorDAO = (AdministradorDAO) UsuarioDAOFactory.getUsuarioDAO("AdministradorDAOArquivo");
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
    
    @Override
    public Funcionario consultarFuncionario(String nome) throws ServicoException{
        /// O retorno desse método deve ser um Funcionario
        return this.administradorDAO.consultarFuncionario(nome);
    }
    @Override
    public void alterarFuncionario() throws ServicoException{
        /// O que esse método faz?
    }
    
    @Override
    public void registrarFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.registrarFuncionario(funcionario);
    }
    
    @Override
    public void excluirUsuario(Usuario usuario) throws ServicoException{
        this.administradorDAO.excluirUsuario(usuario);
    }
    
    @Override
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.bloqueioPermanenteDeFuncionario(funcionario);
    }
    
    @Override
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException{
        this.administradorDAO.bloqueioTemporarioDeFuncionario(funcionario);
    }

}
