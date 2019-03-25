/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import servicos.Autenticacao;
import dados.ServicoException;
import java.util.HashMap;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class UsuarioDAOArquivo implements UsuarioDAO{
    
    private HashMap<String, Usuario> hMap = new HashMap<String, Usuario>();
    
    public boolean autenticacao(String login, String senha) throws ServicoException{
        
        if( this.buscaUsuarioNoArquivo(login, senha).equals("OK")){
            throw new ServicoException( this.buscaUsuarioNoArquivo(login, senha) );
        }
        return true;       
    }   
    	
    private String lerArquivo(String nomeDoArquivo){
        
        String linha = new String();
                
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader( nomeDoArquivo ));
            
            while( buffReader.ready() ){              // -> LENDO CADA LINHA  
                linha += buffReader.readLine() + "\n";
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
        
        return linha;
        
    }
    
    private void transformaStringEmHashMap(String conteudoArquivo){
    
        hMap.clear();
        
        String loginTemporario = new String();
        String senhaTemporaria = new String();
        Usuario usuario = new Usuario();
        
        for(String linhaDoArquivo: conteudoArquivo.split("\n") ){
            loginTemporario = linhaDoArquivo.split(";")[0].split(":")[1];
            senhaTemporaria = linhaDoArquivo.split(";")[1].split(":")[1];
        }
        
        
    }
    
    
    private String buscaUsuarioNoArquivo( String login, String senha){
        
        String[] usuariosCadastrados;
        
        this.lerArquivo("./arquivos/usuariosCadastrados.dat");
       
            
            if( loginTemporario.equals(login) && senhaTemporaria.equals(senha) )
                return true;
            
        }
        
        return false;
    }
    private boolean salvarArquivo(String nomeArquivo, String conteudoArquivo){
		
        if(conteudoArquivo.equals("")) {
                return false;
        }
	
	try{

          nomeArquivo += ".dat";
		  FileWriter writer = new FileWriter(nomeArquivo);     
		  writer.write(conteudoArquivo);
		  writer.close(); 		
		  return true;

        }
        catch(FileNotFoundException e){   // -> ARQUIVO NãO EXISTE
	        System.err.println( e.getMessage() );
	        return false;        
        }
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO
            System.err.println( e.getMessage() );
            return false;
        }
    
    }

    public static void main(String[] args){
        
        UsuarioDAO e = new UsuarioDAOArquivo();
        
        System.out.println(e.autenticacao("Samuel", "admin") );
    
    }
    
}
