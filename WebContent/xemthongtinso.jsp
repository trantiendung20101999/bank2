<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Xem thông tin sổ  </title>
   
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
		<a href="/bank/backtoindex">Đăng xuất </a>
		</div>
		</div>
		
		<div class ="main row" style = "margin-top:80px">
		
		<c:if test="${status1 != null }">
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="/bank/checklogin?username=<c:out value = '${ book.user.username}' />&password=<c:out value= '${ book.user.password}' />">Trang chủ  <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/bank/xemso?username=<c:out value = '${ book.user.username}' />&password=<c:out value= '${ book.user.password}' />" >Xem sổ tiết kiệm cá nhân </a>
		      </li>
		    </ul>
		  </div>
		</nav>
		</c:if>
		
		<c:if test="${ status2 != null }">
		
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
		        <a class="nav-link" href="/bank/tinhlaiform?username=<c:out value = '${ user.username}' />&password=<c:out value= '${ user.password}' />" >Tính lãi ngân hàng </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/bank/rutsoform?username=<c:out value = '${ user.username}' />&password=<c:out value= '${ user.password}' />" >Rút sổ tiết kiềm </a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		</c:if>
		
		
		</div>
		<div style="margin-top:50px">
		<h4 style="padding-bottom:50px"> Thông tin chi tiết về sổ tiết kiệm </h4>
		
		<p> Họ và tên khách hàng: <c:out value='${book.user.fullname }' />  </p> 
		<p> CMTND/CCCD/Hộ chiếu: <c:out value='${book.user.idCard }' />  </p> 
		<p> Địa chỉ khách hàng : <c:out value='${book.user.address }' />  </p> 
		<p> Số điện thoại : <c:out value='${book.user.phonenumber }' />  </p> 
		<p> Chi nhánh : <c:out value='${book.branch }' />  </p> 
		<p> Kiểu tiết kiệm : <c:out value='${book.typeOfSaving }' />  </p> 
		<p> Ngày phát hành : <c:out value='${book.startDate }' />  </p> 
		<p> Kỳ hạn : <c:out value='${book.interestTerm }' /> tháng  </p> 
		<form>
		
		<c:if test="${status1 !=null }">
		
		<input type="hidden" name="status" value="1"/>
		
		</c:if>
		
		
		<c:if test="${status2 !=null }">
		
		<input type="hidden" name="status" value="2"/>
		<input type="hidden" name="username" value="<c:out value="${user.username }"/>"/>
		<input type="hidden" name="password" value="<c:out value="${user.password }"/>"/>
		<button type="submit" class="btn btn-primary" formaction= "/bank/rutso" >Rút sổ</button>
		</c:if>
		<input type="hidden" name="bookid" value="<c:out value='${book.id }'/>"/>
		<button type="submit" class="btn btn-primary" formaction= "/bank/tinhlaihientai" >Tính lãi tới thời điểm hiện tại </button>
		<button type="submit" class="btn btn-primary" formaction="/bank/tinhlaihetdinhky" style="padding-left:40px;padding-right:40px">Tính lãi tới hết kỳ hạn</button>
		</form>
		<c:if test='${tienlaihientai !=null }'>
		<p style="margin-top:10px"> 
		Tiền lãi tới thời điểm hiện tại : 
		<c:out value ='${tienlaihientai } ' />
		</p>
		</c:if>
		<c:if test='${tienlaihetdinhky !=null }'>
		<p style="margin-top:10px">
		Tiền lãi tới hết định kỳ: 
		<c:out value ='${tienlaihetdinhky } ' />
		</p>
		</c:if>
		</div>
		</div>

		</div>
</body>
</html>