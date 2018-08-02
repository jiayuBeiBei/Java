<%--
  Created by IntelliJ IDEA.
  User: jiayu
  Date: 2018/6/21
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:forward page="/query.action"></jsp:forward>
  <s:if test=""
    <table border="1">
      <tr>
        <td>studentId</td>
        <td>studentName</td>
        <td>teacherId</td>
        <td>teacherName</td>
      </tr>
      <c:set  var="list" target="${applicationScope.list}"></c:set>
      <c:forEach items="list" var="i">

        <td>${i.id}</td>
        <td>${i.name}</td>
        <td>${i.teacher.id}</td>
        <td>${i.teacher.name}</td>
      </c:forEach>
      <tr>
        <td><a href="/index.jsp">add</a> </td>
        <td><a href="/query.action">query</a> </td>
      </tr>
    </table>
  </body>
</html>
