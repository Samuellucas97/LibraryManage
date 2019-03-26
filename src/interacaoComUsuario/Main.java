package interacaoComUsuario;

import java.util.Scanner;

/**
 * Implementação da Main
 * @author	Samuel Lucas de Moura Ferino
 * @since	08.03.2019 
 * @version	0.0.1
 */
public class Main {

	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        int opcaoEscolhida;
        Scanner entradaUsuario = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("LibraryManage - version 1.0");
        System.out.println("\n");
        System.out.println("MENU:");
        System.out.println("1 - Fazer login;");
        System.out.println("\n");
        System.out.print("Digite o respectivo numero da opcao escolhida:");
        
        opcaoEscolhida = entradaUsuario.nextInt();
        
        switch(opcaoEscolhida){
            case 1: 
                
                System.out.println("\n");
                System.out.println("REALIZANDO LOGIN -");
                System.out.print("Digite seu login:");
                String loginTemporario = entradaUsuario.next();
                
                System.out.print("Digite sua senha:");
                String senhaTemporaria = entradaUsuario.next();
                    
                
                break;
            default:    
        }
        
        
    }

	
}
