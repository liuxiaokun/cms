<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>

    <form name="loginForm" action="j_spring_security_check" method="post">
        username:<input type="text" name="j_username" /><br/>
        password:<input type='password' name="j_password" /><br/>
        <input type="submit" value="submit" /><br/>
    </form>
</body>
</html>