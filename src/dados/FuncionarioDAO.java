/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Funcionario;

/**
 *
 * @author SamDan
 */
public interface FuncionarioDAO {
    public void salvar(Funcionario funcionario) throws ServicoException;   
}
