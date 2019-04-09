/**
 * @author Thiago da Costa Monteiro
 * @author José Wellinton
 * 
 */
package interacaoComUsuario;

import dados.ServicoException;

public abstract class Terminal {
    
    //protected abstract void autenticacao(String login, String senha) throws ServicoException;
    public abstract String apresentacao();
    public abstract Object tratamentoEscolha(String escolha);
    
    public Terminal login(String login, String senha) throws ServicoException{
        return null;
    }
    
    public Terminal logout(){
        return new UsuarioTerminal();
    }
    
}
