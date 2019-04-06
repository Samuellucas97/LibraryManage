/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Interface com as regras de negócios de Cliente
 * @author Samuel Lucas de Moura Ferino
 */
public interface ClienteServico extends UsuarioServico{
    
    /**
     * Salva o cliente no sistema
     * @param login Login do cliente
     * @param senha Senha do cliente
     * @param nome  Nome do cliente
     * @param telefone  Telefone do cliente
     * @param idade Idade do cliente
     * @param genero    Gênero do cliente    
     * @throws ServicoException 
     */
    public void salvar( String login, 
                        String senha, 
                        String nome,
                        String telefone,
                        int idade,
                        String genero ) throws ServicoException;
    
    /**
     * Consulta cliente  
     * @param loginCliente  Cliente a ser consultado
     * @return Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException;
    
    /**
     * Bloqueia cliente permanentemente
     * @param cliente Cliente a ser bloqueado permanentemente
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente);

    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente);

    /**
     * Avalia o livro
     * @param   notaLivro Nota do livro
     */
    public void avaliarLivro(int notaLivro) throws ServicoException;
}
