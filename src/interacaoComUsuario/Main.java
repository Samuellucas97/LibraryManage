package interacaoComUsuario;

import java.util.Scanner;
import servicos.Usuario;

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
        Contexto estados = new Contexto();
        Usuario usr = new Usuario();
        
        while(true){
            Object obj = estados.getEstado().tratamentoEscolha(estados.getEstado().apresentacao());
        
        
        
        
        
        
        
        
        }
        
        
    }

	
}
