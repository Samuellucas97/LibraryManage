/**
 * Interface da apresentação do usuário
 * @author Thiago da Costa Monteiro
 */
package interacaoComUsuario;

import dados.ServicoException;
import java.util.Scanner;
import servicos.UsuarioServico;
import servicos.IUsuarioServico;
import servicos.Usuario;


public class UsuarioTerminal extends Terminal {
    
    private final IUsuarioServico usuarioServico;
    private Usuario usuario;
    private int LoginErrado = 0; 
    private String login = "";
    private String senha = "";

    public UsuarioTerminal() {
        this.usuarioServico = new UsuarioServico();
    }
    
    
    //public abstract void realizarLogin(String login, String senha);
    
    @Override
    public String apresentacao( ){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a) ao LibraryManage! \n"
                        + "Digite o número de uma das opções: \n"
                        + "(1)Realizar login \n"
                        + "(2)Buscar livro \n");
        while(true){
            String entradaNumero = entradaUsuario.next();
            if(entradaNumero.equals("1") || entradaNumero.equals("2")){
                return entradaNumero;
            }
            else{
                 System.out.println("Escolha inválida! \n" 
                                    + "Digite o número de uma das opções: \n"
                                    + "(1)Realizar login \n"
                                    + "(2)Buscar livro \n");
            }
        }
    }

    @Override
    protected Usuario autenticacao(String login, String senha){
        try{
            this.usuario = this.usuarioServico.autenticacao(login, senha);
           
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        return this.usuario;
    }

    @Override
    public Object tratamentoEscolha(String escolha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

   @Override
    public Terminal login(String login, String senha) throws ServicoException {
        
        Usuario usr = autenticacao(login, senha);
        
        
        if(usr.getClass().isInstance(new Cliente())){
            return new ClienteTerminal();
        }
        else if(usr.getClass().isInstance(new Administrador())){
            return new AdministradorTerminal();
        }       
        else if(usr.getClass().isInstance(new Operador())){
            return new OperadorTerminal();
        }
        else{
            throw new ServicoException("Usuário não é de tipo válido!");
        }
    }

    @Override
    public Object tratamentoEscolha(String escolha) {
        if(escolha.equals("1")
    }
   
}

