/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author SamDan
 */
public class Administrador extends Funcionario{

    private HashMap<String, ArrayList<Boolean> > hMapRankingUsuario =  new HashMap<String, ArrayList<Boolean> >();
    
    public Administrador(){
        super();
    }
    
    public Administrador(String login, String senha){
        super(login, senha);
    }
    
}
