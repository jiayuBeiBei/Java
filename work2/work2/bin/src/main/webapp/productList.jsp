
<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="com.pojo.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body >

	<table border="1">

		<tr>
			<th>商品ID</th>
			<th>商品名称</th>
			<th>数量</th>
			<th colspan="2">操作</th>
		</tr>
<%
	ArrayList<Product> productList=(ArrayList<Product>) application.getAttribute("productList");
	if (!(productList==null)&&!(productList.equals(null))){
//	out.print(productList.toString());
	for (Product product:productList
		 ) {


%>
		<tr>
		<td><%=product.getId()%>
		</td>
		<td><%=product.getName()%>
		</td>
		<td><%=product.getNum()%>
		</td>

		<td><a href="product!edit.action?productId=<%=product.getId()%>">编辑</a></td>
		<td><a href="product!del.action?productId=<%=product.getId()%>">删除</a></td>
		</tr>
		<%
			}}
		%>

		<tr>
			<th>
				<a href="product!insert.action">增加</a>
			</th>
			<th>
				<a>查询</a>
			</th>
		</tr>

	</table>
</body>
</html>
