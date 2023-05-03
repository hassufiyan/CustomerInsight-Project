<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
    body {
  font-family: Arial, sans-serif;
  background-color: #f5f5f5;
}

.container {
  margin-top: 50px;
  border: 1px solid #ddd;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0,0,0,.1);
  background-color: #fff;
  padding: 30px;
}

h2 {
  font-weight: 600;
  font-size: 24px;
  margin-bottom: 30px;
  color: #333;
}

.form-control {
  border-radius: 2px;
  box-shadow: none;
  border-color: #ddd;
}

.form-control:focus {
  box-shadow: none;
  border-color: #20a0ff;
}

.btn-primary {
  background-color: #20a0ff;
  border-color: #20a0ff;
  padding: 8px 20px;
  font-size: 16px;
  font-weight: 600;
  border-radius: 2px;
}

.btn-primary:hover {
  background-color: #fff;
  color: #20a0ff;
}

.alert {
  margin-top: 20px;
  border-radius: 2px;
  padding: 15px;
  font-size: 14px;
}

.alert-success {
  background-color: #d4edda;
  border-color: #c3e6cb;
  color: #155724;
}

.alert-danger {
  background-color: #f8d7da;
  border-color: #f5c6cb;
  color: #721c24;
}


</style>



  </head>
  <body>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
          <h1 class="text-center mb-4">Reset Password</h1>
          <form action="resetPassword" method="post">
            <div class="form-group">
              <label for="email">Email address</label>
              <input type="email" class="form-control" id="email" name="email" required>
              <h2>${nullEmail}</h2>
            </div>
            <div class="form-group">
              <label for="password">New Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
              <label for="confirmPassword">Confirm New Password</label>
              <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Reset Password</button>
          </form>
        </div>
      </div>
       <div class="text-center">
                    <a href="SignIn.jsp">Back to Login</a>
                </div>
              <h2>${resetSuccess}</h2>
              <h2>${resetFailed}</h2>  
                
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  </body>
</html>
    