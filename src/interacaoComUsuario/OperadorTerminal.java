/**
 * @author Thiago da Costa Monteiro
 * 
 */
//Package
package interacaoComUsuario;

//Imports
import dados.ServicoException;
import java.util.Scanner;
import servicos.OperadorServico;
import servicos.Usuario;
import servicos.IUsuarioServico;

//Classe OperadorTerminal
public class OperadorTerminal extends Terminal{
    
    private final IUsuarioServico operadorServico;
    private Usuario operador;

    public OperadorTerminal() {
        this.operadorServico = (IUsuarioServico) new OperadorServico();
    }
    
    //--METODOS--//
    //public void efetuarEmprestimoLivros(Livro livro){} // atualiza ranking           
    //public void efetuarDevolucaoLivros(Livro livro){}
    //public void consultarCliente(Cliente cliente){}
    //public void registrarCliente(Cliente cliente){}
    //public void bloqueioPermanenteDeCliente(Cliente cliente){}
    //public void bloqueioTemporarioDeCliente(Cliente cliente){}
    //public void registrarLivros(Livro livro){}
    //public void alterarLivros(Livro livro){}
    //public bloqueioTemporarioDeLivros(Livro livro){}
    //public bloqueioPermanenteDeLivros(Livro livro){}
    
    
    @Override
    protected void autenticacao(String login, String senha){
        try{
            this.operador = this.operadorServico.autenticacao(login, senha);
           
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        return this.operador;
    }

    @Override
    public String apresentacao( ){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a), " + operador.getNome() + " ao LibraryManage! \n"
                        + "Digite o número de uma das opções: \n"
                        + "(1)Buscar livro \n"
                        + "(2)Efetuar empréstimo de livro \n"
                        + "(3)Efetuar devolução de livro \n"
                        + "(4)Buscar cliente \n"
                        + "(5)Registrar novo cliente \n"
                        + "(6)Registrar novo livro \n"
                        + "(7)Realizar logout");
        while(true){
            String entradaNumero = entradaUsuario.next();
            if(entradaNumero.equals("1") 
               || entradaNumero.equals("2")
               || entradaNumero.equals("3")
               || entradaNumero.equals("4")
               || entradaNumero.equals("5")
               || entradaNumero.equals("6")
               || entradaNumero.equals("7")){
                return entradaNumero;
            }
            else{
                 System.out.println("Escolha inválida! \n" 
                                    + "Digite o número de uma das opções: \n"
                                    + "(1)Buscar livro \n"
                                    + "(2)Efetuar empréstimo de livro \n"
                                    + "(3)Efetuar devolução de livro \n"
                                    + "(4)Buscar cliente \n"
                                    + "(5)Registrar novo cliente \n"
                                    + "(6)Registrar novo livro \n"
                                    + "(7)Realizar logout");
            }
        }
    }

    @Override
    public Object tratamentoEscolha(String escolha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}