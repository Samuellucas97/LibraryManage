/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.HashMap;
import servicos.Administrador;
import servicos.Funcionario;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class AdministradorDAOArquivo extends FuncionarioDAOArquivo implements AdministradorDAO {

    
    private HashMap<String, Administrador> hMapAdministrador = new HashMap<String, Administrador>();
            
    
    @Override
    protected void transformaStringEmHashMap(String conteudoArquivo) {
    hMapAdministrador.clear();
        
        Administrador administrador = new Administrador();
        
        for(String linhaDoArquivo: conteudoArquivo.split("\n") ){

            administrador.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
            administrador.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
            administrador.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
            administrador.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
            administrador.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
            administrador.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );

            hMapAdministrador.put( administrador.getLogin(), administrador);

        }
    }

    @Override
    protected String autenticar(String login, String senha) {
        
        Funcionario funcionarioTemporario = hMapAdministrador.get(login);
        
        if(  funcionarioTemporario == null )
            return "Login de usuario nao cadastrado";
                
        if( !senha.equals( funcionarioTemporario.getSenha() ) )
            return "Senha de usuario incorreta";
                    
        return "OK";
        
    }

    public Usuario buscar(String login) throws NullPointerException {
        return hMapAdministrador.get(login);
    }

    @Override
    public void salvar(Administrador administrador) throws ServicoException {
        /// TODO
    }

    @Override
    public void salvar(Funcionario funcionario) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
