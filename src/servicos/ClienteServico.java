/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ClienteDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;

/**
 *
 * @author SamDan
 */
public class ClienteServico extends UsuarioServico implements IClienteServico {
 
    private final ClienteDAOArquivo clienteDAOArquivo = (ClienteDAOArquivo) UsuarioDAOFactory.getUsuarioDAO("ClienteDAOArquivo");
    private final ILivroServico livroServico = new LivroServico();
    
    /**
     * Construtor padrão
     */
    public ClienteServico(){        
        /// VAZIO
    }
    
    /**
     * Insere ranking no livro
     * @param livro Livro a ser inserido o ranking
     * @return 
     */
    private void inserirRankingLivro( Livro livro ){
        /// Dúvida: é para inserir esse livro no atributo ranking da classe Cliente?
        ///         E se for, eu o adiciono com qual ranking
                
    }
    
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
                        String genero ) throws ServicoException{
    
        Cliente cliente = new Cliente();
        
        cliente.setLogin(login);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setIdade(idade);
        cliente.setGenero(genero);
        
        this.clienteDAOArquivo.salvar( cliente );
            
    }
    
    /**
     * Consulta cliente  
     * @param loginCliente  Cliente a ser consultado
     * @return Cliente buscado
     * @throws ServicoException 
     */
    @Override
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
        return clienteDAOArquivo.buscarCliente(loginCliente);
    }
    
    /**
     * Bloqueia cliente permanentemente
     * @param cliente Cliente a ser bloqueado permanentemente
     */
    @Override
    public void bloqueioPermanenteDeCliente(Cliente cliente) {
        clienteDAOArquivo.bloqueioPermanenteDeCliente(cliente);
    }

    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     */
    @Override
    public void bloqueioTemporarioDeCliente(Cliente cliente) {
        clienteDAOArquivo.bloqueioTemporarioDeCliente(cliente);
    }

    @Override
    public void avaliarLivro(int notaLivro) throws ServicoException {
        /// TO DO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
