/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacaoComUsuario;

import java.util.Scanner;

/**
 * Interface da apresentação do usuário
 * @author SamDan
 */
public class UsuarioTerminal {

//    public abstract void realizarLogin(String login, String senha);
    public void autenticacao( ){
    
        Scanner entradaUsuario = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("REALIZANDO LOGIN -");
        System.out.print("Digite seu login:");
        String loginTemporario = entradaUsuario.next();

        System.out.print("Digite sua senha:");
        String senhaTemporaria = entradaUsuario.next();

    
    }
    public void realizarLogout(){}
    
}



