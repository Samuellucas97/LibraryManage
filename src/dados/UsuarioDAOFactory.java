/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.HashMap;


public class UsuarioDAOFactory {
    private static final HashMap<String,UsuarioDAO> mapUsuarios = new HashMap();
    
    public static UsuarioDAO getUsuarioDAO(String nome){
       UsuarioDAO usuarioDAO = UsuarioDAOFactory.mapUsuarios.get(nome);
        
        if(usuarioDAO == null){
            if(nome.equals("ClienteDAOArquivo") ){
               UsuarioDAOFactory.mapUsuarios.put("ClienteDAOArquivo", (new ClienteDAOArquivo()));
            }
            if(nome.equals("OperadorDAOArquivo")){
               UsuarioDAOFactory.mapUsuarios.put("OperadorDAOArquivo", (new OperadorDAOArquivo()));
            }
            if(nome.equals("AdministradorDAOArquivo")){
               UsuarioDAOFactory.mapUsuarios.put("AdministradorDAOArquivo", (new AdministradorDAOArquivo()));
            }
            //adicionar mais a cada nova classe DAO criada 
        }
            
        return UsuarioDAOFactory.mapUsuarios.get(nome);
    }
}
