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
    <title>List of cars</title>
    <style type="text/css">
        TABLE {
            border: 1px solid black;
            font-size: 16px;
        }
        TD, TH {
            padding: 5px;
        }
        TH {
            text-align: left;
            background: black;
            color: white;
        }
        a {
            border: 1px solid #333; /* Рамка */
            display: inline-block;
            padding: 5px 15px; /* Поля */
            text-decoration: none; /* Убираем подчёркивание */
            color: #000; /* Цвет текста */
        }
        a:hover {
            box-shadow: 0 0 5px rgba(0,0,0,0.3); /* Тень */
            background: linear-gradient(to bottom, #fcfff4, #e9e9ce); /* Градиент */
            color: #a00;
        }
    </style>
</head>

<body>
<a href="/mvc/carAdd " class="c">Add new car</a>

    <h3>List of cars</h3>
    <table>
        <thead>
            <tr>
                <th>Id car</th>
                <th>Brend</th>
                <th>Description</th>
                <th>Date</th>
                <th>Id seller5</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.brend}</td>
                <td>${car.decription}</td>
                <td>${car.date_of_manufacture}</td>
                <td>${car.ip_user}</td>
                <td><a href="/mvc/edit/${car.id} "/>edit</td>
                <td><a href="/mvc/delete/${car.id} "/>delete</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>

