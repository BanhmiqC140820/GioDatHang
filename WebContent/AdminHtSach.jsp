<%@page import="Bean.XacNhanBean"%>
<%@page import="Bo.giohangbo"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.loaibean"%>
<%@page import="Bo.loaibo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light">
	  <div class="container-fluid">
	    <ul class="navbar-nav me-auto mb-2 mb-sm-0">
	     	<li class="nav-item" ><a class="nav-link" href="sachController">Quản lý loại sách</a></li>
	     	<li><a class="nav-link" href="QLSachController">Quản lý sách</a></li>
			<li class="nav-item"><a  class="nav-link" href="AdminXacNhanController">Xác nhận hóa đơn</a></li>
	    	<li class="nav-item"><a  class="nav-link" href="AdminXacNhanController">Khách hàng chuyển tiền</a></li>
	    </ul>
	      <form action="sachController" method="post"  class="d-flex ms-auto me-auto">
        	<input class="form-control me-2" type="text" placeholder="Search"  name="key" >
        	<button class="btn btn-primary" type="button" >Search</button>
      	</form>
	    <ul class="navbar-nav">
	    <%if(session.getAttribute("user")==null){ %>
	      <li class="nav-item btn  btn-primary"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#ModalLogin">Đăng nhập</a></li>
	      <%}else{String s=session.getAttribute("user").toString(); %>
	      <li class="nav-item btn"><a class="nav-link" href="LSmuaController">Lịch sử mua hàng</a></li>
	      <li class="nav-item btn"><a class="nav-link" href="LogoutController">Đăng xuất</a></li>
	      <%} %>
	    </ul>
	  </div>
	</nav>
	<div class="modal fade" id="ModalLogin" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h2 class="modal-title">Đăng nhập</h2>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <form action="usercontroller" method="post">
			  <div class="mb-3 mt-3">
			    <label for="username" class="form-label" >usename:</label>
			    <input type="text" class="form-control" placeholder="username" name="username" required>
			  </div>
			  <div class="mb-3">
			    <label for="pwd" class="form-label" >Password:</label>
			    <input type="password" class="form-control" id="pwd" placeholder="password" name="pswd" required>
			  </div>
			  <div class="form-check mb-3">
			    <label class="form-check-label">
			      <input class="form-check-input" type="checkbox" name="remember"> Remember me
			    </label>
			  </div>
			  <button type="submit" class="btn btn-primary">Đăng nhập</button>
			</form>
	      </div>
		
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

  	<div class="container">
	  	<div class="row">
		  	<div class="d-flex flex-wrap col-sm-8 mt-2">
		  		
		<div class="container mt-3">   
		      <div class="container mt-5">
		        <form action="QLSachController" method="post" enctype="multipart/form-data">
		            <div class="mb-3">
		                <label class="form-label">Mã sách:</label>
		                <input type="text" class="form-control"  name="masach" value="${sach.getMasach()}" required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Tên sách:</label>
		                <input type="text" class="form-control"  name="tensach" value="${sach.getTensach()}" required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Số lượng:</label>
		                <input type="number" class="form-control" name="soluong" value="${sach.getSoluong()}"  required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Giá:</label>
		                <input type="number" class="form-control" name="gia" value="${sach.getGia()}"  required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Mã loại sách:</label>
		                <input type="text" class="form-control" name="maloai" value="${sach.getMaloai()}" required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Ảnh:</label>
		                <img class="rounded" src="${sach.getAnh()}" alt="img-fluid" style="width:25%;">
		                <input type="file" class="form-control" name="anh" accept="image/*" required>
		            </div>
		
		            <div class="mb-3">
		                <label class="form-label">Tác giả:</label>
		                <input type="text" class="form-control" name="tacgia" value="${sach.getTacgia()}" required>
		            </div>
		            <input type="submit" class="btn btn-primary"  name="Add" value="Add">
	            	<input type="submit" class="btn btn-primary"  name="update" value="Update">
		        </form>
		    </div>
		  <table class="table table-hover">
		    <c:forEach var="xn" items="${ds}">
			     <tbody>
			      <tr>
			    	<td>${xn.getMasach()}</td>
			    	<td>${xn.getTensach()}</td>
			    	<td>${xn.getTacgia()}</td>
			    	<td>${xn.getGia()}</td>
			    	<td>${xn.getSoluong()}</td>
			    	<td><img class="rounded" src="${xn.getAnh()}" alt="Cinque Terre" style="width:50%; display: block; margin: 0 auto;"></td>
			    	<td>${xn.getMaloai()}</td>
			    	<td><a href="QLSachController?msSelect=${ xn.getMasach()}&tab=select">select</a></td>
			    	<td><a href="QLSachController?msDelete=${ xn.getMasach()}&tab=delete">delete</a></td>
			      </tr>
			     </tbody>
		     </c:forEach>
		  </table>
		</div>	
		  	</div>
	  	</div>
  	</div>

</body>
</html>
