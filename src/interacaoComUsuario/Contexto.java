/**
 * @author Thiago da Costa Monteiro
 * @author José Wellinton
 * 
 */
package interacaoComUsuario;

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