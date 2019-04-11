/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton Nunes Júnior
 */
public class Funcionario extends Usuario{
    
    private HashMap<String, ArrayList<Boolean> > hMapRankingUsuario =  new HashMap<>();
    
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

    public void setSalario(float salario) throws ServicoException {
        if(salario < 0) throw new ServicoException("Valor do salario inválido!");
        this.salario = salario;
    }
    
    public void setHMapRankingUsuario(HashMap<String, ArrayList<Boolean> > hMapRankingUsuario){
        this.hMapRankingUsuario = hMapRankingUsuario;
    }
    
    public HashMap<String, ArrayList<Boolean> > getHMapRankingUsuario(){
        return this.hMapRankingUsuario;
    }
    
}
