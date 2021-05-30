<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Xin chào  </title>
   
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
</head>
<body style="height:700px">
		<div class="container-fluid"style="height:100%">
		
		<div  class="container">
		<div class="header row" >
		
		<div class="col-xl-2">
		<p style="text-align:center;padding-top:20px;font-size:30px;">Lion Bank</p>
		</div>
	
		<div class="col-xl-2">
		<img style="width:100px;height:100xp;border-style:none"  src="https://lh3.googleusercontent.com/ET2lB-jswFqTKfp_h0KwnhzghW1c5jUtq7lOAW79PwN3CyPcy3IEyZNR8T0FVNIQnpy8NGCA0pyPga-bByDUfSQt6bx6rTC-co4dE9Mi0te-8PucpRFR10wPSgpt41CaAbWXUsulCgzJsCXoITtUNf5x9Quh4JrtWCFaUgQR3Lsl9aMlNgrroT9of1LFAcbd-tydM8j_8q7oZloouDUSKPhoWitgoLR-qV5xplj5KbEeL4BtwrEA7whisKjyMf8-t6RhZvXj1g02XkwXd0o2C1fpaQttOwQk2cb68FXxNnZ6Y4FV4MJy5B82kFpxkUirvSjShIQRAmYA8BsPBGjGVf4focJgcy-WDTSP7qe5QwIF8JY-fSVH3BOctiG3hRsYy5JuqKG0_M4fgAGA5DLwc66WJ9QQsAbHJ637Y75PmPyuTmUED4ZKlbb2jSY9MURfziM4wWX4cDCPOrY9-lmcNOGvrbzMF-ZOMPi3BQcB4mry8N-EZJD_vJW_lG3jTb9k5hFaHYA8Hnu4CHK39k5cXotrSVKe5Zi26kiMQViPJb-2rMFrLBWU2TuR_cdfuOwPBOphu8hvoGfXp7EBLoIYC9DLlhUeAdMQ6IMq6mLnGkLbNgxZWpbuDSD3VsB6f-I8_RmmuhVUltrrPfti2QpC0qhf_XWTCrnUWhg7N1u4eeFjiAzwYBCGf-K0VzzDHUnWMHQB9jVrqx5rqVcEXbhVkZg=w800-h600-no?authuser=0" alt="..." class="img-thumbnail">
		</div>
		
		<div class="col-xl-6"></div>
		<div class="col-xl=2">
		<a href="/bank/backtoindex"> Đăng xuất  </a>
		</div>
		</div>
		
		<div class ="main row" style = "margin-top:80px">
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="/bank/checklogin?username=<c:out value = '${ user.username}' />&password=<c:out value= '${ user.password}' />">Trang chủ  <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/bank/mosoform?username=<c:out value = '${ user.username}' />&password=<c:out value= '${ user.password}' />" >Mở sổ ngân hàng </a>
		      </li>

		      <li class="nav-item">
		        <a class="nav-link" href="/bank/rutsoform?username=<c:out value = '${ user.username}' />&password=<c:out value= '${ user.password}' />" >Xem sổ ngân hàng </a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		</div>
		
		<c:if test="${mistake != null }">
		<div class="alert alert-danger" role="alert">
			<c:out value="${mistake}"></c:out>
		</div>
		</c:if>
		
		<form class="form-inline" action="/bank/timkiemso" style="margin-top:100px">
			<div class="form-group">
		    <input type="hidden"   name="username" value ='<c:out value="${user.username }"></c:out>'>
		  </div>
		  <div class="form-group">
		    <input type="hidden"  name="password" value ='<c:out value="${user.password }"></c:out>'>
		  </div>
		  <div class="form-group">
		    <input type="text" class="form-control" id="pwd" name="bookid" placeholder="Mã sổ tiết kiệm" style="width:400px">
		  </div>
		  <button type="submit" class="btn btn-primary">Tìm kiếm sổ</button>
		</form>
		
		</div>

		</div>
</body>
</html>