<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "test3";
try {
    	$conn = mysqli_connect($servername, $username, $password,$dbname);
}
catch(PDOException $e)
    {
    	die("OOPs something went wrong");
    }
 
?>