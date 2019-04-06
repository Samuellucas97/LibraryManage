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
import servicos.Cliente;
import servicos.Livro;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class LivroDAOArquivo implements LivroDAO{

    private HashMap<String, Livro> hMapLivro = new HashMap<String, Livro>();
    
    public LivroDAOArquivo(){
    }

    @Override
    public void registrarLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarLivro() throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emprestimoDeLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void efetuarDevolucaoDeLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro consultaLivro(String idLivro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected void transformaStringEmHashMap(String conteudoArquivo){
    
        hMapCliente.clear();
        
        Cliente cliente = new Cliente();
        
        for(String linhaDoArquivo: conteudoArquivo.split("\n") ){

            cliente.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
            cliente.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
            cliente.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
            cliente.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
            cliente.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
            cliente.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );
            cliente.

            hMapCliente.put( cliente.getLogin(), cliente);

        }
    
    }    
    
    public String verificacao(String idLivro) throws ServicoException{
        
        this.transformaStringEmHashMap(this.lerArquivo(""));
        
        Livro livroTemporario = this.hMapLivro.get(idLivro);
        
        if(this.clienteDAO.autenticar(login, senha).equals("OK")){
            Usuario cliente = this.clienteDAO.buscar(login);
            return cliente;
        }
           if(livroTemporario == null)   return "Livro não encontrado";     
        
        
        return "OK";
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
