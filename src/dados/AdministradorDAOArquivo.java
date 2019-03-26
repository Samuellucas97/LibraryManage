/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class AdministradorDAOArquivo extends FuncionarioDAOArquivo implements AdministradorDAO {

    @Override
    protected void transformaStringEmHashMap(String conteudoArquivo) {
    
    }

    @Override
    protected String autenticar(String login, String senha) {
        
    }

    @Override
    public Usuario buscar(String login) throws NullPointerException {
    
    }
    
}
