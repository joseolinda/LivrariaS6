/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.livraria.e.papelaria;

import java.sql.SQLException;
import model.dao.ProdutoDAO;
import views.PaginaInicial;

/**
 *
 * @author Mithiely
 */
public class SistemaLivrariaEPapelaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
         new PaginaInicial().setVisible(true);
//        Produto p = new Produto();
//        ProdutoDAO dao = new ProdutoDAO();
//        p.setId("1");
//        p.setPreço_da_compra((float) Double.parseDouble("20"));
//        p.setMarca("Dell");
//        p.setSetor("Informática");
//        p.setQuantidade_em_estoque(Integer.parseInt("10"));
//        dao.create(p);
//        
    }
    
}
