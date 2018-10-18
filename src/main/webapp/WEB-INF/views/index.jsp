<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/results">
<h1>Welcome to my Hotel Search!</h1>

<label>City </label><select name="city">
              <option value="">Select a City</option>
              <c:forEach items = "${cities }" var = "city">
         		<option <c:if test = "${city eq param.city }" > selected </c:if>> ${city } </option>
              </c:forEach>
          </select>
<p><img src = "https://images.trvl-media.com/hotels/1000000/10000/7500/7472/7472_272_z.jpg" /> </p>
<button type="submit">Find</button>
</form>
</body>
</html>