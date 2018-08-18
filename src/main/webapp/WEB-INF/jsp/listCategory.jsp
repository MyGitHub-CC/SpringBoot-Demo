<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
	/*将post method 改变为delete*/
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("#formdelete").attr("action", href).submit();
			return false;
		})
	})
</script>
<body>
	<div align="center"></div>

	<div style="width: 500px; margin: 20px auto; text-align: center">
		<table align='center' border='1' cellspacing='0'>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${page.list}" var="c" varStatus="st">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td><a href="category/${c.id}">编辑</a></td>
					<td><a class="delete" href="category/${c.id}">删除</a></td>
				</tr>
			</c:forEach>

		</table>
		<br>
		<div>
			<a href="?start=1">[首 页]</a> <a href="?start=${page.pageNum-1}">[上一页]</a>
			<a href="?start=${page.pageNum+1}">[下一页]</a> <a
				href="?start=${page.pages}">[末 页]</a>
		</div>
		<br>
		<form action="category" method="post">
			<input type="hidden" name="_method" value="PUT"> name: <input
				name="name"> <br>
			<button type="submit">提交</button>
		</form>

		<form id="formdelete" action="" method="POST">
			<input type="hidden" name="_method" value="DELETE">
		</form>
	</div>
</body>
</html>