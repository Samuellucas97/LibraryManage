/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package servicos;

import dados.ServicoException;
import java.util.List;

/**
 * Representa um funcionário
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton Nunes Júnior
 * @author  Thiago da Costa Monteiro
 */
public abstract class FuncionarioServico implements IUsuarioServico{
    
    private static ClienteServico clienteServico;
    private static LivroServico livroServico;
    private static OperadorServico operadorServico;
    
    
    
    protected static void Inicializar() throws ServicoException{
        FuncionarioServico.getClienteServico();
        FuncionarioServico.getLivroServico();
    }
    
    public static ClienteServico getClienteServico() throws ServicoException{
        if(FuncionarioServico.clienteServico == null) 
            FuncionarioServico.clienteServico = (ClienteServico) 
            UsuarioServicoFactory.getUsuarioServico("ClienteServico");
        return FuncionarioServico.clienteServico;
    }
    
     public static OperadorServico getOperadorServico() throws ServicoException{
        if(FuncionarioServico.operadorServico == null) 
            FuncionarioServico.operadorServico = (OperadorServico) 
            UsuarioServicoFactory.getUsuarioServico("OperadorServico");
        return FuncionarioServico.operadorServico;
    }
    
    public static LivroServico getLivroServico() throws ServicoException{
        if(FuncionarioServico.livroServico == null) 
            FuncionarioServico.livroServico = LivroServico.getInstance();
        return FuncionarioServico.livroServico;
    }
    
    
    /**
     * Consulta cliente
     * @param loginCliente Login do Cliente a ser consultado
     * @return  Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
       return FuncionarioServico.clienteServico.consultarCliente(loginCliente);
    }
    
    public List<Cliente> consultaClienteLista(Cliente cliente, List<String> params, List<String> keys) 
            throws ServicoException{
        return (List<Cliente>) FuncionarioServico.clienteServico.consultaLista(cliente, params, keys);
    }
    
    public List<Cliente> consultaClienteLista(Cliente cliente, String param, String key) 
            throws ServicoException{
        return (List<Cliente>) FuncionarioServico.clienteServico.consultaLista(cliente, param, key);
    }
    
    /**
     * Registra cliente
     * @param login Login do cliente
     * @param senha Senha do cliente
     * @param nome  Nome do cliente
     * @param telefone  Telefone do cliente
     * @param idade Idade do cliente
     * @param genero    Gênero do cliente
     * @param estado    Estado da conta do cliente
     * @throws ServicoException 
     */
    public void registrarCliente(   String login, 
                                    String senha, 
                                    String nome,
                                    String telefone,
                                    int idade,
                                    Usuario.Genero genero,
                                    Usuario.EstadoUsuario estado) throws ServicoException{
   
        
        FuncionarioServico.clienteServico.salvar( login, 
                                    senha,
                                    nome,
                                    telefone,
                                    idade,
                                    genero,
                                    estado);
    
    }
    
    /**
     * Bloqueia permanentemente cliente
     * @param cliente Cliente a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException{
        FuncionarioServico.clienteServico.bloqueioPermanenteDeCliente(cliente);
    }
    
    /**
     * Bloqueio temporário de cliente
     * @param cliente   Cliente a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException{
        FuncionarioServico.clienteServico.bloqueioTemporarioDeCliente(cliente);
    }
    
    /**
     * Bloqueio temporário de cliente
     * @param cliente   Cliente a ser bloqueado
     * @throws ServicoException 
     */
    public void desBloqueioDeCliente(Cliente cliente) throws ServicoException{
        FuncionarioServico.clienteServico.desbloqueioDeCliente(cliente);
    }
    
    
    /**
     * Bloqueia permanentemente o livro
     * @param livro Livro a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        FuncionarioServico.livroServico.efetuarBloqueioPermanenteDeLivro(livro);
    }
    
    /**
     * Bloqueia temporário de livro
     * @param livro Livro a ser bloqueado
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        FuncionarioServico.livroServico.efetuarBloqueioTemporarioDeLivro(livro);
    }
    
    /**
     * Desbloqueia o livro
     * @param livro Livro a ser desbloqueado
     * @throws ServicoException 
     */
    public void desBloqueioDeLivro(Livro livro) throws ServicoException{
        FuncionarioServico.livroServico.efetuarDesbloqueioDeLivro(livro);
    }
    
    public Livro consultarLivro( String idLivro ) throws ServicoException{
       return FuncionarioServico.livroServico.consultaLivro(idLivro);
    }
    
    public List<Livro> consultaLivroLista(List<String> params, List<String> keys) 
            throws ServicoException{
        return FuncionarioServico.livroServico.consultaLivros(params, keys);
    }
    
    public List<Livro> consultaLivroLista(String param, String key) 
            throws ServicoException{
        return FuncionarioServico.livroServico.consultaLivros(param, key);
    }
    
    /**
     * Registra livro
     * @param livro Livro a ser registrado
     * @throws ServicoException 
     */
    public void registrarLivro(Livro livro) throws ServicoException{
        FuncionarioServico.livroServico.registrarLivro(livro);
    }
    
    public void alterarLivro(Livro livro, String param, String key) throws ServicoException{
        FuncionarioServico.livroServico.alterar(livro, param, key);
    }
    
    public void alterarLivro(Livro livro, List<String> params, List<String> keys) throws ServicoException{
        FuncionarioServico.livroServico.alterar(livro, params, keys);
    }

    @Override
    public abstract Usuario autenticacao(String login, String senha) throws ServicoException;
    
    @Override
    public abstract Object consulta(Object objeto) throws ServicoException;
    
    @Override
    public abstract Object consultaLista(Object objeto, List<String> params, List<String> keys) throws ServicoException;
    
    @Override
    public abstract Object consultaLista(Object objeto, String param, String key) throws ServicoException;
    
    @Override
    public abstract void registrar(Object objeto) throws ServicoException;
    
    @Override
    public abstract void alterar(String id, Object objeto,String param, String key) throws ServicoException;
    
    @Override
    public abstract void excluir(Object objeto) throws ServicoException;
        
}
