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
import servicos.UsuarioServico;

/**
 * Interface da apresentação do usuário
 * @author SamDan
 */
public class UsuarioTerminal {
    
    private UsuarioServico usuarioServico;
    private int LoginErrado = 0; 

    public UsuarioTerminal() {
        this.usuarioServico = new UsuarioServico();
    }
    
    
    
//    public abstract void realizarLogin(String login, String senha);
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
                        String loginTemporario = entradaUsuario.next();

                        System.out.print("Digite sua senha:");
                        String senhaTemporaria = entradaUsuario.next();

                        repetir = 3;

                        try {
                            this.autenticacao(loginTemporario, senhaTemporaria);
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
    
    private void autenticacao(String login, String senha) throws ServicoException{
        this.usuarioServico.autenticacao(login, senha);
    }
    public void realizarLogout(){
        
    }
    
}



