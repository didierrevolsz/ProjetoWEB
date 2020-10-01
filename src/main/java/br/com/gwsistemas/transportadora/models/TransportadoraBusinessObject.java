package br.com.gwsistemas.transportadora.models;

import br.com.gwsistemas.transportadora.dao.ConnectionFactory;
import br.com.gwsistemas.transportadora.dao.TransportadoraDAO;
import java.sql.Connection;

public class TransportadoraBusinessObject {

    public void inserir(Transportadora transportadora) throws Exception {

        // Atualmente estou trabalhando com 4 campos - apos a execução e percepção que tudo esta ocorrendo normalmente,
        // Devo voltar para essa classe e tratar os outros atributos do objeto.
        if (transportadora.getEmail().equals("")) {
            throw new Exception("O campo Email não pode ficar em branco!");
        }
//     
//     
//        Connection con = ConnectionFactory.getConnection();
//        
//        System.out.println(con.getSchema());
//        System.out.println(con.isClosed());

// Abre iniciando com null
        Connection con = null;
        con = ConnectionFactory.getConnection();
         
        TransportadoraDAO dao = new TransportadoraDAO(con);

        dao.inserir(transportadora);

// Fecha conexão        
        con.close();

    }

    protected void alterar(Transportadora transportadora) throws Exception {

        if (transportadora.getEmail().equals("")) {
            throw new Exception("O campo Email não pode ficar em branco!");
        }
   
        
 // Abre conexão iniciando com null
        Connection con = null;

        TransportadoraDAO dao = new TransportadoraDAO(con);

        dao.inserir(transportadora);

// Fecha conexão        
        con.close();

    }

    protected void excluir(Transportadora transportadora) throws Exception {

    }

    protected void ListarTodos(Transportadora transportadora) throws Exception {

    }

}
