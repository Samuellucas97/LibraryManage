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
import java.util.HashMap;
import servicos.Administrador;
import servicos.Cliente;
import servicos.Usuario;

/**
 * Representa um 
 * @author  Samuel Lucas de Moura Ferino
 *          José Wellinton
 */
public abstract class UsuarioDAOArquivo implements UsuarioDAO{
    
//    private HashMap<String, Usuario> hMapUsuarios = new HashMap<String, Usuario>();
    
    public UsuarioDAOArquivo(){}
    
    protected abstract void transformaStringEmHashMap(String conteudoArquivo );    
     
    protected abstract String autenticar( String login, String senha);
    
    @Override
    public boolean autenticacao(String login, String senha) throws ServicoException{
        
        ClienteDAOArquivo cliente = new ClienteDAOArquivo();
        AdministradorDAOArquivo administrador = new AdministradorDAOArquivo();
        OperadorDAOArquivo operador = new OperadorDAOArquivo();
        
        if(cliente.autenticar(login, senha).equals("OK")) return true;
        if(administrador.autenticar(login, senha).equals("OK")) return true;
        if(operador.autenticar(login, senha).equals("OK")) return true;
        
        throw new ServicoException( this.autenticar(login, senha) );      
    }   
    	
    protected String lerArquivo(String nomeDoArquivo){
        
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
    
    private boolean salvarArquivo(String nomeArquivo, String conteudoArquivo){
		
        if( conteudoArquivo.equals("") ) {
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
    
}
