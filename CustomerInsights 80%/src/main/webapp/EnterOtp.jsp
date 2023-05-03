<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>OTP Verification</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 
    <style>
        /* Center the form horizontally and vertically */
        .otp-form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        /* Style the form */
        .otp-form form {
            max-width: 400px;
            width: 100%;
            border: 2px solid #ccc;
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.2);
       /*  }
        .form1{
            display: block;
        } */
        /* Style the form header */
        .otp-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        /* Style the form input fields */
        .otp-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 2px solid #ccc;
            font-size: 16px;
            outline: none;
            box-shadow: none;
            transition: box-shadow 0.3s ease-in-out;
        }
        /* Style the form input fields on focus */
        .otp-form input:focus {
            border-color: #1E90FF;
            box-shadow: 0px 0px 5px rgba(30, 144, 255, 0.5);
        }
        /* Style the submit button */
        .otp-form button[type="submit"] {
            background-color: #1E90FF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            justify-content: center;
            
        }
        /* Style the submit button on hover */
        .otp-form button[type="submit"]:hover {
            background-color: #0066CC;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            
        }
    </style>
</head>
<body>

    <div class="otp-form">
        <form action="validateOtp" method="get">
            <h2>OTP Verification</h2>
            <div class="form-group">
           
                <c:set var = "email" scope = "session" value = "${getEmail}"/>
          <c:out value = "${email}"/>
          
                <input type="hidden" class="form1" id="eid" name="email" value="${email}" placeholder="Enter email" >
            </div>

            <div class="form-group">
                <input type="text" class="form-control" id="otp" name="otp" placeholder="Enter OTP" maxlength="6">
            </div>
            <button type="submit" class="btn btn-primary">Verify</button>
             <div><h3 style="color: green;">${otpValid}</h3></div>
               <div><h1 style="color: red;">${otpInvalid}</h1></div>
        </form>
    </div>
     

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
