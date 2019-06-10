<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>users list!!!</h3>
<table>
<tr>
<td>序号</td>
<td>name</td>
<td>birthday</td>
<td>money</td>
<td>修改</td>
<td>删除</td>
</tr>
<c:forEach items="${pb.list }" var="u" >
<tr>
<td>${u.uid}</td>
<td>${u.uname}</td>
<td>${u.birthday}</td>
<td>${u.umoney}</td>
<td><a href="Users_findOne?uid=${u.uid }">修改</a></td>
<td><a href="Users_delete?uid=${u.uid }">删除</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="5">
<c:if test="${pb.p!=1 }">

<a href="Users_findAll?p=1">首页</a>
</c:if>
<a href="Users_findAll?p=${pb.prev }">上一页</a>
<c:forEach begin="${pb.startPage }" end="${pb.endPage }" var="x">
<c:if test="${pb.p==x }">
<font color="red">
							${x }
						</font>
</c:if>
<c:if test="${pb.p!=x }">
<a href="Users_findAll?p=${x }">
							${x }
						</a>
</c:if>
</c:forEach>

<a href="Users_findAll?p=${pb.next }">下一页</a>
<c:if test="${pb.p != pb.maxPage }">
					<a href="Users_findAll?p=${pb.maxPage }">末页</a>
				</c:if>
<font color="red" size="5">
					${pb.p }
				</font>
				/
				${pb.maxPage }
				
				<form action="Users_findAll" style="display: inline;">
				 	跳到第<input size="1" type="text" name="p" />页<button type="submit">GO</button>
				</form>

</td>
</tr>

</table>
<a href="addUsers.jsp">添加</a>


</body>
</html>