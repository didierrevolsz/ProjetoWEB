package br.com.gwsistemas.transportadora.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import das classes model e DAO, respectivamente.
import br.com.gwsistemas.transportadora.dao.TransportadoraDAO;
import br.com.gwsistemas.transportadora.models.Transportadora;
import br.com.gwsistemas.transportadora.models.TransportadoraBusinessObject;
import java.io.PrintWriter;



//@WebServlet("/")
public class TransportadoraControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private TransportadoraBusinessObject bo = null;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String acao = request.getParameter("acao");
       // RequestDispatcher dispatcher = null;
        
        System.out.println("acao: "+acao);
        
        try{
        //Aqui eu irei por as ações de acordo com meu BO     
        // Como estou trabalho com codigo reduzido, irei fazer a parte do cadastro primeiro
        // Caso sucesso, trabalhar com os outros metodos.
        
        switch(acao){
            // Ação de cadastrar:
            case "inserir":
                //
            
            inserir(request, response);
            //dispatcher = request.getRequestDispatcher("listar.jsp");
            break;
            
            // Ação de Alterar:
            case "alterar":
            alterar(request, response);
           // dispatcher = request.getRequestDispatcher("listar.jsp");
            break;
            
            
            // Ação de Excluir:
            case "excluir":
            excluir(request, response);
           // dispatcher = request.getRequestDispatcher("listar.jsp");
            break;
            
            
            // Ação de Listar
            case "listar":
            ListarTodos(request, response);
          //  dispatcher = request.getRequestDispatcher("listar.jsp");
            break;
             default:
                    throw new AssertionError();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
//        catch (Exception e){
//          System.out.println(e.getMessage());
//        } 
//        finally {
//            dispatcher = null;
//        }    
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/cadastro.jsp");
//        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
         
         
         
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void inserir(HttpServletRequest request, HttpServletResponse response) throws Exception {
         bo = new TransportadoraBusinessObject();
                System.out.println("teste Metodo inserir controlador/BO passou aqui");
                Transportadora transportadora = new Transportadora();
                
                transportadora.setEmail(request.getParameter("email"));
                transportadora.setNome(request.getParameter("nome"));
                transportadora.setEmpresa(request.getParameter("empresa"));
                transportadora.setTelefone(request.getParameter("telefone"));
                transportadora.setCelular(request.getParameter("celular"));
                transportadora.setWhatsapp(request.getParameter("whatsapp"));
                transportadora.setModal(request.getParameter("modal"));
                
                // TESTE
                transportadora.setCep(request.getParameter("cep"));
                transportadora.setUf(request.getParameter("uf"));
                transportadora.setCidade(request.getParameter("cidade"));
                transportadora.setBairro(request.getParameter("bairro"));
                transportadora.setRua(request.getParameter("rua"));
                
                
                
                
                bo.inserir(transportadora);
    }

  private void alterar(HttpServletRequest request, HttpServletResponse response) throws Exception {
         bo = new TransportadoraBusinessObject();
  }
  
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
         bo = new TransportadoraBusinessObject();
  }
    
    
    private void ListarTodos(HttpServletRequest request, HttpServletResponse response) throws Exception {
         bo = new TransportadoraBusinessObject();
  }

}
