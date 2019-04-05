/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

import dados.ServicoException;
import servicos.Cliente;
import servicos.FuncionarioServico;
import servicos.FuncionarioServicoConcreto;
import servicos.Livro;
import servicos.Usuario;

/**
 *
 * @author Thiago da Costa Monteiro
 */
public class AdministradorTerminal extends Terminal{
    private final FuncionarioServico funcionarioServico = new FuncionarioServicoConcreto();
    
    
    public void consultarCliente(String loginCliente){
        try{
            funcionarioServico.consultarCliente(loginCliente);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    public void registrarCliente(String loginCliente, String senhaCliente, String nomeCliente,
                                 String telefoneCliente, int idadeCliente, String generoCliente){
        try{
            funcionarioServico.registrarCliente(loginCliente, senhaCliente, nomeCliente,
                                                telefoneCliente, idadeCliente, generoCliente);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public void bloqueioPermanenteDeCliente(Cliente cliente){
        try{
                funcionarioServico.bloqueioPermanenteDeCliente(cliente);
        }
        catch (ServicoException ex) {
                System.err.println(ex.getMessage());
        }
    }
    public void registrarLivro(Livro livro){
        try{
                funcionarioServico.registrarLivro(livro);
        }
        catch (ServicoException ex) {
                System.err.println(ex.getMessage());
        }
    }
    public void alterarLivro(Livro livro){
        try{
            funcionarioServico.alterarLivro(livro);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void bloqueioTemporarioDeCliente(Cliente cliente){
        try{
            funcionarioServico.bloqueioTemporarioDeCliente(cliente);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    protected Usuario autenticacao(String login, String senha) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apresentacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
