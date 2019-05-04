<%--
  Created by IntelliJ IDEA.
  User: Alexey_Korotayev
  Date: 5/3/2019
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
    <script>
        function comeback() {
            window.location.href='/mvc/cabList';
        }
    </script>
</head>
<body>
    <h3>New car</h3>
    <form name="car" action="/mvc/add" method="post" >
        <table>
            <tr>
                <td>Brand</td> <td><input title="Brand" type="text" name="brend" value="${car.brend}"></td>
            </tr>
            <tr>
                <td>Decription</td> <td><input title="decription" type="text" name="decription" value="${car.decription}"></td>
            </tr>
            <tr>
                <td>Date of manufacture</td> <td><input title="date_of_manufacture" type="text" name="date_of_manufacture" value="${car.date_of_manufacture}"></td>
            </tr>
            <tr>
                <td>User code</td> <td><input title="ip_user" type="text" name="ip_user" value="${car.ip_user}"></td>
            </tr>
        </table>
        <input type ="submit" value="OK">
        <input type="button" onclick="comeback()" value="Cancel!">
    </form>
</body>
</html>

