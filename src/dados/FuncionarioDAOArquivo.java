/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;


/**
 *
 * @author SamDan
 */
public abstract class FuncionarioDAOArquivo extends UsuarioDAOArquivo implements FuncionarioDAO {

    @Override
    protected abstract void transformaStringEmHashMap(String conteudoArquivo);

    @Override
    protected abstract String autenticar(String login, String senha);



    
}
