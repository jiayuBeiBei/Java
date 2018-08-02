
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
${param.productId}商品编辑
<form action="insert.action" >
	<input type="text" name="id" placeholder="id"><br>
	<input type="text" name="name" placeholder="name"><br>
	<input type="text" name="num" placeholder="num"><br>
	<input type="submit"  value="提交">
</form>
</body>
</html>