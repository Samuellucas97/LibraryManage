/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface das regras de negócio de Administrador
 * @author Samuel Lucas de Moura Ferino
 */
public interface IAdministradorServico extends IUsuarioServico{
 
    /**
     * Exclui o livro
     * @param livro Livro a ser excluído
     * @throws ServicoException 
     */
    public void excluirLivro(Livro livro) throws ServicoException;
    
    /**
     * Consulta o funcionário
     * @param nome  Nome do funcionário
     * @return  Funcionario buscado
     * @throws ServicoException 
     */
    public Funcionario consultarFuncionario(String nome) throws ServicoException;
    
    /**
     * Altera o funcionário
     * @param login Login do funcionário
     * @param funcionario   Funcionário a ser alterado
     * @throws ServicoException
     */
    public void alterarFuncionario(String login, Funcionario funcionario) throws ServicoException;
    
    /**
     * Registra o funcionário
     * @param funcionario   Funcionário a ser registrado
     * @throws ServicoException 
     */
    public void registrarFuncionario(Funcionario funcionario) throws ServicoException;
    
    /**
     * Exclui usuário
     * @param usuario   Usuário a ser excluído
     * @throws ServicoException 
     */
    public void excluirUsuario(Usuario usuario) throws ServicoException;
    
    /**
     * Bloqueia permanentemente o funcionário
     * @param funcionario Funcionário a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException;
    
    /**
     * Bloqueia temporariamente o funcionário
     * @param funcionario Funcionário a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException;
   
}
