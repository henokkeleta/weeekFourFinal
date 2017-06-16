<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "EducationServlet" method = "post">
University:<input type = "text" name = "University" ><br>
Major:<input type = "text" name = "Major" ><br>
Graduated year:<input type = "text" name = "GraduateYear" ><br>
<p>do you want to continue?</p><br>
 <!--radio-->
 <p> do you want to add more education?</p>

  <input type="radio" name="more" value="yes"> yes<br>
  <input type="radio" name="more" value="no"> No<br>
  

<input type = "Submit" value = "Submit">
</form>

</body>
</html>