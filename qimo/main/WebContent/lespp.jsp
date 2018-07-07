<%request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/main.js"></script>
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
    <header>新的课程</header>
    <div id="heada"><img><button onclick="showhead()">预览封面</button></div>
<form action="Lesson1" method="post">
<table>
  <tr>
  <td>
    课程分类:
  </td>
<td>
  <select name="lessonclass">
  <option value ="python">Python</option>
  <option value ="java">Java</option>
  <option value="html">html</option>
  <option value="sql">sql</option>
</select>
</td>
</tr>
<tr>
<td>封面:
</td>
<td><input type="file" style="margin-left:0;"  id="head" onchange="getheadurl()"/></td>
</tr>
<tr>
<td>开课时间:</td>
<td><input type="date" name="lessonbg" /></td>
</tr>
<tr>
<td>结束时间:</td>
<td><input type="date" name="lessonend" /></td>
</tr>

<tr>
<td>课程名称:</td>
<td><input type="text" maxlength="20" name="lessonname"/></td>
</tr>
<tr>
<td>课程老师编号:</td>
<td><input type="text" maxlength="20" name="teacher"></td>
</tr>

<tr>
<td>课程简介:</td>
<td><textarea oninput="lastfontnumber()" maxlength="200" id="tarea" name="lessoninfo"></textarea><span id="tarea1"></span></td>
</tr>
</table>
<input type="hidden" name="action" value="add"> 
<input type="hidden" name="head" id="head1" value=""/>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>
  </div>
</body>
</html>
