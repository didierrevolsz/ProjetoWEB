
package br.com.gwsistemas.transportadora.dao;

import br.com.gwsistemas.transportadora.models.Transportadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import br.com.gwsistemas.transportadora.dao.ConnectionFactory;

public class TransportadoraDAO {
    
    //private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Transportadora> lista = new ArrayList<Transportadora>();
    
    
    // CRIAR UMA VARIAVEL E PASSA-LA COMO PARAMETRO PARA O CONTRUITUR, EM SEGUIDA PASSA NO BO
    private Connection con = null;
    
    public TransportadoraDAO(Connection conexao) {
       con = conexao;

    } 
    
    
    // Criando a assinatura do metodo inserir
    public void inserir(Transportadora transportadora) throws FileNotFoundException {
        String sql = "INSERT INTO transportadora_tb (email_transportadora, nome_transportadora, empresa_transportadora, telefone_transportadora, "
                + "celular_transportadora, whatsapp_transportadora, "
                + "modal_transportadora, cep, uf, cidade, bairro, rua) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
            
        try {
            
            
//          stmt = getCon().prepareStatement(sql);
            System.out.println("iniciando o getcon");
//             getCon().prepareStatement(sql);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, transportadora.getEmail());
            stmt.setString(2, transportadora.getNome());
            stmt.setString(3, transportadora.getEmpresa());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getCelular());
            stmt.setString(6, transportadora.getWhatsapp());
            stmt.setString(7, transportadora.getModal());
//            // Dispensei boa pratica de programaçaõ pos irei pesquisar como consumir API Correios
            stmt.setString(8, transportadora.getCep());
            stmt.setString(9, transportadora.getUf());
            stmt.setString(10, transportadora.getCidade());
            stmt.setString(11, transportadora.getBairro());
            stmt.setString(12, transportadora.getRua());
            
            // DAO FUNCIONANDO ATE AQUI.
            
//            stmt.setString(13, transportadora.getNumero());
//            FileInputStream fis = new FileInputStream(transportadora.getLogo());
//            stmt.setBinaryStream(14, fis, (int) transportadora.getLogo().length());
            System.out.println("SQL EXECUTE:"+stmt);
//            System.out.println("iniciou o getcon");
            stmt.executeQuery();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir dados na tabela Transportadora" + erro);
        }

    }
    
    
        // Assinatura do metodo ALTERAR
    public void alterar(Transportadora transportadora) throws FileNotFoundException {

        String sql = "UPDATE transportadora_tb SET "
                + "email= ?, nome= ?, empresa = ?,"
                + "telefone= ? , celular= ?, whatsapp = ?, modal= ?"
                + "cep =?, uf = ?, cidade =?, bairro =?, rua = ?, numero= ?, logo= ? "
                + "WHERE id= ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, transportadora.getEmail());
            stmt.setString(2, transportadora.getNome());
            stmt.setString(3, transportadora.getEmpresa());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getCelular());
            stmt.setString(6, transportadora.getWhatsapp());
            stmt.setString(7, transportadora.getModal());
            // Dispensei boa pratica de programaçaõ pos irei pesquisar como consumir API Correios
            stmt.setString(8, transportadora.getCep());
            stmt.setString(9, transportadora.getUf());
            stmt.setString(10, transportadora.getCidade());
            stmt.setString(11, transportadora.getBairro());
            stmt.setString(12, transportadora.getRua());
            stmt.setString(13, transportadora.getNumero());

            // IMAGEM
            FileInputStream fis = new FileInputStream(transportadora.getLogo());
            stmt.setBinaryStream(14, fis, (int) transportadora.getLogo().length());

            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao alterar dados na tabela Transportadora" + erro);
        }
    }

    
        // Asinatura do metodo DELETAR
    public void excluir(int valor) {
        String sql = "DELETE FROM transportadora_tb "
                + "WHERE id=" + valor;

        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao deletar dados na tabela transportadora");
       }
    }
    
    // Assinatura do metodo lISTAGEM 

    public ArrayList<Transportadora> Listartodos() throws FileNotFoundException {
        String sql = "SELECT * "
                + "FROM transportadora_tb";

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();

                transportadora.setId(rs.getInt("id"));
                transportadora.setEmail(rs.getString("email"));
                transportadora.setNome(rs.getString("nome"));
                transportadora.setEmpresa(rs.getString("empresa"));
                transportadora.setTelefone(rs.getString("telefone"));
                transportadora.setCelular(rs.getString("celular"));
                transportadora.setWhatsapp(rs.getString("whatsapp"));
                transportadora.setModal(rs.getString("modal"));
                transportadora.setCep(rs.getString("cep"));
                transportadora.setUf(rs.getString("uf"));
                transportadora.setCidade(rs.getString("cidade"));
                transportadora.setBairro(rs.getString("bairro"));
                transportadora.setRua(rs.getString("rua"));
                transportadora.setNumero(rs.getString("numero"));

                //Imagem - estudar como adicionar
                //transportadora.setLogo(rs.getBinaryStream("logo_transportadora"));
                lista.add(transportadora);
            }

        } catch (SQLException erro) {
            throw new RuntimeException("Erro na listagem de transportadora" + erro);
        }
        return lista;
    }
    
    
      // FILTRO 
    public ArrayList<Transportadora> ListatodosDescricao(String valor) {
        String sql = "SELECT * FROM transportadora_tb"
                + "WHERE nome LIKE '%" + valor + "%', "
                + "uf LIKE '%" + valor + "%',"
                + "cidade LIKE '%" + valor + "%',"
                + "modal LIKE '%" + valor + "%'";

        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();

                transportadora.setId(rs.getInt("id"));
                transportadora.setEmail(rs.getString("email"));
                transportadora.setNome(rs.getString("nome"));
                transportadora.setEmpresa(rs.getString("empresa"));
                transportadora.setTelefone(rs.getString("telefone"));
                transportadora.setCelular(rs.getString("celular"));
                transportadora.setWhatsapp(rs.getString("whatsapp"));
                transportadora.setModal(rs.getString("modal"));
                transportadora.setCep(rs.getString("cep"));
                transportadora.setUf(rs.getString("uf"));
                transportadora.setCidade(rs.getString("cidade"));
                transportadora.setBairro(rs.getString("bairro"));
                transportadora.setRua(rs.getString("rua"));
                transportadora.setNumero(rs.getString("numero"));

                //Imagem - estudar como adicionar
                //transportadora.setLogo(rs.getBinaryStream("logo_transportadora"));
                lista.add(transportadora);
            }

        } catch (SQLException erro) {
            throw new RuntimeException("Erro na descrição da listagem de transportadora" + erro);
        }

        return lista;
    }
    
        
    //Pegar pelo ID
    public Transportadora getTransportadoraById(int id) {

            Transportadora transportadora = new Transportadora();
            String sql = "select * from transportadora_tb where id=?";

            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
           

                    transportadora.setId(rs.getInt("id"));
                    transportadora.setEmail(rs.getString("email"));
                    transportadora.setNome(rs.getString("nome"));
                    transportadora.setEmpresa(rs.getString("empresa"));
                    transportadora.setTelefone(rs.getString("telefone"));
                    transportadora.setCelular(rs.getString("celular"));
                    transportadora.setWhatsapp(rs.getString("whatsapp"));
                    transportadora.setModal(rs.getString("modal"));
                    transportadora.setCep(rs.getString("cep"));
                    transportadora.setUf(rs.getString("uf"));
                    transportadora.setCidade(rs.getString("cidade"));
                    transportadora.setBairro(rs.getString("bairro"));
                    transportadora.setRua(rs.getString("rua"));
                    transportadora.setNumero(rs.getString("numero"));

                }

            } catch (SQLException erro) {
                throw new RuntimeException("Erro na descrição da listagem de transportadora" + erro);
            }

            return transportadora;
        }

    public Connection getCon() {
        return con;
    }
    
    
    
    
}
