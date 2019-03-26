/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.HashMap;
import servicos.Cliente;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class ClienteDAOArquivo extends UsuarioDAOArquivo implements ClienteDAO {

    private HashMap<String, Cliente> hMapCliente = new HashMap<String, Cliente>();
            
    public Cliente buscarCliente( String loginCliente ) throws ServicoException{
       
        try{
        
            return this.hMapCliente.get(loginCliente);
        }catch( NullPointerException e){
            throw new ServicoException( "Usuario nao existe" );
        }
        catch( ClassCastException e ){
            throw new ServicoException( "O usuario nao eh um cliente");
        }
            
    }

    public void salvar(Cliente cliente) throws ServicoException {
        
    }
    
    @Override
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

            hMapCliente.put( cliente.getLogin(), cliente);

        }
    
    }    

    @Override
    protected String autenticar(String login, String senha) {
        
        Usuario usuarioTemporario = hMapCliente.get(login);
        
        if(  usuarioTemporario == null )
            return "Login de usuario nao cadastrado";
                
        if( !senha.equals( usuarioTemporario.getSenha() ) )
            return "Senha de usuario incorreta";
                    
        return "OK";
     
    }

    @Override
    public Usuario buscar(String login) throws NullPointerException {
        return hMapCliente.get(login);
    }

}
