<%request.setCharacterEncoding("UTF-8"); %>
<%@page import="bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <style type="text/css">
  textarea{
    width:100px;
    height:50px;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>操作学生信息</header>
    <form action="Ss" method="post">
    <div class="searchbynum">
      用户名:<input type="text" maxlength="20" style="width:100px;" name="username"/>
    </div>
    <div class="searchbyname" maxlength="20">
      性别:<select name="sex">
            <option value ="男">男</option>
            <option value ="女">女</option>
          </select>
    <input type="submit" value="筛选">
    <input type="hidden" name="page" value="1">
    <input type="hidden" name="action" value="search">
    </div>
    </form>
    <a href="Ss?action=all&page=1">所有信息</a>
    <table cellspacing="0">
    <tr>
			<th>用户名</th>
			<th>密码</th>
			<th>真名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>电话</th>
			<th>邮箱</th>
			<th>职称</th>
			<th>学历</th>
			<th>个性签名</th>
			<th>删除</th>
			<th>修改</th>
			</tr>
<%request.setCharacterEncoding("utf-8");
if(request.getAttribute("studentlist")!=null){
ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("studentlist");
%><%

for(int i = 0;i<list.size();i++){
	String u ="Ss?username="+list.get(i).getUsername()+"&action=rm&page=1";
	String n ="Ss?username="+list.get(i).getUsername()+"&action=change";
%>
	<tr>
        <td><%=list.get(i).getUsername() %></td>
        <td><%=list.get(i).getPassword() %></td>
        <td><%=list.get(i).getRealname() %></td>
        <td><%=list.get(i).getAge() %></td>
        <td><%=list.get(i).getSex() %></td>
        <td><%=list.get(i).getTel() %></td>
        <td><%=list.get(i).getEmail() %></td>
        <td><%=list.get(i).getTitle() %></td>
        <td><%=list.get(i).getEducation()%></td>
        <td><textarea><%=list.get(i).getStdinfo() %></textarea></td>

        <td><a href="<%=u %>">删除</a></td>
        <td><a href="<%=n %>">修改</a></td>
      </tr>

<%}} %>
</table>
  <%
   if(request.getAttribute("pagelength")!=null&&request.getAttribute("sex")==null){
   int length = (Integer)request.getAttribute("pagelength");
   for(int i = 1;i<=length;i++){
	   %>
	   <a href="Ss?action=all&page=<%=i %>"><%=i %></a>
	   <% }}else if(request.getAttribute("sex")!=null){
		   int length = (Integer)request.getAttribute("pagelength");
		   String b = (String)request.getAttribute("sex");
		   if(request.getAttribute("username")==null){
		   for(int i = 1;i<=length;i++){
			   %>
			   <a href="Ss?action=search&sex=<%=b%>&username=&page=<%=i %>"><%=i %></a>
			   <%}}
	   }%>
    </div> 
</body>
</html>
