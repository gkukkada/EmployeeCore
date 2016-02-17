<%@page import="com.java.hibernate.core.entity.Employee"%>
<jsp:include page="/basepartials/base.jsp" flush="true"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/basepartials/navbar.jsp"></jsp:include>
<body>
	<div class="container report topmargin">
		<a href="/EmployeeCore/id.jsp" type="button" id="back"
			class="btn btn-success"><span
			class="glyphicon glyphicon-arrow-left" aria-hidden="true"> </span>
			Back</a>
		<div class="alert alert-success">${success}</div>
		
		
		<!-- >%
			if (request.getAttribute("success") != null) {
		%-->
		
		<%-- <%
			}
		%> --%>
		<h2>Employee Details</h2>
		<button id="add" class="btn btn-sm btn-primary disabled">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"> </span>
			Add
		</button>
		<form action="DBOEmployee" method="POST">
			<input type="number" class="hidden" name="remove" id="empid" />
			<table class="table table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th>Remove</th>
						<th>Edit/Update</th>
						<th>Employee ID</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Age</th>
						<th>Address</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><button id="remove" type="submit"
								class="btn btn-sm btn-danger" data-toggle="modal"
								data-target="#modal">
								<span class="glyphicon glyphicon-remove" aria-hidden="true">
								</span> Remove
							</button></td>
						<td><button id="edit" class="btn btn-sm btn-primary disabled">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true">
								</span> Edit
							</button></td>
						<%
							if (request.getAttribute("empObj") != null) {
						%>
						<td>
							<%
								Employee ob = (Employee) request.getAttribute("empObj");
									out.println(ob.getId());
							%>
						</td>
						<td>
							<%
								Employee ob1 = (Employee) request.getAttribute("empObj");
									out.println(ob.getFname());
							%>
						</td>
						<td>
							<%
								Employee ob2 = (Employee) request.getAttribute("empObj");
									out.println(ob2.getLname());
							%>
						</td>
						<td>
							<%
								Employee ob3 = (Employee) request.getAttribute("empObj");
									out.println(ob3.getAge());
							%>
						</td>
						<td>
							<%
								Employee ob4 = (Employee) request.getAttribute("empObj");
									out.println(ob4.getAddress());
							%>
						</td>
						<%
							}
						%>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
<footer>
	<jsp:include page="/basepartials/footer.html"></jsp:include>
	<script src="/EmployeeCore/static/js/employee.js"></script>
</footer>