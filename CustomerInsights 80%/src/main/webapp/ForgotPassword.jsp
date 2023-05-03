<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Forgot Password - Bootstrap Template</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f7f7f7;
            font-family: Arial, Helvetica, sans-serif;
        }
        .card {
            margin-top: 80px;
            border: none;
            box-shadow: 0px 2px 20px rgba(0, 0, 0, 0.1);
        }
        .card-header {
            background-color: #fff;
            color: #000;
            font-weight: bold;
            border-bottom: none;
        }
        .card-body {
            padding: 40px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-control {
            border-radius: 0px;
            box-shadow: none;
            border-color: #dfe3e8;
        }
        .btn-primary {
            background-color: #000;
            border-radius: 0px;
            border: none;
        }
        .btn-primary:hover {
            background-color: #333;
        }
        .text-center {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Forgot Password</h3>
                    </div>
                    <div class="card-body">
                        <form action="forgotPassword" method="post">
                        
                        
                            <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email address">
                            </div>
                            <div>
                            <button type="submit" class="btn btn-primary btn-block">Send OTP</button>
                           </div>
                             <div>
                            <button type="submit" class="btn btn-primary btn-block"><a style="text-decoration:none;" href="EnterOtp.jsp">Validate OTP</button>
                           </div>
                           <div><h2 style="color: green;">${otpSuccess}</h2></div>
                           <h1 style="color: red;">${enull}</h1>
                        </form>
                    </div>
              </div>
              </div>
              </div>
                <div class="text-center">
                    <a href="SignIn.jsp">Back to Login</a>
                </div>
            </div>
        </div>
    </div>
   
    
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>



</body>
</html>