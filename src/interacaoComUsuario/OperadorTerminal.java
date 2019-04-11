/**
 * @author Thiago da Costa Monteiro
 * 
 */
//Package
package interacaoComUsuario;

//Imports
import dados.ServicoException;
import java.util.List;
import java.util.Scanner;
import servicos.OperadorServico;
import servicos.Usuario;
import servicos.IUsuarioServico;
import servicos.Livro;
import servicos.Operador;
import servicos.UsuarioServicoFactory;

//Classe OperadorTerminal
public class OperadorTerminal extends Terminal{
    
    private IUsuarioServico operadorServico;
    private Usuario operador;

    public OperadorTerminal() {
        try{    
            this.operadorServico = UsuarioServicoFactory.getUsuarioServico("OperadorServico");
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
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
        if(escolha.equals("1")){
           return telaBuscaLivro();              
        }
        
        else if(escolha.equals("2")){
            return telaEmprestimo();
        }
        
        else if(escolha.equals("3")){
            return telaDevolucao();
        }
        
        else if(escolha.equals("4")){
            return telaBuscaCliente();
        }
        
        else if(escolha.equals("5")){
            return telaRegistrarCliente();
        }
        
        else if(escolha.equals("6")){
            return telaRegistrarLivro();
        }
        
        else if(escolha.equals("7")){
        System.out.println("Você escolheu a opção (7) - Realizar logout");
        System.out.println("REALIZANDO LOGOUT...");

        return new UsuarioTerminal();
        
        }
        
        return null;   
    }
    
    private List<Livro> efetuarBusca(String param, String key){
        try {
            return (List<Livro>) operadorServico.consultaLista(new Livro(), param, key);
        } 
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }

    private List<Livro> efetuarBusca(List<String> params, List<String> keys){
        try{
            return (List<Livro>) this.operadorServico.consultaLista(new Livro(), params, keys);

        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
    
    public void efetuarEmprestimoLivros(Livro livro){
        try{    
            ((OperadorServico)operadorServico).emprestimoDeLivro(livro);
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }         
    }
    
    
    
    private Object telaBuscaLivro(){
        String op;
        String key;
        System.out.println("Você escolheu a opção (2) - Buscar livro");
        System.out.println("As opções de busca são:");
        System.out.println("(1) Buscar por Título");
        System.out.println("(2) Buscar por Autor");
        System.out.println("(3) Buscar por Assunto");
        System.out.println("(4) Buscar por Data de Lançamento");
        System.out.println("(5) Buscar por Edição");
        System.out.println("(6) Buscar por Editora");
        System.out.println("(7) Buscar por ID do livro");

        while(true){
            Scanner entradaUsuario = new Scanner(System.in);
            op = entradaUsuario.next();
            switch (op) {
                case "1":
                    System.out.print("Digite o título do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("Titulo" , key);
                case "2":
                    System.out.print("Digite o nome do autor do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("Autor" , key);
                case "3":
                    System.out.print("Digite o assunto do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("Assunto" , key);
                case "4":
                    System.out.print("Digite a data de lançamento do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("DataDeLancamento" , key);
                case "5":
                    System.out.print("Digite a edição do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("Edicao" , key);
                case "6":
                    System.out.print("Digite o nome da editora: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("Editora" , key);
                case "7":
                    System.out.print("Digite o ID do livro: ");
                    key = entradaUsuario.next();

                    return efetuarBusca("ID" , key);
                default:
                    System.out.println("Escolha inválida! \n");
                    System.out.println("As opções de busca são:");
                    System.out.println("(1) Buscar por Título");
                    System.out.println("(2) Buscar por Autor");
                    System.out.println("(3) Buscar por Assunto");
                    System.out.println("(4) Buscar por Data de Lançamento");
                    System.out.println("(5) Buscar por Edição");
                    System.out.println("(6) Buscar por Editora");
                    System.out.println("(7) Buscar por ID do livro");
                    break;
            }
        }
    
    }
    // emprestar livro por id e/ou título e nome do cliente como parametros
    private Object telaEmprestimo(){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("Você escolheu a opção (2) - Efetuar empréstimo de livro \n");
        System.out.print("Digite o título do livro que você deseja pegar emprestado \n");
        //System.out.print("Digite o ID do livro que você deseja pegar emprestado \n");
        String tituloLivro = entradaUsuario.next();
        while()
        
        
        
        try{
            efetuarEmprestimoLivros(livro) ;
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        return "Livro emprestado com sucesso!";
    }
    
    public Operador getOperador(){
        return (Operador)operador;
    }
    public void SetOperador(Operador operadorNovo){
        this.operador = operadorNovo;
    }
    /*
    private Object telaDevolucao(){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("Você escolheu a opção (3) - Efetuar devolução de livro \n");
    }
    //private Object telaBuscaCliente(){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("Você escolheu a opção (4) - Buscar cliente \n");
    }
    //private Object telaRegistrarCliente(){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("Você escolheu a opção (5) - Registrar novo cliente \n");
    }
    //private Object telaRegistrarLivro(){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.print("Você escolheu a opção (6) - Registrar novo livro \n");
    } */
}

//--METODOS--//
       
    //public void efetuarDevolucaoLivros(Livro livro){}
    //public void consultarCliente(Cliente cliente){}
    //public void registrarCliente(Cliente cliente){}
    //public void bloqueioPermanenteDeCliente(Cliente cliente){}
    //public void bloqueioTemporarioDeCliente(Cliente cliente){}
    
    //public void alterarLivros(Livro livro){}
    //public bloqueioTemporarioDeLivros(Livro livro){}
    //public bloqueioPermanenteDeLivros(Livro livro){}