/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SamDan
 */
public class UsuarioDAOArquivo implements UsuarioDAO{
    
    private String conteudoArquivo;

    public UsuarioDAOArquivo(){
        conteudoArquivo = "";      
    }
    
    public boolean autenticacao(String login, String senha)  {
        return buscaUsuarioNoArquivo(login, senha);       
    }   
    	
    private void lerArquivo(String nomeDoArquivo){
        
        String linha = new String();
        
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader( nomeDoArquivo ));
            
            while( buffReader.ready() ){              // -> LENDO CADA LINHA  
                linha = buffReader.readLine();
                this.conteudoArquivo += linha + "\n";
            }
            
            buffReader.close();
        }
        catch(FileNotFoundException e){  // -> Arquivo não existe
            System.err.println( e.getMessage() );
        }
        catch( NullPointerException e){
            System.err.println( e.getMessage() );
        }
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO
            System.err.println( e.getMessage() );
        }
    }
    
    private boolean buscaUsuarioNoArquivo( String login, String senha){
        
        String[] usuariosCadastrados;
        String loginTemporario = new String();
        String senhaTemporaria = new String();

        lerArquivo("usuariosCadastrados.dat");
       
        usuariosCadastrados = this.conteudoArquivo.split("\n");
        for(String linhaDoArquivo: usuariosCadastrados ){
            loginTemporario = linhaDoArquivo.split(";")[0].split(":")[1];
            senhaTemporaria = linhaDoArquivo.split(";")[1].split(":")[1];
        }
        
        return false;
    }
}
