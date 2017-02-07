<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
this is confirmation.jsp
   <form action="${flowExecutionUrl}" method="post">
<!--  <input type="submit" name="_eventId_goToAddress" value="Next">-->
<input type="submit"  name="_eventId_confirm" value="Next"/>
<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
<button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
</form>
</body>
</html>