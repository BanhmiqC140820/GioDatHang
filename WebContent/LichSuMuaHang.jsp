<%@page import="Bean.LichSuMuaHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	      <li class="nav-item" ><a class="nav-link" href="sachController">Trang chủ</a></li>
	      <li><a class="nav-link" href="htgioController">Giỏ hàng
	      <span class="badge bg-primary">
	      	<%giohangbo gh=(giohangbo)session.getAttribute("cart");int cout=0 ;
	      	if(gh!=null){
	      	cout=gh.ds.size();}
	      	  out.print(cout);%>
	      			</span></a></li>
			<li class="nav-item"><a  class="nav-link" href="thanhtoan.jsp">Thanh toán</a></li>
	    </ul>
	      <form action="sachController" method="post"  class="d-flex ms-auto me-auto">
        	<input class="form-control me-2" type="text" placeholder="Search"  name="key" >
        	<button class="btn btn-primary" type="button" >Search</button>
      	</form>
	    <ul class="navbar-nav">
	      <li class="nav-item btn"><a class="nav-link" href="LogoutController">Đăng xuất</a></li>
	      <li class="nav-item btn"><a class="nav-link" href="LogoutController">Lịch sử mua hàng</a></li>
	    </ul>
	  </div>
	</nav>
	<div class="container mt-3">       
	  <table class="table">
	    <thead>
	      <tr>
	        <th>Tên Sách</th>
	        <th>Giá</th>
	        <th>Số lượng mua</th>
	        <th>Ngày Mua</th>
	        <th>Đã mua</th>
	        <th>Thành Tiền</th>
	      </tr>
	    </thead>
	    <%  ArrayList<LichSuMuaHang> dsls=(ArrayList<LichSuMuaHang>)request.getAttribute("dsls");
	    for(LichSuMuaHang ls:dsls){ %>
	    <tbody>
	      <tr>
	        <td><%=ls.getTensach() %></td>
	        <td><%=ls.getGia() %></td>
	        <td><%=ls.getSoluongMua() %></td>
	        <td><%=ls.getNgayMua()%></td>
	        <td><%=ls.isDamua()%></td>
	        <td><%=ls.getThanhtien()%></td>
	      </tr>
	<%} %>
	    </tbody>
	  </table>
	</div>
</body>
</html>