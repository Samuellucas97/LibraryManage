/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public abstract class FuncionarioDAOArquivo extends UsuarioDAOArquivo{
    
    private static OperadorDAOArquivo operadorDAOArquivo;
    private static AdministradorDAOArquivo administradorDAOArquivo;
    
    protected static AdministradorDAOArquivo getAdministradorDAOArquivo() throws ServicoException{
               
        if(FuncionarioDAOArquivo.administradorDAOArquivo == null)
            FuncionarioDAOArquivo.administradorDAOArquivo = (AdministradorDAOArquivo) 
                    UsuarioDAOFactory.getUsuarioDAO("AdministradorDAOArquivo");
        
        
        return FuncionarioDAOArquivo.administradorDAOArquivo;
        
    }
    
    protected static OperadorDAOArquivo getOperadorDAOArquivo() throws ServicoException{
        
        if(FuncionarioDAOArquivo.operadorDAOArquivo == null)
            FuncionarioDAOArquivo.operadorDAOArquivo = (OperadorDAOArquivo) 
                    UsuarioDAOFactory.getUsuarioDAO("OperadorDAOArquivo");
        
                
        return FuncionarioDAOArquivo.operadorDAOArquivo;  
    }
}
