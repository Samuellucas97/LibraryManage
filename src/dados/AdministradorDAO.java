/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import servicos.Administrador;
import servicos.Funcionario;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public interface AdministradorDAO {
    public void salvar(Administrador administrador) throws ServicoException;

    public Funcionario consultarFuncionario(String nome);

    public void registrarFuncionario(Funcionario funcionario);

    public void excluirUsuario(Usuario usuario);

    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario);

    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario);

}
