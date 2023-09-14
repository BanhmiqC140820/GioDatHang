<%@page import="java.util.Enumeration"%>
<%@page import="Tam.CgioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container col-sm-2">
		<form method='post' action ='DatHang.jsp'><br>
			<label>Ten hang</label> 
			<input type='text' name='txtth' class="form-control"><br>
			<label>Gia </label> 
			<input type='text' name='txtgia' class="form-control"><br>
			<label>So luong </label> 
			<input type='text' name='txtsl' class="form-control"><br>
			<input type='submit' name='un1' value='Dat Hang' class="btn btn-primary">
		</form>
	</div>
	<div class="col-sm-8 text-left">
		<label> Gio hang</label>
			
			<%String th= request.getParameter("txtth");
			String gia= request.getParameter("txtgia");
			String sl= request.getParameter("txtsl");
			if(th!=null&&gia!=null&&sl!=null){
				CgioHang g= new CgioHang();
				//Neu mua hang lan dau
				if(session.getAttribute("gh")==null){
					session.setAttribute("gh", g);//Tao gio
				}
				//Gian session: gh vao bien: g
				g=(CgioHang)session.getAttribute("gh");
				//Them hang vao bien: g
				g.Them(th,Integer.parseInt(gia),
				Integer.parseInt(sl));
				//Luu bien vao session
				session.setAttribute("gh", g);
			}
			//Hien thi do trong session: gh
			if(session.getAttribute("gh")!=null){
				CgioHang g= new CgioHang();
				g=(CgioHang)session.getAttribute("gh");
				int sh=g.ds.size();%>
			
			<table class="table">
				<thead>
					<tr>
						<th>ten hang</th>
						<th>gia</th>
						<th>so luong</th>
						<td>Tong tien</td>
					</tr>
				</thead>
				<tbody>
				<%	for(int i=0;i<sh;i++){ %>
					<tr >
						<td>
						<%=g.ds.get(i).getTenhang() %>
						</td>
						<td><%=g.ds.get(i).getGia() %></td>
						<td>
						<%=g.ds.get(i).getSoluong()%>
						<form method='post' action="sua.jsp?th=<%=g.ds.get(i).getTenhang()%>">
								<input type='text' name='txtsua'>
								<input type='submit' name='tt' value='Sữa' class="btn btn-primary btn-sm">
							</form>
						</td>
						<td><%=g.ds.get(i).getThanhtien()%></td>
						<td class="checkbox">
							<form method='post' action="xoa.jsp?th=<%=g.ds.get(i).getTenhang()%>">
								<input type='submit' name='tt1' value='Xoa' class="btn btn-primary btn-sm">
							</form>
							<input type="checkbox" class="form-check-input" name="check<%=i%>" value="<%=g.ds.get(i).getTenhang()%>">
						</td>
					</tr><%}%>
				</tbody>
				<tfoot>
					<tr>
						<td>Tong tien: <%=g.Tongtien()%></td>
					</tr>
				</tfoot>
			</table>
				<%}%>
			<form method="post" action="xoahet.jsp">
				<input type="submit" class="btn btn-primary" value="Xóa hết">
			</form>
			<form method="post" action="xoa.jsp">
				<input type="submit" class="btn btn-primary" value="Xóa">
			</form>
		</div>
</body>
</html>