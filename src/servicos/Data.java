/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 * Representa uma data temporal
 * @author Samuel Lucas de Moura Ferino
 */
public class Data {
    
    private String dia;
    private String mes;
    private String ano;
    private String data; /// USADO APENAS INTERNAMENTE
    
    /**
     * Construtor da classe Data
     * @param data  Data em formato de string a ser armazenada
     * @throws ServicoException 
     */
    Data(String data) throws ServicoException{
    
        String diaTemporario = data.split("/")[0];
        String mesTemporario = data.split("/")[1];
        String anoTemporario = data.split("/")[2];
        
        if( diaTemporario.length() != 2
            ||    Integer.parseInt( diaTemporario ) < 1 
            || ( Integer.parseInt( diaTemporario ) > 31  && (  Integer.parseInt( mesTemporario ) == 1  || 
                                                            Integer.parseInt( mesTemporario ) == 3  || Integer.parseInt( mesTemporario ) == 5 || 
                                                            Integer.parseInt( mesTemporario ) == 7  || Integer.parseInt( mesTemporario ) == 8 ||
                                                            Integer.parseInt( mesTemporario ) == 10 || Integer.parseInt( mesTemporario ) == 12  ) 
    
            || ( Integer.parseInt( diaTemporario ) > 30  && (  Integer.parseInt( mesTemporario ) == 4  || Integer.parseInt( mesTemporario ) == 6 || 
                                                            Integer.parseInt( mesTemporario ) == 9  || Integer.parseInt( mesTemporario ) == 11 ) )
               
            || ( Integer.parseInt( diaTemporario ) > 28  && (  Integer.parseInt( mesTemporario ) == 2 )    )
            
            )  
           )
            throw new ServicoException("Dia invalido");
                    
        if( mesTemporario.length() != 2 || 
            Integer.parseInt(mesTemporario) < 1 || 
            Integer.parseInt(mesTemporario) > 12 )
            throw new ServicoException("Mes invalido");
        
        if( anoTemporario.length() != 4  ||
            Integer.parseInt(anoTemporario) < 1920 ||
            Integer.parseInt(anoTemporario) > 2050 )
            throw new ServicoException("Ano invalido");
            
        this.dia = diaTemporario;
        this.mes = mesTemporario;
        this.ano = anoTemporario;
        this.data = data;
    }
    
    public String getDia() {
        return this.dia;
    }

    public String getMes() {
        return this.mes;
    }

    public String getAno() {
        return this.ano;
    }
    
    /**
     * Envia a string que contém a data
     * @return  A data em formato de string
     */
    public String toString(){
        return data;
    }
}
