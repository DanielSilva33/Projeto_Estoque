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

/**
 *
 * @author Internet
 */
public class UsuarioDAO {

    public boolean checklogin(String login, String senha) {

        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();

        //select na tabela carro
        String sql = "SELECT * FROM administrador where usuario = ? and senha = ?";

        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            return resultado.next();
        } catch (SQLException ex) {
            return false;
        }
    }

}
