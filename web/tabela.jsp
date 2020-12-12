<%-- 
    Document   : tabela
    Created on : 20/09/2019, 20:11:59
    Author     : marco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/tabela.css">
    </head>
    <body>
        <div id="botao_voltar">
            <a href="placar"><button type="button" class="btn btn-success"> Incluir Outro Resultado </button></a>
        </div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Classificação</th>
                    <th>Clube</th>
                    <th>Total de Pontos</th>
                    <th>Vitórias</th>
                    <th>Empates</th>
                    <th>Derrotas</th>
                    <th>GP</th>
                    <th>GC</th>
                    <th>SG</th>
                </tr>
            </thead>
            <tbody>
        <% 
        ServletContext sc = request.getServletContext();
        ArrayList<Time> timesTabela = (ArrayList<Time>) sc.getAttribute("timesTabela");  
        int i = 0;
        for(Time time: timesTabela){
            %>
            <tr class="table-success">
                <td><%= ++i %></td>
                <td><%= time.getNomeDoClube() %></td>
                <td><%= time.getTotalDePontos() %></td>
                <td><%= time.getQuantidadeDeVitorias() %></td>
                <td><%= time.getEmpates() %></td>
                <td><%= time.getDerrotas() %></td>
                <td><%= time.getGolsPro() %></td>
                <td><%= time.getGolsContra() %></td>
                <td><%= time.getSaldoDeGols() %></td>
            </tr>
            <%
        }
        
        
        %>
            </tbody>
        </table>
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   
    </body>
</html>
