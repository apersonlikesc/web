<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
      <script src="js/main.js"></script>
      <style type="text/css">
      #head{
          width: 200px;
          height: 200px;
          background: blue;
          border: 1px solid black;
          position: absolute;
          margin-left:5%;
          margin-top: 10%;
      }
      td:first-child{
        text-align:right;
      }
      </style>
</head>
<body>
  <div id="head"></div>
  <div class="pannel">
    <header>新的学生</header>
    <form action="#" method="post">
      <table>
        <tr>
          <td>学历:
          </td>
          <td>  <select>
                <option value ="1">大专</option>
                <option value ="2">本科</option>
                <option value="3">研究生</option>
                <option value="4">博士生</option>
              </select>
          </td>
        </tr>
        <tr>
          <td>性别:
          </td>
          <td>  <select>
                <option value ="1">男</option>
                <option value ="2">女</option>
              </select>
          </td>
        </tr>
        <tr>
          <td>年龄:
          </td>
          <td><input type="number" name="age" min="15" max="60" step="1"/>
          </td>
        </tr>
        <tr>
          <td>目前职称:
          </td>
          <td><input type="text"/>
          </td>
        </tr>
        <tr>
          <td>真实姓名:
          </td>
          <td><input type="text"/>
          </td>
        </tr>
        <tr>
          <td>学生名称:
          </td>
          <td>  <input type="text" maxlength="10" />
          </td>
        </tr>
        <tr>
          <td>邮箱号:
          </td>
          <td><input type="text" id="mail" onblur="validemail()"/><span id="mail1"></span>
          </td>
        </tr>
        <tr>
          <td>手机号:
          </td>
          <td><input type="text" id="tel" onblur="validetel()"/><span id="tel1">
          </td>
        </tr>
        <tr>
          <td>个人简介:
          </td>
          <td><textarea maxlength="200" id="tarea" oninput="lastfontnumber()"></textarea><span id="tarea1">
          </td>
        </tr>
        <tr>
          <td>头像文件:
          </td>
          <td><input type="file">
          </td>
        </tr>
</table>
  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>
  </div>
</body>
</html>