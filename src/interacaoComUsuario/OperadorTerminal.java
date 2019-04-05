/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

import dados.ServicoException;
import servicos.FuncionarioServico;
import servicos.FuncionarioServicoConcreto;
import servicos.Usuario;

/**
 *
 * @author Thiago da Costa Monteiro
 */
public class OperadorTerminal extends Terminal{
    
   
    
    
    @Override
    protected Usuario autenticacao(String login, String senha) throws ServicoException {
        try{
            
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void apresentacao() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    
}
