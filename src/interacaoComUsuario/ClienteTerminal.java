/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

import dados.ServicoException;
import servicos.Administrador;
import servicos.Cliente;
import servicos.Operador;
import servicos.Usuario;
import servicos.UsuarioServico;
import servicos.UsuarioServicoConcreto;


/**
 *
 * @author Thiago da Costa Monteiro
 */
public class ClienteTerminal extends Terminal{
    
    UsuarioServico usuarioServico;

    public ClienteTerminal() {
        this.usuarioServico = new UsuarioServicoConcreto();
    }

    @Override
    protected Usuario autenticacao(String login, String senha){
        try{
            this.usuarioServico.autenticacao(login, senha);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        return null; // TO DO
    }

    @Override
    public void apresentacao() {
        //to do
    }

}
