/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Cliente;

/**
 *
 * @author SamDan
 */
public interface ClienteDAO {
    public Cliente buscarCliente(String loginCliente)  throws ServicoException;
    public void salvar(Cliente cliente) throws ServicoException;

    public void bloqueioPermanenteDeCliente(Cliente cliente);

    public void bloqueioTemporarioDeCliente(Cliente cliente);
}
