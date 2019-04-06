/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ClienteDAO;
import dados.ClienteDAOArquivo;
import dados.ServicoException;

/**
 *
 * @author SamDan
 */
public class ClienteServicoConcreto implements ClienteServico {
 
    private ClienteDAO clienteDAO;
 
    /**
     * Construtor padrão
     */
    public ClienteServicoConcreto(){        
       clienteDAO = new ClienteDAOArquivo();
    }
    
    /**
     * Insere ranking no livro
     * @param livro Livro a ser inserido o ranking
     * @return 
     */
    private void inserirRankingLivro( Livro livro ){
        
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
        
        this.clienteDAO.salvar( cliente );
            
    }
    
    /**
     * Consulta cliente  
     * @param loginCliente  Cliente a ser consultado
     * @return Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
        return clienteDAO.buscarCliente(loginCliente);
    }
    
    /**
     * Bloqueia cliente permanentemente
     * @param cliente Cliente a ser bloqueado permanentemente
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) {
        clienteDAO.bloqueioPermanenteDeCliente(cliente);
    }

    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) {
        clienteDAO.bloqueioTemporarioDeCliente(cliente);
    }

    @Override
    public void avaliarLivro(int notaLivro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
