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

	<%
	%>
	<nav class="navbar navbar-expand-sm bg-light">
	  <div class="container-fluid">
	    <ul class="nav navbar-nav">
	      <li class="nav-item" ><a class="nav-link" href="sachController">Trang chủ</a></li>
   
	      <li><a class="nav-link" href="htgioController">Giỏ hàng<span class="badge bg-primary">
	      	<%giohangbo gh=(giohangbo)session.getAttribute("cart");int cout=0 ;
	      	if(gh!=null){
	      	cout=gh.ds.size();}
	      	  out.print(cout);%>
	      			</span> </a></li>
			<li class="nav-item"><a  class="nav-link" href="thanhtoan.jsp">Thanh toán</a></li>
	    </ul>
	      <form action="menu.jsp" method="post" class="d-flex">
        	<input class="form-control me-2" type="text" placeholder="Search"  name="key" >
        	<button class="btn btn-primary" type="button" >Search</button>
      	</form>
	    <ul class="nav navbar-nav navbar-right">
	    <%if(session.getAttribute("user")==null){ %>
	      <li class="nav-item btn"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#ModalSignup">Đăng ký</a></li>
	      <li class="nav-item btn  btn-primary"><a class="nav-link" data-bs-toggle="modal" data-bs-target="#myModal">Đăng nhập</a></li>
	      <%}else{String s=session.getAttribute("user").toString(); %>
	      <li class="nav-item btn"><a class="nav-link" href="LSmuaController">Lịch sử mua hàng</a></li>
	      <li class="nav-item btn"><a class="nav-link" href="LogoutController">Đăng xuất</a></li>
	      <%} %>
	    </ul>
	  </div>
	</nav>
	<div class="modal fade" id="myModal" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h2 class="modal-title">Đăng nhập</h2>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <form action="usercontroller" method="get">
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
			  <%if(request.getParameter("check")!=null) {%>
			  <h5 class="text-danger"> đăng nhập thất bại</h5><%}%>
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
          <form  action="SignupController" method="post">
            <div class="mb-3">
              <label for="inputName" class="form-label">Họ và tên</label>
              <input type="text" class="form-control" id="inputName" placeholder="Nhập họ và tên" required>
            </div>
            <div class="mb-3">
              <label for="inputEmail" class="form-label">Email</label>
              <input type="email" class="form-control" id="inputEmail" placeholder="Nhập địa chỉ email" required>
            </div>
            <div class="mb-3">
              <label for="inputPassword" class="form-label">Mật khẩu</label>
              <input type="password" class="form-control" id="inputPassword" placeholder="Nhập mật khẩu" required>
            </div>
            <div class="mb-3">
              <label for="inputConfirmPassword" class="form-label">Xác nhận mật khẩu</label>
              <input type="password" class="form-control" id="inputConfirmPassword" placeholder="Nhập lại mật khẩu" required>
            </div>
            <button type="submit" class="btn btn-primary">Đăng ký</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  	<div class="row">
  		<div class="col-sm-3">
		  		<ul class="list-group">
		  		<%ArrayList<loaibean> dsloai=(ArrayList<loaibean>) request.getAttribute("dsloai");
		  		for(loaibean loai:dsloai){ %>
		  		<li class="list-group-item"><a class="list-group-item list-group-item-action" href="sachController?ml=<%=loai.getMaloai()%>"><%=loai.getTenloai()%></a></li>
		  		<%} %>
		  		</ul>
		  	</div>
  		<div class="col-sm-8 mt-2">
  		<%if(session.getAttribute("cart")!=null){
		giohangbo g=null;
		
		g=(giohangbo)session.getAttribute("cart"); %>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">Tên sách</th>
						<th scope="col">giá</th>
						<th scope="col">số lượng</th>
						<th scope="col">Thành tiền</th>
					</tr>
				</thead>
				<%
						int n=g.ds.size();
						for(int i=0;i<n;i++ ){
				%>
				<tbody>
					<tr>
						<td ><%=g.ds.get(i).getTensach() %></td>
						<td><%=g.ds.get(i).getGia() %></td>
						<td><%=g.ds.get(i).getSoluongmua() %>
	
						</td>
						<td><%=g.ds.get(i).getThanhtien() %></td>
						<td>
							<form method="post" action="UpdateGio?SuaSL=<%=g.ds.get(i).getMasach()%>">
								<input type='number' name='txtsua'>
								<input type='submit' name='tt' value='Sữa' class="btn btn-primary btn-sm">
							</form>
						</td>
						<td>
							<input class="form-check-input" type="checkbox" name="checkbox<%=i%>" value="<%=g.ds.get(i).getMasach()%>">
						</td>
						<td>
							<a href="UpdateGio?xoams=<%=g.ds.get(i).getMasach()%>" class="btn btn-primary btn-sm">Xóa</a>
						</td>
					</tr>
				</tbody>
					<%}%>
				<tfoot>
					<tr> <td><%=g.TongTien()%> </td></tr>
				</tfoot>
				
			</table>
			<div class="d-flex justify-content-end">
			  <form action="xacnhanController" method="post">
			    <button type="submit" name="b1" class="btn btn-primary">Xác nhận đặt mua</button>
			  </form>
			
			  <a class="btn btn-primary btn-sm" href="sachController">Tiếp tục mua hàng</a>
			
			  <a href="UpdateGio?xoahet=1" class="btn btn-primary btn-sm">Xóa hết</a>
			
			  <a href="UpdateGio" class="btn btn-primary btn-sm">Xóa check</a>
			</div>
			<%}%>
	  	</div>
	  </div>
	   <%if(request.getParameter("checkUser")!=null){ %>
	<script>
	  window.onload = function() {
	    var modal = new bootstrap.Modal(document.getElementById("myModal"));
	    modal.show();
	  };
	</script> 
	<%}%>
</body>
</html>
