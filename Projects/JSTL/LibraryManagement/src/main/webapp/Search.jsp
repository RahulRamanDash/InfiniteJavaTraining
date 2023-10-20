<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    /* Define your CSS styles here */
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }

    form {
        text-align: center;
        margin-top: 20px;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
         .button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
         nav a:hover {
            text-decoration: underline;
        }
	

</style>
<body>
<jsp:include page="NavBar.jsp"/>
<center>
<form action="SearchPrint.jsp">
Select Search Criteria :

<br/><br/>
<input type="radio" name="searchtype" value="id" > By Book Id <br/>
<input type="radio" name="searchtype" value="dept" > By Department <br/>
<input type="radio" name="searchtype" value="bookname" > By Book Name <br/>
<input type="radio" name="searchtype" value="authorname" > By Author Name <br/>
<input type="radio" name="searchtype" value="all" > All Books <br/>
<br/>
Insert Search Value: <input type='text' name='searchvalue' size='10'>
<br/><br/> 
<input type='submit' class="button" value='Search'>
</form>
</center>
</body>

</body>
</html>