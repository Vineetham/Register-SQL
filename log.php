<?php
	 include 'config.php';
	 
	 // Check whether username or password is set from android	
     if(isset($_POST['username1']) && isset($_POST['usnno1']) && isset($_POST['dob1']) && isset($_POST['email1'])  && isset($_POST['gender1'])  && isset($_POST['phoneno1'])  && isset($_POST['password1']) && isset($_POST['confirm1']))
     {
		  // Innitialize Variable
		  $result='';
	   	  $username = $_POST['username1'];
		  $usnno = $_POST['usnno1'];
		  $dob = $_POST['dob1'];
		  $email = $_POST['email1'];
		  $gender = $_POST['gender1'];
		  $phoneno = $_POST['phoneno1'];
		  $password = $_POST['password1'];
		  $confirm = $_POST['confirm1'];
		  
		  // Query database for row exist or not
          $sql = "insert into tbl_login (username,usnno,dob,email,gender,phoneno,password,confirm) values ('$username','$usnno','$dob','$email','$gender','$phoneno','$password','$confirm')";
          $res = mysqli_query($conn,$sql);
        //   $rowcount=mysqli_num_rows($res);
         if($res)
{
echo "Success";
  	}
else
{
echo "Failure";
}
	}
?>
