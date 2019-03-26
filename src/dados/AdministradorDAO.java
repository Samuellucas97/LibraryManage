/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Administrador;

/**
 *
 * @author SamDan
 */
public interface AdministradorDAO {
    public void salvar(Administrador administrador) throws ServicoException;

}
