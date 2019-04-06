/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package servicos;

import dados.ServicoException;

/**
 * Representa um funcionário
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton
 */
public class FuncionarioServicoConcreto implements FuncionarioServico{
    
    private ClienteServicoConcreto clienteServico = new ClienteServicoConcreto();
    private LivroServicoConcreto livroServico = new LivroServicoConcreto();
    
    /**
     * Construtor padrão
     */
    public FuncionarioServicoConcreto(){}
    
    /**
     * Consulta cliente
     * @param loginCliente Login do Cliente a ser consultado
     * @return  Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
       return clienteServico.consultarCliente(loginCliente);
    }
    
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
                                    String genero ) throws ServicoException{
   
        
        this.clienteServico.salvar( login, 
                                    senha,
                                    nome,
                                    telefone,
                                    idade,
                                    genero );
        
    
    }
    
    /**
     * Bloqueia permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        livroServico.bloqueioPermanenteDeLivro(livro);
    }
    
    /**
     * Bloqueia temporário de livro
     * @param livro Livro a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        livroServico.bloqueioTemporarioDeLivro(livro);
    }
    
    /**
     * Bloqueia permanentemente cliente
     * @param cliente Cliente a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException{
        clienteServico.bloqueioPermanenteDeCliente(cliente);
    }
    
    /**
     * Bloqueio temporário de cliente
     * @param cliente   Cliente a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException{
        clienteServico.bloqueioTemporarioDeCliente(cliente);
    }
    
    /**
     * Registra livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException{
        livroServico.registrarLivro(livro);
    }
    
    public void alterarLivro(){}

    @Override
    public void alterarLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
