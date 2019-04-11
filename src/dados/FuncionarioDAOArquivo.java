/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.List;
import servicos.Cliente;
import servicos.Livro;
import servicos.Usuario;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public abstract class FuncionarioDAOArquivo extends UsuarioDAOArquivo{
    
    private static OperadorDAOArquivo operadorDAOArquivo;
    private static AdministradorDAOArquivo administradorDAOArquivo;
    private static ClienteDAOArquivo clienteDAOArquivo;
    private static LivroDAOArquivo livroDAOArquivo;
    
    protected static AdministradorDAOArquivo getAdministradorDAOArquivo() throws ServicoException{
               
        if(FuncionarioDAOArquivo.administradorDAOArquivo == null)
            FuncionarioDAOArquivo.administradorDAOArquivo = (AdministradorDAOArquivo) 
                    UsuarioDAOFactory.getIUsuarioDAO("AdministradorDAOArquivo");        
        
        return FuncionarioDAOArquivo.administradorDAOArquivo;        
    }
    
    protected static OperadorDAOArquivo getOperadorDAOArquivo() throws ServicoException{
        
        if(FuncionarioDAOArquivo.operadorDAOArquivo == null)
            FuncionarioDAOArquivo.operadorDAOArquivo = (OperadorDAOArquivo) 
                    UsuarioDAOFactory.getIUsuarioDAO("OperadorDAOArquivo");        
                
        return FuncionarioDAOArquivo.operadorDAOArquivo;  
    }

    protected static ClienteDAOArquivo getClienteDAOArquivo() throws ServicoException{
        
        if(FuncionarioDAOArquivo.clienteDAOArquivo == null)
            FuncionarioDAOArquivo.clienteDAOArquivo = (ClienteDAOArquivo) 
                    UsuarioDAOFactory.getIUsuarioDAO("ClienteDAOArquivo");        
                
        return FuncionarioDAOArquivo.clienteDAOArquivo;  
    }
    
    protected static LivroDAOArquivo getLivroDAOArquivo() throws ServicoException{
        
        if(FuncionarioDAOArquivo.livroDAOArquivo == null)
            FuncionarioDAOArquivo.livroDAOArquivo = (LivroDAOArquivo) LivroDAOArquivo.getInstancia();        
                
        return FuncionarioDAOArquivo.livroDAOArquivo;  
    }
    
    public Livro consultaLivro(String idLivro) throws ServicoException{
        return FuncionarioDAOArquivo.getLivroDAOArquivo().consultaLivro(idLivro);
    }
       
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException{
        return FuncionarioDAOArquivo.getLivroDAOArquivo().consultaLivros(params, keys);
    }
    
    public List<Livro> consultaLivros(String param, String key) throws ServicoException{
        return FuncionarioDAOArquivo.getLivroDAOArquivo().consultaLivros(param, key);
    }
        
    public void adicionarQuantidadeLivro(String idLivro, int quantidade) throws ServicoException{
        FuncionarioDAOArquivo.getLivroDAOArquivo().adicionarQuantidadeLivro(idLivro, quantidade);
    }
       
    public void removerQuantidadeLivro(String idLivro, int quantidade) throws ServicoException{
       FuncionarioDAOArquivo.getLivroDAOArquivo().removerQuantidadeLivro(idLivro, quantidade);        
    }
        
    public void registrarLivro(Livro livro) throws ServicoException {
        FuncionarioDAOArquivo.getLivroDAOArquivo().registrarLivro(livro);
    }
    
    public void alterarLivro(String IDlivro, Livro livroAlterado) throws ServicoException{
        FuncionarioDAOArquivo.getLivroDAOArquivo().alterarLivro(IDlivro, livroAlterado);
    }
    
    public Cliente consultarCliente(String login) throws ServicoException {
        return (Cliente) FuncionarioDAOArquivo.getClienteDAOArquivo().consultar(login);
    }

    public List<Usuario> consultaClientes(List<String> params, List<String> keys) throws ServicoException {
        return FuncionarioDAOArquivo.getClienteDAOArquivo().consultaUsuarios(params, keys);
    }
    
    public List<Usuario> consultaClientes(String param, String key) throws ServicoException {
        return FuncionarioDAOArquivo.getClienteDAOArquivo().consultaUsuarios(param, key);
    }
        
    public void registrarCliente(Usuario usuario) throws ServicoException {
        FuncionarioDAOArquivo.getClienteDAOArquivo().registrar(usuario);
    }
   
    public void alterarCliente(String usuarioLogin, Usuario usuarioAlterado) throws ServicoException {
         FuncionarioDAOArquivo.getClienteDAOArquivo().alterar(usuarioLogin, usuarioAlterado);
    }
    
}
