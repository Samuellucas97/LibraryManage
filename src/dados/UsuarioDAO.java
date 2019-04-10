/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.List;
import servicos.Usuario;

/**
 * Interface de manipulação de dados
 * @author Samuel Lucas de Moura Ferino
 *         José Welliton Nunes Júnior
 */
public interface UsuarioDAO {

    public Usuario autenticacao(String login, String senha) throws ServicoException;
    public Usuario consultar( String login ) throws ServicoException;
    
    public List<Usuario> consultaUsuarios(List<String> params, List<String> keys) throws ServicoException;
    public List<Usuario> consultaUsuarios(String param, String key) throws ServicoException;
    
    public void registrar(Usuario usuario) throws ServicoException;
    public void alterar(String usuarioLogin,  Usuario usuarioAlterado) throws ServicoException;
    public void excluir(Usuario usuario) throws ServicoException;
    
}
