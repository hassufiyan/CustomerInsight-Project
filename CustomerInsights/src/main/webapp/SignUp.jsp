<!DOCTYPE html>
<html>

<head>
<title>CustomerInsights</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<style>
*, body {
	font-family: 'Poppins', sans-serif;
	font-weight: 400;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	-moz-osx-font-smoothing: grayscale;
}

html, body {
	height: 100%;
	background-color: #152733;
	/* background-color: #dee9ff;; */
	overflow: hidden;
}

.form-holder {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	text-align: center;
	min-height: 100vh;
}

.form-holder .form-content {
	position: relative;
	text-align: center;
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-align-items: center;
	align-items: center;
	padding: 60px;
}

.form-content .form-items {
	border: 3px solid #fff;
	padding: 40px;
	display: inline-block;
	width: 100%;
	min-width: 540px;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	text-align: left;
	-webkit-transition: all 0.4s ease;
	transition: all 0.4s ease;
}

.form-content h3 {
	color: #fff;
	text-align: left;
	font-size: 28px;
	font-weight: 600;
	margin-bottom: 5px;
}

.form-content h3.form-title {
	margin-bottom: 30px;
}

.form-content p {
	color: #fff;
	text-align: left;
	font-size: 17px;
	font-weight: 300;
	line-height: 20px;
	margin-bottom: 30px;
}

.form-content label, .was-validated .form-check-input:invalid ~.form-check-label,
	.was-validated .form-check-input:valid ~.form-check-label {
	color: #fff;
}

.form-content input[type=number], .form-content input[type=text],
	.form-content input[type=password], .form-content input[type=email],
	.form-content input[type=date] {
	width: 100%;
	padding: 9px 20px;
	text-align: left;
	border: 0;
	outline: 0;
	border-radius: 6px;
	background-color: #fff;
	font-size: 15px;
	font-weight: 300;
	color: #8D8D8D;
	-webkit-transition: all 0.3s ease;
	transition: all 0.3s ease;
	margin-top: 16px;
}

.btn-primary {
	background-color: #6C757D;
	outline: none;
	border: 0px;
	box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active {
	background-color: #495056;
	outline: none !important;
	border: none !important;
	box-shadow: none;
}

.form-content textarea {
	position: static !important;
	width: 100%;
	padding: 8px 20px;
	border-radius: 6px;
	text-align: left;
	background-color: #fff;
	border: 0;
	font-size: 15px;
	font-weight: 300;
	color: #8D8D8D;
	outline: none;
	resize: none;
	height: 120px;
	-webkit-transition: none;
	transition: none;
	margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
	border: 0;
	background-color: #ebeff8;
	color: #8D8D8D;
}

.mv-up {
	margin-top: -9px !important;
	margin-bottom: 8px !important;
}

.invalid-feedback {
	color: #ff606e;
}

.valid-feedback {
	color: #2acc80;
}
</style>


</head>
<body>

	<div class="form-body">
		<div class="row">
			<div class="form-holder">
				<div class="form-content">
					<div class="form-items">
						<h3>Register Today</h3>
						<p>Fill in the data below.</p>
						<form class="requires-validation" novalidate>

							<div class="col-md-12">
								<input class="form-control" type="number" name="ID"
									placeholder="Enter Id" required>
								<div class="valid-feedback">id field is valid!</div>
								<div class="invalid-feedback">id field cannot be blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="text" name="firstName"
									placeholder="First Name" required>
								<div class="valid-feedback">First Name field is valid!</div>
								<div class="invalid-feedback">First Name field cannot be
									blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="text" name="lastName"
									placeholder="Last Name" required>
								<div class="valid-feedback">Last Name field is valid!</div>
								<div class="invalid-feedback">Last Name field cannot be
									blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="email" name="email"
									placeholder="E-mail Address" required>
								<div class="valid-feedback">Email field is valid!</div>
								<div class="invalid-feedback">Email field cannot be blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="password" name="password"
									placeholder="Password" required>
								<div class="valid-feedback">Password field is valid!</div>
								<div class="invalid-feedback">Password field cannot be
									blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="password"
									name="confirmPassword" placeholder="Confirm Password" required>
								<div class="valid-feedback">Confirm Password field is
									valid!</div>
								<div class="invalid-feedback">Confirm Password field
									cannot be blank!</div>
							</div>

							<div class="col-md-12">
								<input class="form-control" type="date" name="dateOfBirth"
									placeholder="DOB" required>
								<div class="valid-feedback">DOB field is valid!</div>
								<div class="invalid-feedback">DOB field cannot be blank!</div>
							</div>


							<div class="col-md-12 mt-3">
								<label class="mb-3 mr-1" for="gender">Gender: </label> <input
									type="radio" class="btn-check" name="gender" id="male"
									autocomplete="off" required> <label
									class="btn btn-sm btn-outline-secondary" for="male">Male</label>

								<input type="radio" class="btn-check" name="gender" id="female"
									autocomplete="off" required> <label
									class="btn btn-sm btn-outline-secondary" for="female">Female</label>

								<input type="radio" class="btn-check" name="gender" id="secret"
									autocomplete="off" required> <label
									class="btn btn-sm btn-outline-secondary" for="secret">Others</label>
								<div class="valid-feedback mv-up">You selected a gender!</div>
								<div class="invalid-feedback mv-up">Please select a
									gender!</div>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="invalidCheck" required> <label
									class="form-check-label">I confirm that all data are
									correct</label>
								<div class="invalid-feedback">Please confirm that the
									entered data are all correct!</div>
							</div>


							<div class="form-button mt-3">
								<button id="submit" type="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
(function () {
'use strict'
const forms = document.querySelectorAll('.requires-validation')
Array.from(forms)
  .forEach(function (form) {
    form.addEventListener('submit', function (event) {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
		
	<h1>>${Success}</h1>
	<h1>>${Failed}</h1>
</body>


</html>

