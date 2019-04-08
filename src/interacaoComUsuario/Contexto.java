/**
 * @author Thiago da Costa Monteiro
 * @author José Wellinton
 * 
 */
package interacaoComUsuario;

// Pattern STATE
public class Contexto {
    private Terminal estadoAtual;
    // Pattern SINGLETON
    private static Contexto instance;

    //CONSTRUTOR
    private Contexto() {
        this.estadoAtual = new UsuarioTerminal();
        
    }
    
    public static Contexto getInstance(){
        if(instance == null){
            Contexto.instance = new Contexto();
        }
        return Contexto.instance;
    }
    
    // GET/SET ESTADO
    public void setEstado(Terminal estado){
        this.estadoAtual = estado;
    }
    
    public Terminal getEstado(){
        return estadoAtual;
    }
}

// avaliacao seria a media ponderada de um float