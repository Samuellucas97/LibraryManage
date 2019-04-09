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
 * @author SamDante
 */
public class Funcionario extends Usuario{
    
    private HashMap<String, ArrayList<Boolean> > hMapRankingUsuario =  new HashMap<String, ArrayList<Boolean> >();
    
    private float salario;

    public Funcionario( ){
    
        super();
        
        this.salario =  0;
    
    }
    
    public Funcionario( String login, String senha){
    
        super(login, senha);
        
        this.salario =  0;
    
    }
   
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
