<%request.setCharacterEncoding("UTF-8"); %>
<%@page import="bean.Studylog"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
</head>
<body>

  <div class="pannel">
    <header>学习记录</header>
    <form action="Studylog1" method="post">
   <div class="searchbynum">
      用户名:<input type="text" maxlength="20" style="width:100px;" name="username"/>
    <input type="hidden" name="page" value="1">
    <input type="hidden" name="action" value="search">
   <input type="submit" value="筛选">
    </div>
   </form>
   <a href="Studylog1?action=all&page=1">所有信息</a>
   
    <table cellspacing="0">
      <tr>
        <th>用户名</th>
        <th>学习时间</th>
        <th>所学课程编号</th>

      </tr>
   <%
if(request.getAttribute("loglist")!=null){
ArrayList<Studylog> list = (ArrayList<Studylog>)request.getAttribute("loglist");
%><%

for(int i = 0;i<list.size();i++){
%>
	<tr>
        <td><%=list.get(i).getUsername() %></td>
        <td><%=list.get(i).getStudydate() %></td>
        <td><%=list.get(i).getLessonnum()%></td>
  <td>
      </tr>

<%}} %>

    </table>
      <%
   if(request.getAttribute("pagelength")!=null &&request.getAttribute("username")==null){
   int length = (Integer)request.getAttribute("pagelength");
   for(int i = 1;i<=length;i++){
	   %>
	   <a href="Studylog1?action=all&page=<%=i %>"><%=i %></a>
	   <% }}else if(request.getAttribute("username")!=null){
		   int length = (Integer)request.getAttribute("pagelength");
		   String a = (String)request.getAttribute("username");
		   for(int i = 1;i<=length;i++){
			   %>
			   <a href="Studylog1?action=search&page=<%=i %>&username=<%=a%>"><%=i %></a>
			   <% 
		   }   
	   }%>
   
    </div>
</body>
</html>
