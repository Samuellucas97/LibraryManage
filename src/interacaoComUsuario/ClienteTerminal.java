/**
 * @author Thiago da Costa Monteiro
 * 
 * 
 */
package interacaoComUsuario;

import dados.ServicoException;
import java.util.List;
import java.util.Scanner;
import servicos.Cliente;
import servicos.ClienteServico;
import servicos.Usuario;
import servicos.IUsuarioServico;
import servicos.Livro;
import servicos.UsuarioServicoFactory;



public class ClienteTerminal extends Terminal{
    
    private IUsuarioServico clienteServico;  
    private Usuario cliente;

    public ClienteTerminal() {
        try{    
            this.clienteServico = UsuarioServicoFactory.getUsuarioServico("ClienteServico");
        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    @Override
    public String apresentacao( ){
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a), " + cliente.getNome() + " ao LibraryManage! \n"
                        + "Digite o número de uma das opções: \n"
                        + "(1)Avaliar livro \n"
                        + "(2)Buscar livro \n"
                        + "(3)Realizar logout");
        while(true){
            String entradaNumero = entradaUsuario.next();
            if(entradaNumero.equals("1") 
               || entradaNumero.equals("2")
               || entradaNumero.equals("3")){
                return entradaNumero;
            }
            else{
                 System.out.println("Escolha inválida! \n" 
                                    + "Digite o número de uma das opções: \n"
                                    + "(1)Avaliar livro \n"
                                    + "(2)Buscar livro \n"
                                    + "(3)Realizar logout \n");
            }
        }
    }

    @Override
    public Object tratamentoEscolha(String escolha) {
        if(escolha.equals("1")){
            return telaAvaliação();
        }
        else if(escolha.equals("2")){
            return telaBuscaLivro();
        }
        
        else if(escolha.equals("3")){
        System.out.println("Você escolheu a opção (3) - Realizar logout");
        System.out.println("REALIZANDO LOGOUT...");

        return new UsuarioTerminal();
        
        }
        
        return null;   
    }
    
    private List<Livro> efetuarBusca(String param, String key){
        try {
            return (List<Livro>) clienteServico.consultaLista(new Livro(), param, key);
        } 
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }

    private List<Livro> efetuarBusca(List<String> params, List<String> keys){
        try{
            return (List<Livro>) this.clienteServico.consultaLista(new Livro(), params, keys);

        }
        catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        return null;
    }
        
    private void avaliação(String livro, int nota, Cliente cliente) throws ServicoException{
        ((ClienteServico)clienteServico).inserirRankingLivro(livro, nota, cliente);
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
    
    private Object telaAvaliação(){
        Scanner entradaUsuario = new Scanner(System.in);
        List<Livro> livrosAvaliados = ((ClienteServico) clienteServico).listaLivrosAlugados((Cliente) cliente);
        System.out.print("Você escolheu a opção (1) - Avaliar livro \n");
        System.out.print("Gerando lista de livros que foram alugados por você... \n");
        if(livrosAvaliados.isEmpty()){
            return "Lista de livros pegos emprestado vazia!";
        }
        else{
            for (int i = 0; i < livrosAvaliados.size(); i++) {
            System.out.println("Lívro (" + i + ")");
            System.out.println("Título: " + livrosAvaliados.get(i).getTitulo());
            System.out.println("Autor: " + livrosAvaliados.get(i).getAutor());
            }
            System.out.println("Escolha o número do livro que você quer que seja avaliado");

            boolean numeric = true;
            Integer num = 0;
            while(true){
                String livroEscolhido = entradaUsuario.next();

                try {
                    num = Integer.parseInt(livroEscolhido);
                } 
                catch (NumberFormatException e) {
                    numeric = false;
                }

                if(numeric && (num>=0) && (num<livrosAvaliados.size())){
                    Integer avaliacao = 0;
                    System.out.println("De uma nota de 0 a 5 para o livro " + livrosAvaliados.get(num).getTitulo() + ":");
                    Integer num2 = 0;
                    boolean key2while = true;
                    while(key2while){
                        livroEscolhido = entradaUsuario.next();

                        try {
                            num2 = Integer.parseInt(livroEscolhido);
                        } 
                        catch (NumberFormatException e) {
                            numeric = false;
                        }
                        if(numeric && (num2>=0) && (num2<=5)){
                        avaliacao = num2;
                        key2while = false;
                        }
                        else{
                            System.out.println("Entrada incorreta! Insira um número de 0 a 5 para o livro "
                                                + livrosAvaliados.get(num).getTitulo() + "\n");
                        }
                    }
                    try{
                        avaliação(livrosAvaliados.get(num).getId(), avaliacao, (Cliente) cliente);
                    }
                    catch (ServicoException ex) {
                        System.err.println(ex.getMessage());
                    }
                    return "\nLivro avaliado com sucesso!\n";
                }
                else{
                    System.out.println("Escolha inválida! \n"); 
                    System.out.println("Escolha o número de um dos livros:");
                    for (int i = 0; i < livrosAvaliados.size(); i++) {
                        System.out.println("Lívro (" + i + ")");
                        System.out.println("Título: " + livrosAvaliados.get(i).getTitulo());
                        System.out.println("Autor: " + livrosAvaliados.get(i).getAutor());
                    }
                }
            }
        }
        

    }
    public Cliente getCliente(){
        return (Cliente)cliente;
    }
    public void SetCliente(Cliente clienteNovo){
        this.cliente = clienteNovo;
    }
                    
}
