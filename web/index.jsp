<%-- 
    Document   : resultadoDoJogo
    Created on : 20/09/2019, 10:50:11
    Author     : marcosantonio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Placar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/placar.css">
       
    </head>
    <body background="imagens/background.jpg">
        <div id="div_form">
            <form class="form_placar" id="id_form_placar" method="post" action="tabeladeclassificacao">
                <div class="form-group">
                    <label for="id_mandante">Mandante</label><br>
                    <select name="time_mandante" class="form-control-sm" id="id_mandante" required>
                        <%
                            ServletContext sc = getServletContext();
                            Enumeration<String> times = (Enumeration<String>)sc.getInitParameterNames();
                            ArrayList<String> arrayTimes = new ArrayList();

                            while(times.hasMoreElements()){
                                String time = times.nextElement();
                                arrayTimes.add(time);
                            %>
                                <option value="<%= time %>"><%= time %> </option>
                            <% 
                            }
                        %>
                    </select> 
                    <input type="number" class="form-control-sm" name="gols_time_mandante" placeholder="Número de gols..." id="id_placar_time_mandante" required>
                </div>
                <div class="form-group">
                    <label for="id_visitante">Visitante</label><br>
                    <select name="time_visitante" class="form-control-sm" id="id_visitante" required>
                        <%        
                            for(String time: arrayTimes){
                            %>
                                <option value="<%= time %>"><%= time %> </option>
                            <%
                            }
                        %>
                    </select> 
                    <input type="number" class="form-control-sm" name="gols_time_visitante" placeholder="Número de gols..." id="id_placar_time_visitante" required>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success" value="Enviar">
                </div>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
    <script>
    document.getElementById("id_form_placar").addEventListener("submit", function(event){
       
       if(document.getElementById("id_mandante").value == document.getElementById("id_visitante").value){
           event.preventDefault();
           alert("Os times devem ser diferentes!");
       }
       if(document.getElementById("id_placar_time_mandante").value < 0 || document.getElementById("id_placar_time_visitante").value < 0){
           event.preventDefault();
           alert("O número de gols deve ser positivo.");
       }
    });
    </script>
</html>


