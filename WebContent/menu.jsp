<%@page import="Bo.giohangbo"%>
<%@page import="Bo.sachbo"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.loaibean"%>
<%@page import="Bo.loaibo"%>
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
	    <%if(session.getAttribute("user")==null){ %>
	      <li class="nav-item btn"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#ModalSignup">Đăng ký</a></li>
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
  	<div class="modal fade" id="ModalSignup" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Đăng ký</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <!-- Form đăng ký -->
          <form action="SignupController"  method="post" >
            <div class="mb-3">
              <label for="inputName" class="form-label">Họ và tên</label>
              <input type="text" class="form-control" id="inputName" placeholder="Nhập họ và tên" name="HovaTen" required>
            </div>
            <div class="mb-3">
              <label for="inputEmail" class="form-label">Email</label>
              <input type="email" class="form-control" id="inputEmail" placeholder="Nhập địa chỉ email" name="email" required>
            </div>
                        <div class="mb-3">
              <label for="inputLocation" class="form-label">Địa chỉ</label>
              <input type="text" class="form-control" id="inputLocation" placeholder="Nhập địa chỉ" name="DiaChi" required>
            </div>
            <div class="mb-3">
              <label for="inputPassword" class="form-label">Tên đăng nhập</label>
              <input type="text" class="form-control" id="inputUsername" placeholder="Nhập tên đăng nhập" name="tendn" required>
            </div>
            <div class="mb-3">
              <label for="inputPassword" class="form-label">Mật khẩu</label>
              <input type="password" class="form-control" id="inputPassword" placeholder="Nhập mật khẩu" name="matKhau" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng ký</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  	<div class="container-fluid">
	  	<div class="row">
		  	<div class="col-sm-2">
		  		<ul class="list-group">
		  		<%loaibo lbo=new loaibo();
		  		for(loaibean loai:lbo.getloai()){ %>
		  		<li class="list-group-item"><a class="list-group-item list-group-item-action" href="sachController?ml=<%=loai.getMaloai()%>"><%=loai.getTenloai()%></a></li>
		  		<%} %>
		  		</ul>
		  	</div>
		  	<div class="d-flex flex-wrap col-sm-8 mt-2">
		  		<% 
				ArrayList<SachBean> ds=(ArrayList<SachBean>)request.getAttribute("ds");
		  		for(SachBean s :ds){
		  		%>
		  		<div></div>
					<div class="card col-12 col-sm-4 col-lg-4 mb-2">
		  				<div class="card-body d-flex flex-column justify-content-center" >
		    				<img class="card-img-top" src="<%=s.getAnh()%>" alt="Card image" style="width:75%; display: block; margin: 0 auto;">
		    				<div class="card-body text-center">
		      					<h4 class="card-title">Tên sách: <%=s.getTensach() %></h4>
		      					<h6 class="card-text">Tác giả :<%=s.getTacgia()%></h6>
		      					<h4 class="card-text">giá :<%=s.getGia()%></h4>
		      					<a href="gioController?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia() %>" class="btn"><img src="mua.png"></a>
		    				</div>
		    			</div>
		  			</div>
		  		<%} %>
		  		
		  	</div>
	  	</div>
  	</div>
  <%if(session.getAttribute("user")==null){ %>
	<script>
	  window.onload = function() {
	    var modal = new bootstrap.Modal(document.getElementById("myModal"));
	    modal.show();
	  };
	</script> 
	<%}%>
</body>
</html>
