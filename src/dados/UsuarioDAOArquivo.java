/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 * Representa um 
 * @author  Samuel Lucas de Moura Ferino
 *          José Wellinton
 */
public abstract class UsuarioDAOArquivo implements UsuarioDAO{
//    private final UsuarioDAOArquivo clienteDAO;    
//    private final UsuarioDAOArquivo OperadorDAO;
//    private final UsuarioDAOArquivo AdministradorDAO;
    
//    public UsuarioDAOArquivo(){
//        this.clienteDAO = new ClienteDAOArquivo();
//        this.OperadorDAO = new OperadorDAOArquivo();
//        this.AdministradorDAO = new AdministradorDAOArquivo();
//    
//    }
    
    //protected abstract void transformaStringEmHashMap(String conteudoArquivo );    
     
    //protected abstract String autenticar( String login, String senha);
    
    protected abstract void lerArquivo(String nomeDoArquivo) throws ServicoException;
    
    protected abstract boolean salvarArquivo(String nomeArquivo) throws ServicoException;
    
}
