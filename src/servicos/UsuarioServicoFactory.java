/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.HashMap;


/**
 * Classe de criação das classes de manipulação de dados existentes na camada DAO
 * @author José Welliton Nunes Júnior
 */
public class UsuarioServicoFactory {
    private static final HashMap<String, IUsuarioServico> hMapUsuariosServico = new HashMap();
    
    public static IUsuarioServico getUsuarioServico(String nome) throws ServicoException{
       IUsuarioServico usuarioServico = UsuarioServicoFactory.hMapUsuariosServico.get(nome);
        
        if(usuarioServico == null){
            if(nome.equals("ClienteServico") ){
               UsuarioServicoFactory.hMapUsuariosServico.put( "ClienteServico",  new ClienteServico());
            }
            if(nome.equals("OperadorServico")){
               UsuarioServicoFactory.hMapUsuariosServico.put( "OperadorServico", new OperadorServico());
            }
            if(nome.equals("AdministradorServico")){
               UsuarioServicoFactory.hMapUsuariosServico.put( "AdministradorServico", new AdministradorServico() );
            }
            /// É necessário adicionar mais ifs a cada nova classe DAO criada 
        }
        
        return UsuarioServicoFactory.hMapUsuariosServico.get(nome);
    }
}
