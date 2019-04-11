/**
 * @author Thiago da Costa Monteiro
 * 
 */

//Package
package interacaoComUsuario;

//Imports
import dados.ServicoException;
import java.util.Scanner;
import servicos.Administrador;
import servicos.AdministradorServico;
import servicos.Usuario;
import servicos.IUsuarioServico;

//Classe AdministradorTerminal
public class AdministradorTerminal extends Terminal{
    //--ATRIBUTOS--//
    private IUsuarioServico administradorServico;
    private Usuario administrador;

    public AdministradorTerminal() {
        this.administradorServico = (IUsuarioServico) new AdministradorServico();
    }  
    
    //--METODOS--//
    /*
    public void consultarFuncionario(String loginFuncionario){
        try{
            administradorServico.consultarFuncionario(loginFuncionario);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    public void registrarFuncionario(String loginFuncionario, String senhaFuncionario, String nomeFuncionario,
                                 String telefoneFuncionario, int idadeFuncionario, String generoFuncionario){
        try{
            funcionarioServico.registrarFuncionario(loginFuncionario, senhaFuncionario, nomeFuncionario,
                                                telefoneFuncionario, idadeFuncionario, generoFuncionario);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario){
        try{
                funcionarioServico.bloqueioPermanenteDeFuncionario(funcionario);
        }
        catch (ServicoException ex) {
                System.err.println(ex.getMessage());
        }
    }
   
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario){
        try{
            funcionarioServico.bloqueioTemporarioDeFuncionario(funcionario);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluirUsuario(Usuario usuario){
        try{
            funcionarioServico.excluirUsuario(usuario);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void excluirLivro(Livro livro){
        try{
            funcionarioServico.excluirLivro(livro);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void alterarFuncionario(Funcionario funcionario){
        try{
            funcionarioServico.alterarFuncionario(funcionario);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }
    */
    /*
    @Override
    protected void autenticacao(String login, String senha){
        try{
            this.administrador = this.administradorServico.autenticacao(login, senha);
           
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        return this.administrador;
    } */

    @Override
    public String apresentacao( ){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a), " + administrador.getNome() + " ao LibraryManage! \n"
                        + "Digite o número de uma das opções: \n"
                        + "(1)Buscar livro \n"
                        + "(2)Efetuar empréstimo de livro \n"
                        + "(3)Efetuar devolução de livro \n"
                        + "(4)Registrar novo livro \n"
                        + "(5)Buscar cliente \n"
                        + "(6)Registrar novo cliente \n"
                        + "(7)Buscar funcionario"
                        + "(8)Registrar novo funcionario \n"
                        + "(9)Realizar logout");
        while(true){
            String entradaNumero = entradaUsuario.next();
            if(entradaNumero.equals("1") 
               || entradaNumero.equals("2")
               || entradaNumero.equals("3")
               || entradaNumero.equals("4")
               || entradaNumero.equals("5")
               || entradaNumero.equals("6")
               || entradaNumero.equals("7")
               || entradaNumero.equals("8")
               || entradaNumero.equals("9")){
                return entradaNumero;
            }
            else{
                 System.out.println("Escolha inválida! \n" 
                                    + "Digite o número de uma das opções: \n"
                                    + "(1)Buscar livro \n"
                                    + "(2)Efetuar empréstimo de livro \n"
                                    + "(3)Efetuar devolução de livro \n"
                                    + "(4)Registrar novo livro \n"
                                    + "(5)Buscar cliente \n"
                                    + "(6)Registrar novo cliente \n"
                                    + "(7)Buscar funcionario"
                                    + "(8)Registrar novo funcionario \n"
                                    + "(9)Realizar logout");
            }
        }
    }

    @Override
    public Object tratamentoEscolha(String escolha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Administrador getAdministrador(){
        return (Administrador)administrador;
    }
    public void SetAdministrador(Administrador administradorNovo){
        this.administrador = administradorNovo;
    }

}
