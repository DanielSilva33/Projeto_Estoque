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
import negocio.Produtos;

/**
 *
 * @author Internet
 */
public class ProdutosDAO {

    public List<Produtos> getListarProdutos() {
        // conectar o banco atravez da classe conexao
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        //select na tabela produtos
        String sql = "SELECT * FROM produto;";
        List<Produtos> listProdutos = new ArrayList<Produtos>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            preencherResultado(resultado, listProdutos);
        } catch (SQLException ex) {

        }
        return listProdutos;
    }

    public void preencherResultado(ResultSet resultado, List<Produtos> listProdutos) throws SQLException {
        while (resultado.next()) {
            Produtos objProduto = new Produtos();
            objProduto.setNome(resultado.getString("nome_produto"));
            objProduto.setCodigo(resultado.getInt("codigo_produto"));
            objProduto.setQuantidade(resultado.getInt("quantidade_produto"));
            objProduto.setValor(resultado.getString("valor_produto"));

            //insira produto na lista local
            listProdutos.add(objProduto);
        }
    }

    public List<Produtos> pesquisaProdutos(String nome) {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();

        List<Produtos> listProdutos = new ArrayList<Produtos>();

        try {
            String sql = ("SELECT * FROM produto WHERE nome_produto LIKE ?");
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            ResultSet resultado = comando.executeQuery();
            preencherResultado(resultado, listProdutos);
        } catch (SQLException ex) {

        }
        return listProdutos;
    }

    public boolean inserirProduto(Produtos objProdutos) {
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();

            if (objProdutos.getNome().isEmpty()) {
                return true;
            } else if (Integer.toString(objProdutos.getCodigo()).isEmpty()) {
                return true;
            } else if (Integer.toString(objProdutos.getQuantidade()).isEmpty()) {
                return true;
            } else if (objProdutos.getValor().isEmpty()) {
                return true;
            }

            //inserindo novos produtos para o banco;
            String sql = "INSERT INTO `produto` (`nome_produto`, `codigo_produto`, `quantidade_produto`, `valor_produto`)";

            sql += " VALUES(";
            sql += "'" + objProdutos.getNome() + "',"; //varchar 
            sql += "'" + objProdutos.getCodigo() + "',"; //inteiro                      
            sql += "'" + objProdutos.getQuantidade() + "',"; //inteiro
            sql += "'" + objProdutos.getValor() + "'"; //decimal
            sql += " );";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean movimento(String quantidade, String codigo) {
        String sql = "UPDATE `produto` SET `quantidade_produto` = ? WHERE `produto`.`codigo_produto` = ?";
        Conexao conn = new Conexao();

        try {
            Connection conexao = conn.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, codigo);
            comando.setString(2, quantidade);
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
