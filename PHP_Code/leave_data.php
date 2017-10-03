<?php
 /*
 $name = $_GET['name'];
 $username = $_GET['username'];
 $email = $_GET['email'];
 $spinner = $_GET['spinner'];
 $dpStart = $_GET['dpStart'];
 $dpEnd = $_GET['dpEnd'];
 
 if($name == '' || $username == ''){
 echo 'please fill all values';
 }else{
 require_once('dbConnect.php');
 $sql = "SELECT * FROM subapp WHERE username='$username'";
 
 $check = mysqli_fetch_array(mysqli_query($con,$sql));
 
 if(isset($check)){
 echo 'Notification already exist';
 }else{ 
 $sql = "INSERT INTO subapp (name,username,email,spinner,dpStart,dpEnd) VALUES('$name','$username','$email','$spinner,'$dpStart','$dpEnd')";
 if(mysqli_query($con,$sql)){
 echo 'Your Application  Submitted Successfully ';
 }else{
 echo  $name.'oops! Please try again!'.$username.''$email''.$spinner.''.$dpStart;
 }
 }
 mysqli_close($con);
 }
 
 
 */
 
 $name = $_GET['name'];
 $username = $_GET['username'];
 $email = $_GET['email'];
 $spinner = $_GET['spinner'];
 $dpStart = $_GET['dpStart'];
 $dpEnd = $_GET['dpEnd'];
 
 if($name == ''){
 echo 'please fill all values';
 }else{
 require_once('dbConnect.php');
 $sql = "SELECT * FROM subapp WHERE username='$username'";
 
 $check = mysqli_fetch_array(mysqli_query($con,$sql));
 
 if(isset($check)){
 echo 'Notification already exist';
 }else{ 
 $sql = "INSERT INTO subapp (name,username,email,spinner,dpStart,dpEnd) VALUES('$name','$username','$email','$spinner','$dpStart','$dpEnd')";
 if(mysqli_query($con,$sql)){
 echo 'Your Notification Submitted Successfully ';
 }else{
 echo 'oops! Please try again!';
 }
 }
 mysqli_close($con);
 }
 
 
 ?>