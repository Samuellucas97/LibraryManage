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
    
    public void bloqueioPermanenteDeLivro(){}
    public void bloqueioTemporarioDeLivro(){}
    public void bloqueioPermanenteDeCliente(){}
    public void bloqueioTemporarioDeCliente(){}
    public void registrarLivro(){}
    public void alterarLivro(){}
    
}
