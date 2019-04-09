/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.util.HashMap;


/**
 *
 * @author SamDan
 */
public class UsuarioServicoFactory {
    private static final HashMap<String, IUsuarioServico> mapUsuariosServico = new HashMap();
    
    public static IUsuarioServico getUsuarioDAO(String nome){
       IUsuarioServico usuarioServico = UsuarioServicoFactory.mapUsuariosServico.get(nome);
        
        if(usuarioServico == null){
            if(nome.equals("ClienteServico") ){
               UsuarioServicoFactory.mapUsuariosServico.put( "ClienteServico",  new ClienteServico()  );
            }
            if(nome.equals("OperadorServico")){
               UsuarioServicoFactory.mapUsuariosServico.put( "OperadorServico", new OperadorServico() );
            }
            if(nome.equals("AdministradorServico")){
               UsuarioServicoFactory.mapUsuariosServico.put( "AdministradorServico", new AdministradorServico() );
            }
            /// É necessário adicionar mais ifs a cada nova classe DAO criada 
        }
        
        return UsuarioServicoFactory.mapUsuariosServico.get(nome);
    }
}
