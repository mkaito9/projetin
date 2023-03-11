<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
          pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <html>
        <head>
         <title>Usu�rios do Sistema</title>
        </head>
        <body>
         <jsp:useBean id="dao" class="DAO.UsuarioDAO"/>
         <h1> Lista de Usu�rios do Sistema</h1>
      <table border="1">
        <c:forEach var="usuario" items="${dao.lista}">
          <tr>
            <td>${usuario.nome}</td>
         <td>${usuario.endereco}</td>
          </tr>
        </c:forEach>
      </table>
        </body>
      </html>