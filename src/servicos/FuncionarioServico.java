/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package servicos;

import dados.ServicoException;

/**
 * Representa um funcionário
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton 
 * @author  Thiago da Costa Monteiro
 */
public abstract class FuncionarioServico implements IUsuarioServico{
    
    private final IClienteServico clienteServico = new ClienteServico();
    private final ILivroServico livroServico;
    
    /**
     * Construtor padrão
     * @throws dados.ServicoException
     */
    public FuncionarioServico() throws ServicoException{
        this.livroServico = new LivroServico();
    }
    
    /**
     * Consulta cliente
     * @param loginCliente Login do Cliente a ser consultado
     * @return  Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
       return this.clienteServico.consultarCliente(loginCliente);
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
        this.livroServico.bloqueioPermanenteDeLivro(livro);
    }
    
    /**
     * Bloqueia temporário de livro
     * @param livro Livro a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        this.livroServico.bloqueioTemporarioDeLivro(livro);
    }
    
    /**
     * Bloqueia permanentemente cliente
     * @param cliente Cliente a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException{
        this.clienteServico.bloqueioPermanenteDeCliente(cliente);
    }
    
    /**
     * Bloqueio temporário de cliente
     * @param cliente   Cliente a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException{
        this.clienteServico.bloqueioTemporarioDeCliente(cliente);
    }
    
    /**
     * Registra livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException{
        this.livroServico.registrarLivro(livro);
    }

    @Override
    public abstract Usuario autenticacao(String login, String senha) throws ServicoException;
    
    @Override
    public abstract void consulta(Object objeto);

    @Override
    public abstract void registrar(Object objeto);
    
    @Override
    public abstract void alterar(String id, Object objeto);
        
    @Override
    public abstract void excluir(Object objeto);
    
    
}
