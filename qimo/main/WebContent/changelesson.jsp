<%@page import="bean.Lesson"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js"></script>
     <script src="js/jquery-2.2.3.min.js"></script>
    <style type="text/css">
    #heada{
          width: 200px;
          height: 230px;
          position: absolute;
          margin-left:5%;
          margin-top: 10%;
          text-align: center;
      }
      #heada img{
        margin-bottom: 10px;
        width: 200px;
        height: 200px;

      }
    td:first-child{
      text-align:right;
    }
    </style>
</head>
<body>
  <div class="pannel">
    <%Lesson lesson = (Lesson)request.getAttribute("onelesson"); %>
    <header>修改课程</header>
     <div id="heada"><img src=<%=lesson.getPic()%>><button onclick="showhead()">预览封面</button></div>
<form action="Lesson1" method="post">
<table>
 <tr>
<td>课程编号:
</td>
<td><div><%=lesson.getLessonnum() %></div></td>
</tr>
  <tr>
  <td>
    课程分类:
  </td>
<td>
  <select name="lessonclass">
  <option value ="python"<%if(lesson.getLessonclass().equals("python")){%>selected<%} %>>Python</option>
  <option value ="java"<%if(lesson.getLessonclass().equals("java")){%>selected<%} %>>Java</option>
  <option value="html"<%if(lesson.getLessonclass().equals("html")){%>selected<%} %>>html</option>
  <option value="sql"<%if(lesson.getLessonclass().equals("sql")){%>selected<%} %>>sql</option>
</select>
</td>
</tr>
<tr>
<td>封面:
</td>
<td><input type="file" style="margin-left:0;" id="head" onchange="getheadurl()"/></td>
</tr>
<tr>
<td>开课时间:</td>
<td><input type="date" name="lessonbg"/><span>先前为<%=lesson.getLessbg()%></span></td>
</tr>
<tr>
<td>结束时间:</td>
<td><input type="date" name="lessonend" /><span>先前为<%=lesson.getLessend()%></span></td>
</tr>

<tr>
<td>课程名称:</td>
<td><input type="text" maxlength="20" name="lessonname" placeholder="<%=lesson.getLessonname() %>" value="<%=lesson.getLessonname() %>"/></td>
</tr>
<tr>
<td>课程老师编号:</td>
<td><input type="text" maxlength="10" name="teacher" placeholder="<%=lesson.getTeacher()%>" value="<%=lesson.getTeacher()%>" ></td>
</tr>

<tr>
<td>课程简介:</td>
<td><textarea oninput="lastfontnumber()" maxlength="200" id="tarea" name="lessoninfo"><%=lesson.getLessinfo() %></textarea><span id="tarea1"></span></td>
</tr>
</table>
<input type="hidden" name="action" value="change2"> 
<input type="hidden" name="lessonnum" value="<%=lesson.getLessonnum() %>">
<input type="hidden" name="head" id="head1" value=<%=lesson.getPic()%>/>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>
  </div>
</body>
</html>
