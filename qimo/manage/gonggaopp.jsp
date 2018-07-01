<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
        <script src="js/main.js"></script>
        <style type="text/css">
        td:first-child{
          text-align:right;
        }
        </style>
</head>
<body>
  <header></header>

  <div class="pannel">
    <header>新的公告</header>
    <form action="#" method="post">
      <table>
        <tr>
          <td>类别:
          </td>
          <td><select>
            <option value ="1">通知</option>
            <option value ="2">注意</option>
            <option value ="3">警告</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>标题:
          </td>
          <td><input type="text" placeholder="公告名" maxlength="20"/>
          </td>
        </tr>

        <tr>
          <td>公告内容:
          </td>
          <td><textarea maxlength="200" style="height:250px" id="tarea" oninput="lastfontnumber()">
          </textarea><span id="tarea1"></span>
          </td>
        </tr>

      </table>

  <input type="submit" value="提交">
  <input type="reset" value="重置">
  </form>
  </div>
</body>
</html>