/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import negocio.Produtos;
import negocio.Usuario;

/**
 *
 * @author internet
 */
public class Principal {

    public static void main(String[] args) {
        Conexao objConexao = new Conexao();
        Connection conn = objConexao.getConexao();//chamando o método conectar
        System.out.println(objConexao.getStatusConexao());
        

    }

}
