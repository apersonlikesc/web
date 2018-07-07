
<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
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
    <%Student std = (Student)request.getAttribute("onestudent"); %>
  <div id="heada"><img src=<%=std.getHead()%>><button onclick="showhead()">预览头像</button></div>
  <div class="pannel">
    <header>修改学生信息</header>
    <form action="Ss" method="post">
      <table>
      <tr>
          <td>用户名称:
          </td>
          <td>  <div><%=std.getUsername() %></div>
          </td>
        </tr>
        <tr>
          <td>学历:
          </td>
          <td><select name="education">
                <option value ="大专" <%if(std.getEducation().equals("大专")){%>selected<%} %>>大专</option>
                <option value ="本科"   <%if(std.getEducation().equals("本科")){%>selected<%} %>>本科</option>
                <option value="研究生"  <%if(std.getEducation().equals("研究生")){%>selected<%} %>>研究生</option>
                <option value="博士生"  <%if(std.getEducation().equals("博士生")){%>selected<%} %>>博士生</option>
              </select>
          </td>
        </tr>
        <tr>
          <td>性别:
          </td>
          <td><select name="sex">
                <option value ="男"  <%if(std.getEducation().equals("男")){%>selected<%} %>>男</option>
                <option value ="女" <%if(std.getEducation().equals("女")){%>selected<%} %>>女</option>
              </select>
          </td>
        </tr>
        <tr>
          <td>年龄:
          </td>
          <td><input type="number" name="age" min="15" max="60" step="1" value="<%=std.getAge() %>" />
          </td>
        </tr>
        <tr>
          <td>目前职称:
          </td>
          <td><input type="text" name="title" value="<%=std.getTitle()%>" <%=std.getTitle()%>/>
          </td>
        </tr>
        <tr>
          <td>真实姓名:
          </td>
          <td><input type="text"name="realname" value=<%=std.getRealname()%>  palceholder="<%=std.getRealname() %>" />
          </td>
        </tr>
        
        <tr>
          <td>密码:
          </td>
          <td>  <input type="text"  name="password" value=<%=std.getPassword() %> palceholder="<%=std.getPassword()%>"/>
          </td>
        </tr>
        <tr>
          <td>邮箱号:
          </td>
          <td><input type="text" id="mail" name="email" onblur="validemail()" value=<%=std.getEmail()%> palceholder="<%=std.getEmail() %>"/><span id="mail1"></span>
          </td>
        </tr>
        <tr>
          <td>手机号:
          </td>
          <td><input type="text" id="tel" onblur="validetel()" name="tel" value=<%=std.getTel() %> palceholder="<%=std.getTel() %>"/><span id="tel1">
          </td>
        </tr>
        <tr>
          <td>个人简介:
          </td>
          <td><textarea maxlength="200" id="tarea" oninput="lastfontnumber()" name="stdinfo"><%=std.getStdinfo() %></textarea><span id="tarea1">
          </td>
        </tr>
        <tr>
          <td>头像文件:
          </td>
          <td><input type="file" id="head" onchange="getheadurl()">
          </td>
        </tr>
</table>
<input type="hidden" name="action" value="change2">
<input type="hidden" name="head" id="head1" value=<%=std.getHead()%>/>
<input type="hidden" name="username" value=<%=std.getUsername()%>>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>
  </div>
</body>
</html>
