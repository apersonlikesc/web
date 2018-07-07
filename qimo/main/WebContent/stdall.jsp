<%request.setCharacterEncoding("UTF-8"); %>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
</head>
<body>

  <div class="pannel">
    <header>查看老师信息</header>
    <form action="Teacher1" method="post">
   <div class="searchbynum">
      真实姓名:<input type="text" maxlength="20" style="width:100px;" name="name"/>
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
    <a href="Teacher1?action=all&page=1">所有信息</a>
    <table cellspacing="0">
      <tr>
        <th>真实姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>手机号</th>
        <th>邮箱号</th>
        
      </tr>
     <%
     request.setCharacterEncoding("utf-8");
if(request.getAttribute("loglist")!=null){
ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("loglist");
%><%

for(int i = 0;i<list.size();i++){
%>
	<tr>
        <td><%=list.get(i).getName() %></td>
        <td><%=list.get(i).getAge() %></td>
        <td><%=list.get(i).getSex()%></td>
        <td><%=list.get(i).getTel()%></td>
        <td><%=list.get(i).getEmail()%></td>
  <td>
      </tr>
	
<%}} %>
    </table>
    <%
   if(request.getAttribute("pagelength")!=null&& request.getAttribute("sex")==null){
   int length = (Integer)request.getAttribute("pagelength");
   for(int i = 1;i<=length;i++){
	   %>
	   <a href="Teacher1?action=all&page=<%=i %>"><%=i %></a>
	   <% }}else if(request.getAttribute("sex")!=null){
		   int length = (Integer)request.getAttribute("pagelength");
		   String b = (String)request.getAttribute("sex");
		   if(request.getAttribute("name")==null){
		   for(int i = 1;i<=length;i++){
			   %>
			   <a href="Teacher1?action=search&name=&page=<%=i %>&sex="<%=b %>""><%=i %></a>
			   <% 
		   }}
		   
	   }%>
   <!--  <button class="button">上一页</button>
    <button class="button">下一页</button> -->
    </div>
</body>
</html>
