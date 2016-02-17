<jsp:include page="/basepartials/base.jsp" flush="true"></jsp:include>
<title>Login Page</title>
<jsp:include page="/basepartials/navbar.jsp"></jsp:include>
<body>
	<div class="container topmargin">
		<%
			if (request.getAttribute("err") != null) {
		%>
		<div class="alert alert-warning">
			<h4>This is somewhat embarrassing, isnt it?</h4>
			<%=request.getAttribute("err")%>
		</div>
		<%
			}
		%>
		<h2>Enter Login Details here to get Employee details.</h2>
		<form class="form-horizontal" role="form" action="App" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">Username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						id="username" placeholder="Enter your username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control"
						id="pwd" placeholder="Enter password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" disabled> Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="register-link">
						<a href="/EmployeeCore/register.jsp">Register me</a>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
<footer><jsp:include page="/basepartials/footer.html"></jsp:include></footer>