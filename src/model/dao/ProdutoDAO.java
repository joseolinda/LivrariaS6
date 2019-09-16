package model.dao;

import Conexão.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.livraria.e.papelaria.Produto;

/**
 *
 * @author anakl
 */
public class ProdutoDAO {

    public void create(Produto p) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // stmt = (PreparedStatement) con.prepareStatement("INSERT INTO produto(id, preço_da_compra, marca, quantidade, setor, nome) VALUES (?, ?, ?, ?, ?, ?)");
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO produto(codproduto, valor, marca, quantidade, setor) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, p.getId());
            stmt.setDouble(2, p.getPreço_da_compra());
            stmt.setString(3, p.getMarca());
            stmt.setInt(4, p.getQuantidade_em_estoque());
            stmt.setString(5, p.getSetor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Produto> read() throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getString("id"));
                produto.setPreço_da_compra(rs.getFloat("preço"));
                produto.setQuantidade_em_estoque(rs.getInt("quantidade"));
                produto.setMarca(rs.getString("Marca"));
                produto.setSetor(rs.getString("Setor"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public List<Produto> readForDesc(String desc) throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        java.sql.PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getString("id"));
                produto.setPreço_da_compra(rs.getFloat("Preço"));
                produto.setMarca(rs.getString("Marca"));
                produto.setQuantidade_em_estoque(rs.getInt("Quantidade em estoque"));
                produto.setSetor(rs.getString("Setor"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Produto p) throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        java.sql.PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET descricao = ? ,qtd = ?,preco = ? WHERE id = ?");
            stmt.setString(1, p.getId());
            stmt.setDouble(2, p.getPreço_da_compra());
            stmt.setString(3, p.getMarca());
            stmt.setInt(4, p.getQuantidade_em_estoque());
            stmt.setString(5, p.getSetor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Produto p) throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        java.sql.PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setString(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
