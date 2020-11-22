<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Complaint Manager</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       
    </head>
    <br/>
    <div class="text-center"><h1>Customer Complaint System</h1></div>
	<div align="right" style="padding-right:50px;"><a href="/complaintsystem/showComplaints">Admin</a></div>    

    <form action="/complaintsystem/submitComplaint" modelAttribute="complaints" method="POST">
        <br/>

        <div class= "row mx-md-5">
        <div class="col px-md-5">
        <div class="form-group">
            <label for="Message">Message</label>
            <textarea class="form-control" cols="30" rows="10" placeholder="Enter Message" id="Message" name="Message"></textarea>
        </div></div></div>
        <div class= "row mx-md-5">
        <div class="col px-md-5">
        <div class="form-group">
          <label for="exampleInputEmail1">Email address</label>
          <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email">
          <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div></div></div>
        <div class= "row mx-md-5">
        <div class="col px-md-5">
        <div class="form-group">
          <label for="exampleInputName">Name</label>
          <input type="text" class="form-control" id="exampleInputName" id="name" name="name" placeholder="Name">
        </div></div></div>
        <!-- <div class= "row mx-md-5">
        <div class="col px-md-5">
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1">
          <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div></div></div> -->
        <div class= "row mx-md-5">
        <div class="col px-md-5">
        <button type="submit" class="btn btn-primary">Submit</button></div></div>
      </form>

</html>