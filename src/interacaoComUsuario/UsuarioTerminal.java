/**
 * Interface da apresentação do usuário
 * @author Thiago da Costa Monteiro
 */
package interacaoComUsuario;

import dados.ServicoException;
import java.util.List;
import java.util.Scanner;
import servicos.Administrador;
import servicos.Cliente;
import servicos.ILivroServico;
import servicos.IUsuarioServico;
import servicos.Livro;
import servicos.LivroServico;
import servicos.Operador;
import servicos.Usuario;
import servicos.UsuarioServicoFactory;


public class UsuarioTerminal extends Terminal {
    
    private IUsuarioServico clienteServico;
    private IUsuarioServico operadorServico;
    private IUsuarioServico administradorServico;

    private ILivroServico livroServico; 

    private Usuario usuario;
    private String login = "";
    private String senha = "";
    

    public UsuarioTerminal() {
        try{
            this.clienteServico = UsuarioServicoFactory.getUsuarioServico("ClienteServico");
//            this.operadorServico = UsuarioServicoFactory.getUsuarioServico("OperadorServico");
//            this.administradorServico = UsuarioServicoFactory.getUsuarioServico("AdministradorServico");
            this.livroServico = LivroServico.getInstance();

        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    @Override
    public String apresentacao( ){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a) ao LibraryManage! \n"
                        + "Digite o número de uma das opções: \n"
                        + "(1)Realizar login \n"
                        + "(2)Buscar livro \n");
        String entradaNumero;
        while(true){
            entradaNumero = entradaUsuario.next();
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

    protected void autenticacao(String login, String senha){
        Usuario usr = null;
        
        try{
           usr = this.clienteServico.autenticacao(login, senha);
           if(usr != null){
               this.usuario = usr;
           }
           else{
                usr = this.operadorServico.autenticacao(login, senha);
                if(usr != null){
                    this.usuario = usr;
                }
                else{
                    usr = this.administradorServico.autenticacao(login, senha);
                    if(usr != null){
                        this.usuario = usr;
                    }
                    else{
                        System.err.println("Autenticação falhou!");
                    }
                }
           }
           
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
    }   

   @Override
    public Terminal login(String login, String senha){
             
        autenticacao(login, senha);
        
        if(usuario.getClass().isInstance(new Cliente())){
            return new ClienteTerminal();
        }
        else if(usuario.getClass().isInstance(new Administrador())){
            return new AdministradorTerminal();
        }       
        else if(usuario.getClass().isInstance(new Operador())){
            return new OperadorTerminal();
        }
        else{
            return null;
        }
    }
    
    

    @Override
    public Object tratamentoEscolha(String escolha) {
        Scanner entradaUsuario = new Scanner(System.in);
        if(escolha.equals("1")){
            System.out.print("Você escolheu a opção (1) - Realizar login \n"
                        + "Digite o seu login: ");
            login = entradaUsuario.next();
            System.out.print("\n Digite sua senha: ");
            System.out.println("");
            senha = entradaUsuario.next();
            if(this.usuario == null){
                return null;
            }
            else{
                return login(login, senha);

            }

            
        }
        if(escolha.equals("2")){
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
        
        return null;
    }
   
    private List<Livro> efetuarBusca(String param, String key){
        try{
            return this.livroServico.consultaLivros(param, key);
            
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;  
    }
    
    private List<Livro> efetuarBusca(List<String> params, List<String> keys){
        try{
            return this.livroServico.consultaLivros(params, keys);
            
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
     public void setUsuario(Usuario usr){
         this.usuario = usr;
     }
}
