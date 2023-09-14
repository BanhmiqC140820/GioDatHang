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
	     	<li><a class="nav-link" href="htgioController">Quản lý sách</a></li>
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

  	<div class="container-fluid">
	  	<div class="row">
		  	<div class="d-flex flex-wrap col-sm-8 mt-2">
		  		
		<div class="container mt-3">   
		    <form action="QLLoaiController" method="post">
		    	 <div class="mb-3">
	              	<input type="text" class="form-control"  placeholder="Mã loại" name="txtmaloai" value="${ml}" >
	              	<input type="text" class="form-control"  placeholder="Tên loại" name="txttenloai" value="${tenloai}">
	            	<input type="submit" class="btn btn-primary"  placeholder="add" name="Add" value="Add">
	            	<input type="submit" class="btn btn-primary"  placeholder="update" name="update" value="Update">
	            </div>
	            <div class="d-flex mb-3">
	            </div>
		    </form>
		  <table class="table">
		    <c:forEach var="xn" items="${dsloai}">
			     <tbody>
			      <tr>
			    	<td>${xn.getMaloai()}</td>
			    	<td>${xn.getTenloai()}</td>
			    	<td><a href="QLLoaiController?ml=${ xn.getMaloai()}&tenloai=${xn.getTenloai() }&tab=chon">select</a> </td>
			    	<td><a href="QLLoaiController?ml=${ xn.getMaloai()}&tab=xoa">delete</a> </td>
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
