/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface das regras de negócio de Funcionário
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton 
 * @author  Thiago da Costa Monteiro
 */
public interface IFuncionarioServico extends IUsuarioServico{
 
    /**
     * Consulta cliente
     * @param loginCliente Login do Cliente a ser consultado
     * @return  Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException;
    
    /**
     * Registra cliente
     * @param login Login do cliente
     * @param senha Senha do cliente
     * @param nome  Nome do cliente
     * @param telefone  Telefone do cliente
     * @param idade Idade do cliente
     * @param genero    Gênero do cliente
     * @throws ServicoException 
     */
    public void registrarCliente(   String login, 
                                    String senha, 
                                    String nome,
                                    String telefone,
                                    int idade,
                                    String genero ) throws ServicoException;
    
    /**
     * Bloqueia permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Bloqueia temporário de livro
     * @param livro Livro a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException;
    
    /**
     * Bloqueia permanentemente cliente
     * @param cliente Cliente a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException;
    
    /**
     * Bloqueio temporário de cliente
     * @param cliente   Cliente a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException;
    
    /**
     * Registra livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException;
    
    public void alterarLivro(Livro livro) throws ServicoException;    
}