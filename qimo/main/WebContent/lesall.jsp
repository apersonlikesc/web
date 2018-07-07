<%request.setCharacterEncoding("UTF-8"); %>
<%@page import="bean.Lesson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js"></script>
  <style type="text/css">
  textarea{
    width:100px;	
    height:50px;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>所有课程</header>
   <form action="Lesson1" method="post">
   <div class="searchbyname">
      课程名字:<input type="text" maxlength="20" name="lessonname"/>
    </div>
    <div class="searchbyname">
      课程类别:
      <select name="class">
        <option value ="python">Python</option>
        <option value ="java">Java</option>
        <option value="html">html</option>
        <option value="sql">sql</option>
      </select>
  		<input type="submit" value="筛选">
  		<input type="hidden" name="page" value="1">
  		<input type="hidden" name="action" value="search">
    </div>
    </form>
      <a href="Lesson1?action=all&page=1">所有信息</a>
    <table >
      <tr>
        <th>课程编号</th>
        <th>课程类型</th>
        <th>课程名称</th>
        <th>课程简介</th>
        <th>开课时间</th>
        <th>结束时间</th>
        <th>授课老师编号</th>
        <th>删除</th>
        <th>修改</th>
       <!--  <th>添加章节</th> -->
      </tr>
  <%
  request.setCharacterEncoding("utf-8");
if(request.getAttribute("loglist")!=null){
	ArrayList<Lesson> list = (ArrayList<Lesson>)request.getAttribute("loglist");
%>
<%

for(int i =0;i<list.size();i++){
	String u ="Lesson1?lessonnum="+list.get(i).getLessonnum()+"&action=rm&page=1";
	String n ="Lesson1?lessonnum="+list.get(i).getLessonnum()+"&action=change";
%>
	<tr>
				   <td><%=list.get(i).getLessonnum() %></td>
        <td><%=list.get(i).getLessonclass() %></td>
        <td><%=list.get(i).getLessonname()%></td>
        <td><textarea><%=list.get(i).getLessinfo()%></textarea></td>
        <td><%=list.get(i).getLessbg()%></td>
        <td><%=list.get(i).getLessend()%></td>
         <td><%=list.get(i).getTeacher()%></td>
         <td><a href="<%=u %>">删除</a></td>
  					<td><a href="<%=n %>">修改</a></td>  
      </tr>
<%}} %>
    </table>
   <%
   if(request.getAttribute("pagelength")!=null && request.getAttribute("class")==null){
   int length = (Integer)request.getAttribute("pagelength");
   for(int i = 1;i<=length;i++){
	   %>
	   <a href="Lesson1?action=all&page=<%=i %>"><%=i %></a>
	   <% }}else if(request.getAttribute("class")!=null){
		   String a = (String)request.getAttribute("class");
		   int length = (Integer)request.getAttribute("pagelength");
		   if(request.getAttribute("lessonname")==null){
		   for(int i = 1;i<=length;i++){
			   %>
			   <a href="Lesson1?action=search&lessonname=&page=<%=i %>&class=<%=a%>"><%=i %></a>
			   <% }}
	   }%>
    </div>
</body>
</html>
