<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="yellow">
	<center>
		<h1>Employee Details</h1>
		<table border="1" width="70%" cellpadding="2">
			<tr>
				<th>EId</th>
				<th>EName</th>
				<th>Email</th>
				<th>Password</th>
				<th>Address</th>
				<th>Edit</th>
				<th>Delete</th>
				<c:forEach var="emp" items="${emps}">
					<tr>
						<td>${emp.eid}</td>
						<td>${emp.name}</td>
						<td>${emp.email}</td>
						<td>${emp.password}</td>
						<td>${emp.address}</td>
						<td><a href="/edit/${emp.eid}">Edit</a>
						<td><a href="/delete/${emp.eid}">Delete</a>
					</tr>
				</c:forEach>
		</table>
		<br /> <a href="/">Add New Employee</a>
	</center>
</body>