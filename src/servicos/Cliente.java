/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.util.ArrayList;


/**
 *
 * @author SamDan
 */
public class Cliente extends Usuario{
    
    private ArrayList<Boolean> ranking;
    private int numeroEmprestimos;
    private int numeroDevolucoes;

    public Cliente( String login, String senha){
        
        super(login, senha);
        
        this.ranking = new ArrayList<Boolean>();
        
        ranking.add(false); 
        ranking.add(false);
        ranking.add(false);
        ranking.add(false);
        ranking.add(false);
    
    }
    
    public ArrayList<Boolean> getRanking(){
        return this.ranking;
    }    
    
    public void setRanking( ArrayList<Boolean> ranking ){
        this.ranking.clear();
        this.ranking = ranking;
    }

    public int getNumeroEmprestimos() {
        return numeroEmprestimos;
    }

    public void setNumeroEmprestimos(int numeroEmprestimos) {
        this.numeroEmprestimos = numeroEmprestimos;
    }

    public int getNumeroDevolucoes() {
        return numeroDevolucoes;
    }

    public void setNumeroDevolucoes(int numeroDevolucoes) {
        this.numeroDevolucoes = numeroDevolucoes;
    }
    
}
