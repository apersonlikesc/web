<%@page import="bean.Info"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <style type="text/css">
  textarea{
    width: 100px;
    height: 100px;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>操作公告</header>
    <form action="Gonggao" method="post">
   <div class="searchbyname">
      公告类别:<select name="class">
        <option value ="通知">通知</option>
        <option value ="注意">注意</option>
        <option value ="警告">警告</option>
      </select>
      <input type="submit" value="筛选"> 
      <input type="hidden" name="action" value="search">
      <input type="hidden" name="page" value="1">
    </div>
    </form>
    	<a href="Gonggao?action=all&page=1">所有信息</a>
    <table cellspacing="0">
      <tr>
        <th>公告名称</th>
        <th>公告类型</th>
        <th>发布时间</th>
        <th>公告内容</th>
        <th>删除</th>

      </tr>
 
    
    <%
if(request.getAttribute("gonggaolist")!=null){
ArrayList<Info> list = (ArrayList<Info>)request.getAttribute("gonggaolist");
%><%

for(int i = 0;i<list.size();i++){
	String u ="Gonggao?title="+list.get(i).getTitle()+"&createdate="+list.get(i).getCreatedate()+"&action=rm&page=1";
%>
	<tr>
        <td><textarea><%=list.get(i).getTitle()%></textarea></td>
        <td><%=list.get(i).getInfo_class() %></td>
        <td><%=list.get(i).getCreatedate() %></td>
        <td><textarea><%=list.get(i).getInfo()%></textarea></td>

        <td><a href="<%=u %>">删除</a></td>
      </tr>

<%}} %>
</table>
<%
   if(request.getAttribute("pagelength")!=null &&request.getAttribute("class")==null){
   int length = (Integer)request.getAttribute("pagelength");
   for(int i = 1;i<=length;i++){
	   %>
	   <a href="Gonggao?action=all&page=<%=i %>"><%=i %></a>
	   <% }}else if(request.getAttribute("class")!=null){
		   int length = (Integer)request.getAttribute("pagelength");
		   String a = (String)request.getAttribute("class");
		   for(int i = 1;i<=length;i++){
			   %>
			   <a href="Gonggao?action=search&page=<%=i %>&class=<%=a%>"><%=i %></a>
			   <% 
		   }
		   
	   }%>
   
    <!-- <button class="button">上一页</button>
    <button class="button">下一页</button> -->
    </div>
</body>
</html>
