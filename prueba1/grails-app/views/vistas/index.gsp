<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva vistas</title>
    </head>
    <body>
        <h1>Lista de los datos contenidos en el "primer dominio"</h1>
        <ul>
            <g:each in='${lista}' var ='item'>
                <li>La fruta ${item?.frutas} es de sabor ${item?.sabores}</li>            
            </g:each>
        </ul>            
    </body>
</html>
