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
public class UsuarioDAOArquivo implements UsuarioDAO{
    
    private HashMap<String, Usuario> hMapUsuarios = new HashMap<String, Usuario>();
    
    public UsuarioDAOArquivo(){}
    
    public boolean autenticacao(String login, String senha) throws ServicoException{
        
        if( this.autenticarUsuario(login, senha).equals("OK")){
            throw new ServicoException( this.autenticarUsuario(login, senha) );
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
    
        hMapUsuarios.clear();
        
        Usuario usuario;
        
        for(String linhaDoArquivo: conteudoArquivo.split("\n") ){
            
            if ( linhaDoArquivo.split(";")[1].split(":")[1].equals("cliente")  ) {
                
                usuario = new Cliente();
                
                usuario.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
                usuario.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
                usuario.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
                usuario.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
                usuario.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
                usuario.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );
            
                hMapUsuarios.put( usuario.getLogin(), usuario);
                
                continue;
                
            }
            
            if( linhaDoArquivo.split(";")[1].split(":")[1].equals("administrador") ){
                
                usuario = new Administrador();
                
                usuario.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
                usuario.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
                usuario.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
                usuario.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
                usuario.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
                usuario.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );
                
                hMapUsuarios.put( usuario.getLogin(), usuario);
                
                continue;
                
            }
            
//      FAZER A CLASSE OPERADOR                
//            else if( linhaDoArquivo.split(";")[1].split(":")[1].equals("operador") ){
//                usuario = new Operador();
//                usuario.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
//                usuario.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
//                usuario.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
//                usuario.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
//                usuario.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
//                usuario.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );
//                hMapUsuarios.put( usuario.getLogin(), usuario);
//                
//                  continue;
//                  
//            }
        }
        
        
    }
    
    private String autenticarUsuario( String login, String senha){
        
        Usuario usuarioTemporario = hMapUsuarios.get(login);
        
        if(  usuarioTemporario == null )
            return "Login de usuario nao cadastrado";
                
        if( !senha.equals( usuarioTemporario.getSenha() ) )
            return "Senha de usuario incorreta";
                    
        return "OK";
    }
    
    private Usuario buscarUsuario( String login ) throws NullPointerException{
        return hMapUsuarios.get(login);
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
