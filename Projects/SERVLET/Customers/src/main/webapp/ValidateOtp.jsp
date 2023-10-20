<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ValidateOtp" method="post">
		 <center>
            <h1>Validate Otp</h1>
            <table border="3px">
                <tr>
                    <th>User Name : </th>
                    <td>
                        <input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <th>Otp : </th>
                    <td>
                        <input type="number" name="otp">
                    </td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" name="submit">
                    </th>
                </tr>
            </table>
        </center>
	</form>

</body>
</html>