<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <script src="js/jquery-2.2.3.min.js"></script>
  <link rel="stylesheet" href="css/signin.css">
  <title>登录</title>
  <style type="text/css">
    #inden{
      margin-top:20px;
    }
    #inden *{
      display: inline;
    }
  </style>
</head>
<body>
  <img src="./img/timg.jpeg"/>
  <div class="sign-pannel">
    <header>欢迎登录</header>
    <form action="#" method="post">
    <label>
      用户名:<input type="text" maxlength="20"/>
    </label>
    <label>
    密码:<input type="password"/>
    </label>
    <div id="inden">
      <label>
        <input type="radio" name="identity" value="student" />学生
      </label>
      <label>
        <input type="radio" name="identity" value="admin"/>管理员
      </label>
    </div>
    <input type="submit" value="登录"/>
    <button onclick="xxx">注册</button>
    <form>
  </div>
</body>
</html>
