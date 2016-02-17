<jsp:include page="/basepartials/base.jsp"></jsp:include>
<title>User Registration</title>
<head>
<title>Register</title>
</head>
<body>
	<jsp:include page="/basepartials/navbar.jsp"></jsp:include>
	<div class="container topmargin register">
		<div class="row">
			<div class="col-md-6">
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
				<form class="form-horizontal" action="UserApp" method="POST">
					<fieldset>
						<div id="legend">
							<legend>Register</legend>
						</div>
						<div class="control-group">
							<label class="control-label" for="username">Username</label>
							<div class="controls">
								<input type="text" id="username" name="username"
									class="form-control input-lg" data-validation="[NOTEMPTY]">
								<p class="help-block">Username can contain any letters or
									numbers, without spaces</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="password">Password</label>
							<div class="controls">
								<input type="password" id="password" name="password"
									placeholder="" class="form-control input-lg"
									data-validation="[NOTEMPTY]">
								<p class="help-block">Password should be at least 6
									characters</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="password_confirm">Password
								(Confirm)</label>
							<div class="controls">
								<input type="password" id="password_confirm"
									name="password_confirm" placeholder=""
									class="form-control input-lg" data-validation="[NOTEMPTY]">
								<div class="alert alert-danger hidden">
									<strong>Watch out DUDE!</strong> Passwords do not match
								</div>
								<p class="help-block">Please confirm password</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="email">E-mail</label>
							<div class="controls">
								<input type="email" id="email" name="email"
									class="form-control input-lg">
								<p class="help-block">Please provide your E-mail</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="fname">Firstname</label>
							<div class="controls">
								<input type="text" id="firstname" name="firstname"
									class="form-control input-lg">
								<p class="help-block">Please provide your Firstname</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="lname">Lastname</label>
							<div class="controls">
								<input type="text" id="lastname" name="lastname"
									class="form-control input-lg">
								<p class="help-block">Please provide your Lastname</p>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<button class="btn btn-success reg">Register</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
<footer><jsp:include page="/basepartials/footer.html"></jsp:include>
	<script src="/EmployeeCore/static/js/register.js"></script>
</footer>
</html>