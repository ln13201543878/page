<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="Users_update" method="post">
id:<input type="hidden" name="uid" value="${user.uid }"/>
uname:<input type="text" name="uname" value="${user.uname }"/>
birthday:<input type="text" name="birthday" value="${user.birthday }"/>
umoney:<input type="text" name="umoney" value="${user.umoney }"/>
<button>编辑</button>


</form>


</body>
</html>