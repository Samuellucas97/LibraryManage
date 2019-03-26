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

/**
 * Interface da apresentação do usuário
 * @author SamDan
 */
public class UsuarioTerminal {

//    public abstract void realizarLogin(String login, String senha);
    public void apresentacao( ){
        int key = 0;
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Bem vindo(a) ao LibraryManage! \n"
                + "Escolha o número de uma das opções: \n"
                + "(1)Realizar login \n"
                + "(2)Buscar livro \n");
        while(key == 0){
            String entradaNumero = entradaUsuario.next();
            if(entradaNumero.equals("1"))
            {
                key = 1;
                System.out.println("\n");
                System.out.println("REALIZANDO LOGIN -");
                while(key == 1)
                {
                    System.out.print("Digite seu login:");
                    String loginTemporario = entradaUsuario.next();

                    System.out.print("Digite sua senha:");
                    String senhaTemporaria = entradaUsuario.next();
                    
                    key = 2;
                    
                    try {
                        this.autenticacao(loginTemporario, senhaTemporaria);
                    } catch (ServicoException ex) {
                        key = 1;
                        System.err.println(ex.getMessage());
                    }
                }
                
                
            }
            else if(entradaNumero.equals("2"))
            {
                key = 1;
                // coisas de buscar livro
            }
            else
            {
                 System.out.println("Escolha inválida! Tente 1 para REALIZAR LOGIN \n"
                         + "ou 2 para BUSCAR LIVRO. \n");
            }
        }
        
        
    }
    
    private void autenticacao(String login, String senha) 
                                    throws ServicoException{
    
        
        
        
        
        
    }
    public void realizarLogout(){}
    
}



