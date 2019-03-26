/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;

/**
 *
 * @author SamDan
 */
public class AdministradorServico extends FuncionarioServico{
    
    public AdministradorServico(){
        super();
    }
    public void excluirLivro() throws ServicoException{}
    public void consultarFuncionario() throws ServicoException{}
    public void alterarFuncionario() throws ServicoException{}
    public void registrarFuncionario() throws ServicoException{}
    public void excluirUsuario() throws ServicoException{}
    public void bloqueioPermanenteDeFuncionario() throws ServicoException{}
    public void bloqueioTemporarioDeFuncionario() throws ServicoException{}
    
}
