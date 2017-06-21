<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Custom Validation Page</title>

</head>
<body>

<form:form action="./validateAccount" modelAttribute="validatedAccount">
    <label for="accountInput">Account: </label>
    <form:input path="account" id="accountInput" />
    <form:errors path="account" cssClass="error" />
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>