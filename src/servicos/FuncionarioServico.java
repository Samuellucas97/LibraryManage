/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package servicos;

import dados.ServicoException;

/**
 *
 * @author SamDan
 */
public class FuncionarioServico {
    
    private ClienteServico clienteServico = new ClienteServico();
    private LivroServico livroServico = new LivroServico();
    
    public FuncionarioServico(){}
    
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
       return clienteServico.consultarCliente(loginCliente);
    }
    
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
    
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException{
        livroServico.bloqueioPermanenteDeLivro(livro);
    }
    
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException{
        livroServico.bloqueioTemporarioDeLivro(livro);
    }
    
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException{
        clienteServico.bloqueioPermanenteDeCliente(cliente);
    }
    
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException{
        clienteServico.bloqueioTemporarioDeCliente(cliente);
    }
    
    public void registrarLivro(Livro livro) throws ServicoException{
        livroServico.registrarLivro(livro);
    }
    
    public void alterarLivro(){}
    
}
