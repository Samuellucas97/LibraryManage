/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.HashMap;


public class UsuarioDAOFactory {
    private static final HashMap<String,UsuarioDAO> hMapUsuarios = new HashMap();
    
    public static UsuarioDAO getUsuarioDAO(String nome) throws ServicoException{
       UsuarioDAO usuarioDAO = UsuarioDAOFactory.hMapUsuarios.get(nome);
        
        if(usuarioDAO == null){
            if(nome.equals("ClienteDAOArquivo") ){
               UsuarioDAOFactory.hMapUsuarios.put("ClienteDAOArquivo", (new ClienteDAOArquivo()));
            }
            if(nome.equals("OperadorDAOArquivo")){
               UsuarioDAOFactory.hMapUsuarios.put("OperadorDAOArquivo", (new OperadorDAOArquivo()));
            }
            if(nome.equals("AdministradorDAOArquivo")){
               UsuarioDAOFactory.hMapUsuarios.put("AdministradorDAOArquivo", (new AdministradorDAOArquivo()));
            }
            //adicionar mais a cada nova classe DAO criada 
        }
            
        return UsuarioDAOFactory.hMapUsuarios.get(nome);
    }
}
