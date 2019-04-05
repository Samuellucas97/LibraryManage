/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

import dados.ServicoException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.util.xml.impl.Pair;
import servicos.Administrador;
import servicos.Cliente;
import servicos.Operador;
import servicos.Usuario;
import servicos.UsuarioServico;
import servicos.UsuarioServicoConcreto;

/**
 * Interface da apresentação do usuário
 * @author Thiago da Costa Monteiro
 */
public class UsuarioTerminal extends Terminal {
    
    private final UsuarioServico usuarioServico;
    private int LoginErrado = 0; 
    private String login = "";
    private String senha = "";

    public UsuarioTerminal() {
        this.usuarioServico = new UsuarioServicoConcreto();
    }
    

    
//public abstract void realizarLogin(String login, String senha);
    @Override
    public void apresentacao( ){
        int repetir = 0;
        Scanner entradaUsuario = new Scanner(System.in);
        while(repetir == 0){
            repetir = 1;
            System.out.println("Bem vindo(a) ao LibraryManage! \n"
                    + "Digite o número de uma das opções: \n"
                    + "(1)Realizar login \n"
                    + "(2)Buscar livro \n");
            while(repetir == 1){
                String entradaNumero = entradaUsuario.next();
                if(entradaNumero.equals("1")){
                    repetir = 2;
                    System.out.println("");
                    System.out.println("REALIZANDO LOGIN...");
                    while(repetir == 2){
                        System.out.print("Digite seu login:");
                        this.login = entradaUsuario.next();

                        System.out.print("Digite sua senha:");
                        this.senha = entradaUsuario.next();

                        repetir = 3;

                        try {
                            this.login(login, senha);
                        } catch (ServicoException ex) {
                            repetir = 2;
                            System.err.println(ex.getMessage());
                            if(ex.getMessage().equals("Login de usuario nao cadastrado")){
                                this.LoginErrado++;
                                if(this.LoginErrado < 3) {
                                    System.out.println("Erro " + LoginErrado 
                                            + " de 3. Com 3 erros você será redirecinado"
                                            + "para o menu inicial.");
                                }
                                if(this.LoginErrado == 3){
                                    this.LoginErrado = 0;
                                    repetir = 0;
                                }
                            }                            
                        }
                    }


                }
                else if(entradaNumero.equals("2")){
                    repetir = 2;
                    // coisas de buscar livro
                }
                else
                {
                     System.out.println("Escolha inválida! \n" 
                             + "Digite o número de uma das opções: \n"
                             + "(1)Realizar login \n"
                             + "(2)Buscar livro \n");
                }
            }
        }
    }
    
    
   
    @Override
    protected Usuario autenticacao(String login, String senha) throws ServicoException {
        return this.usuarioServico.autenticacao(login, senha);
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
   
}

