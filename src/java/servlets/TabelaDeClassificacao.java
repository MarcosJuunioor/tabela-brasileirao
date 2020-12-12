/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Modelos.Time;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcosantonio
 */
public class TabelaDeClassificacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String timeMandante = request.getParameter("time_mandante");
            String timeVisitante = request.getParameter("time_visitante");
            int golsTimeMandante = Integer.parseInt(request.getParameter("gols_time_mandante"));
            int golsTimeVisitante = Integer.parseInt(request.getParameter("gols_time_visitante"));
            byte[] iso = timeMandante.getBytes("ISO-8859-1");
            timeMandante = new String(iso, "UTF-8");
            iso = timeVisitante.getBytes("ISO-8859-1");
            timeVisitante = new String(iso, "UTF-8");
            
            ServletContext sc = request.getServletContext();
            ArrayList<Time> timesTabela = (ArrayList<Time>) sc.getAttribute("timesTabela");       
            
             if(timesTabela == null){
                 ArrayList<Time> timesTabelaAux = new ArrayList();
                 Enumeration<String> times = (Enumeration<String>)sc.getInitParameterNames();
                 
                 while(times.hasMoreElements()){
                    String nomeClube = times.nextElement();
                    Time time = new Time(nomeClube);
                    if(nomeClube.equals(timeMandante)){
                        time.disputar(golsTimeMandante, golsTimeVisitante); //recebe gols pro e contra, nesta ordem       
                    }else if(nomeClube.equals(timeVisitante)){
                        time.disputar(golsTimeVisitante, golsTimeMandante);
                    }
                    timesTabelaAux.add(time);
                 }
                 bubbleSortTimes(timesTabelaAux);
                 sc.setAttribute("timesTabela", timesTabelaAux);
             }else{
                 for(Time time: timesTabela){
                     if(time.getNomeDoClube().equals(timeMandante)){
                        time.disputar(golsTimeMandante, golsTimeVisitante); 
                     }else if(time.getNomeDoClube().equals(timeVisitante)){
                        time.disputar(golsTimeVisitante, golsTimeMandante);
                    }
                 }
                 bubbleSortTimes(timesTabela);
             }
             
            //RequestDispatcher view = request.getRequestDispatcher("tabela.jsp");
            //view.forward(request, response);
            response.sendRedirect("tabela.jsp");
    }
    
    public void bubbleSortTimes(ArrayList<Time> times){
        boolean ordenado = false;
        
        while(!ordenado){
            ordenado = true;
            for(int i=0; i<times.size()-1; i++){
                Time t1 = times.get(i);
                Time t2 = times.get(i+1);
                
                if(t1.getTotalDePontos() < t2.getTotalDePontos() || ((t1.getTotalDePontos() == t2.getTotalDePontos()) && (t1.getSaldoDeGols() < t2.getSaldoDeGols()))){          
                    times.remove(i);
                    times.add(i, t2);
                    times.remove(i+1);
                    times.add(i+1, t1);
                    ordenado = false;
                }
            }
        }
        
        
        
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
