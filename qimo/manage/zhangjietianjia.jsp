<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <style type="text/css">
  td:first-child{
    text-align:right;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>添加章节</header>
    <form action="#" method="post">

    <table>
      <tr>
        <td>
          课程类别:
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
    <td>章节名称:</td>
    <td><input type="text" maxlength="20"/></td>
    </tr>
    <tr>
    <td>资源地址:</td>
    <td><input type="file"/></td>
    </tr>
    <tr>
    <td>属于:</td>
    <td>第<input type="number" step="1" style="width:100px;" max="20" min="1"/>部分</td>
    </tr>

    </table>
      <input type="submit" value="提交">
      <input type="reset" value="重置">
      </form>

    </div>
</body>
</html>
