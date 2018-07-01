
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js"></script>
    <style type="text/css">
    #fengmian{
        width: 200px;
        height: 200px;
        background: blue;
        border: 1px solid black;
        position: absolute;
        margin-left:5%;
        margin-top: 5%;
    }
    td:first-child{
      text-align:right;
    }
    </style>
</head>
<body>
  <div class="pannel">
    <header>新的课程</header>
    <div id="fengmian"></div>
<form action="#" method="post">

<table>
  <tr>
  <td>
    课程分类:
  </td>
<td>
  <select>
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
<td><input type="file" style="margin-left:0;"/></td>
</tr>
<tr>
<td>开课时间:</td>
<td><input type="date"/></td>
</tr>
<tr>
<td>结束时间:</td>
<td><input type="date" /></td>
</tr>
<tr>
<td>报名时间:</td>
<td><input type="date"/></td>
</tr>
<tr>
<td>课程名称:</td>
<td><input type="text" maxlength="20"/></td>
</tr>
<tr>
<td>课程老师:</td>
<td><input type="text" maxlength="20"></td>
</tr>
<tr>
<td>开课地点:</td>
<td><input type="text" maxlength="30"/></td>
</tr>
<tr>
<td>课程简介:</td>
<td><textarea oninput="lastfontnumber()" maxlength="200" id="tarea"></textarea><span id="tarea1"></span></td>
</tr>
</table>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>

  </div>
</body>
</html>
