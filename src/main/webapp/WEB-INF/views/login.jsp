<!DOCTYPE html>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html lang="en">
<head>

<title></title>
</head>
<body>

<style>



</style>

		<form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">
	<h2>Please Sign In</h2>	
	<div class="input-group margin-bottom-sn">
                        <span class="input-group-addon"><i class="fa fa-envelope-o-fa-fw"></i></span>
                        Username  <input class="form-control" type="text" name ="username" placeholder="Username" />
                        </div>
                    
                    <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-key-fa-fw"></i></span>
                    Password  <input class="form-control" type="password" name ="password" placeholder="Password" />
                    </div>
                    <br>
                    <div class="form-group text-center">
                    <input type="submit" class="btn btn-success btn-login-submit" value="Login" />  
  
                    <button class="btn btn-danger btn-cancel-action">Cancel</button>
                    </div>
			</form:form>



</body>
</html>