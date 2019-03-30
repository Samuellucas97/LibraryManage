/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;


/**
 *
 * @author SamDan
 */
public class Cliente extends Usuario{
    
    
    private int numeroEmprestimos = 0;
    private int numeroDevolucoes = 0;
    private ArrayList<Pair<String,String> > listaId_e_DataDeEmprestimoLivros = new ArrayList< Pair<String, String> >();
    private ArrayList<Boolean> ranking;
    private HashMap<String, ArrayList<Boolean> > hMapRankingLivros = new HashMap<String, ArrayList<Boolean> >(); 
    
    public Cliente( String login, String senha){
        
        super(login, senha);
        
        this.ranking = new ArrayList<Boolean>();
        
        ranking.add(false); 
        ranking.add(false);
        ranking.add(false);
        ranking.add(false);
        ranking.add(false);
    
    }

    public Cliente() {
        
        super();
        
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
        return this.numeroEmprestimos;
    }

    public void setNumeroEmprestimos(int numeroEmprestimos) {
        this.numeroEmprestimos = numeroEmprestimos;
    }

    public int getNumeroDevolucoes() {
        return this.numeroDevolucoes;
    }

    public void setNumeroDevolucoes(int numeroDevolucoes) {
        this.numeroDevolucoes = numeroDevolucoes;
    }
    
}
