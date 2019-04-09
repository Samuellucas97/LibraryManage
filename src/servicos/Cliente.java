/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
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
    private ArrayList<Pair<String,String> > listaId_e_DataDeEmprestimoLivros = new ArrayList<  >();
    private ArrayList<Boolean> ranking = new ArrayList<>();
    private HashMap<String, ArrayList<Boolean> > hMapRankingLivros = new HashMap< >(); 
    private ArrayList<Livro> livrosAlugados = new ArrayList<>();
            
    public Cliente( String login, String senha){
        
        super(login, senha);
        
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

    public int getRankingInt(){
        int cont = 0;
        for(boolean nivel : this.getRanking()){
            if(nivel) cont++;
            else break;
        }
        return cont;
    }
    
    public void setRanking( ArrayList<Boolean> ranking ){
        this.ranking.clear();
        this.ranking = ranking;
    }
    
    public void setRankingInt( int valor) throws ServicoException{
        if(valor >= 0 && valor <=5){
            this.ranking.set(0, false);
            this.ranking.set(1, false);
            this.ranking.set(2, false);
            this.ranking.set(3, false);
            this.ranking.set(4, false);
            for(int i = 0; i < valor; i++){
                this.ranking.set(i, true);
            }
        }
        else throw new ServicoException("Valor do ranking inválido!");
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
    
    
    public ArrayList<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(ArrayList<Livro> livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }
    
}
