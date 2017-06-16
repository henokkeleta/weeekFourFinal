<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Enter your Work Experience Now</p>
<form action = "WorkExperienceServlet" method = "post">
Job 1:<input type = "text" name = "Job1" >
ComPany:<input type = "text" name = "Company" >
Start year:<input type = "text" name = "StartYear" >
Till when:<input type = "text" name = "Till" >
Duty1:<input type = "text" name = "Duty1" >

Duty2:<input type = "text" name = "Duty2" >

<p> do you want to add more education?</p>

  <input type="radio" name="more" value="yes"> yes<br>
  <input type="radio" name="more" value="no"> No<br>
<input type = "Submit" value = "Submit">
</form>
</body>
</html>