/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Cliente;

/**
 *
 * @author Default
 */
public class ClienteDAO {

    public boolean inserir_Cliente(Cliente objCliente) {

        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();

            if (objCliente.getNome().isEmpty()) {
                return true;
            } else if (objCliente.getEndereco().isEmpty()) {
                return true;
            } else if (objCliente.getNumero().isEmpty()) {
                return true;
            } else if (objCliente.getBairro().isEmpty()) {
                return true;
            } else if (objCliente.getCpf().isEmpty()) {
                return true;
            } else if (objCliente.getTelefone().isEmpty()) {
                return true;
            } else if (objCliente.getCelular().isEmpty()) {
                return true;
            } else if (objCliente.getCep().isEmpty()) {
                return true;
            }

            //inserindo novos clientes para o banco;
            String sql = "INSERT INTO `cliente` (`nome`, `endereco`, `bairro`, `cpf_cnpj`, `numero`, `celular`, `telefone`, `cep`)";

            sql += " VALUES(";
            sql += "'" + objCliente.getNome() + "', "; //varchar 
            sql += "'" + objCliente.getEndereco() + "', "; //varchar                      
            sql += "'" + objCliente.getBairro() + "', "; //varchar
            sql += "'" + objCliente.getCpf() + "', "; //varchar
            sql += "'" + objCliente.getNumero() + "', "; //varchar
            sql += "'" + objCliente.getCelular() + "', "; //varchar
            sql += "'" + objCliente.getTelefone() + "', "; //varchar
            sql += "'" + objCliente.getCep() + "' "; //varchar
            sql += " );";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Cliente> getListarClientes() {
        // conectar o banco atravez da classe conexao
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        //select na tabela produtos
        String sql = "SELECT * FROM cliente;";
        List<Cliente> listCliente = new ArrayList<Cliente>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            preencherResultado(resultado, listCliente);
        } catch (SQLException ex) {

        }
        return listCliente;
    }

    public List<Cliente> pesquisaCliente(String nome) {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();

        List<Cliente> listCliente = new ArrayList<Cliente>();

        try {
            String sql = ("SELECT * FROM cliente WHERE nome LIKE ?");
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            ResultSet resultado = comando.executeQuery();
            preencherResultado(resultado, listCliente);
        } catch (SQLException ex) {

        }
        return listCliente;
    }

    public void preencherResultado(ResultSet resultado, List<Cliente> listCliente) throws SQLException {
        while (resultado.next()) {
            Cliente objCliente = new Cliente();
            objCliente.setNome(resultado.getString("nome"));
            objCliente.setEndereco(resultado.getString("endereco"));
            objCliente.setNumero(resultado.getString("numero"));
            objCliente.setBairro(resultado.getString("bairro"));
            objCliente.setCpf(resultado.getString("cpf_cnpj"));
            objCliente.setTelefone(resultado.getString("telefone"));
            objCliente.setCelular(resultado.getString("celular"));
            objCliente.setCep(resultado.getString("cep"));

            //insira produto na lista local
            listCliente.add(objCliente);
        }
    }

    public boolean deleteCliente(String cpf) {
        String sql = "DELETE FROM `cliente` WHERE cpf_cnpj = ?";
        Conexao conn = new Conexao();

        try {
            Connection conexao = conn.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
