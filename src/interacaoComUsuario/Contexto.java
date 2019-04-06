/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

/**
 *
 * @author Thiago da Costa Monteiro
 * @author José Wellinton
 */
public class Contexto {
    private Terminal estadoAtual;

    //CONSTRUTOR
    public Contexto() {
        this.estadoAtual = new UsuarioTerminal();
        
    }
    
    // GET/SET ESTADO
    public void setEstado(Terminal estado){
        this.estadoAtual = estado;
    }
    
    public Terminal getEstado(){
        return estadoAtual;
    }
}