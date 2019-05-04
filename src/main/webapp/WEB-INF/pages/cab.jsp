<%--
  Created by IntelliJ IDEA.
  User: Alexey_Korotayev
  Date: 4/26/2019
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>One Car 2019</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id car</th>
        <th>Brend</th>
        <th>Description</th>
        <th>Date</th>
        <th>Id_seller</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${car.id}</td>
            <td>${car.brend}</td>
            <td>${car.decription}</td>
            <td>${car.date_of_manufacture}</td>
            <td>${car.ip_user}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
