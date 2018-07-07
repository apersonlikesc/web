<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
  <meta charset="UTF-8">
  <title>
    管理端
  </title>
  <link rel="stylesheet" href="css/general.css">
  <script src="js/jquery-2.2.3.min.js"></script>
  <script src="js/main.js"></script>
</head>
<body>
  <div class="nav">
    <header>管理端</header>
    <p>欢迎你,管理员</p>
    <button onclick="showop1()">管理课程</button>
    <button onclick="showop2()">管理信息</button>
    <button onclick="showop3()">管理公告</button>
    <div id="clock"></div>
  </div>
  <div class="options" id="op1">
    <button class="button" onclick="lesspp()">增加课程</button>
    <!--  <button class="button" onclick="chaptercc()">操作章节</button>-->
    <button class="button" onclick="lessall()">操作课程</button>
  </div>
  <div class="options" id="op2">
    <button class="button" onclick="stdpp()">增加学员信息</button>
    <button class="button" onclick="stdmm()">操作学员信息</button>
    <button class="button" onclick="stdcc()">查看学习记录</button>
    <button class="button" onclick="stdall()">查看老师信息</button>
  </div>
  <div class="options" id="op3">
    <button class="button" onclick="ggpp()">增加公告</button>
    <button class="button" onclick="ggmm()">操作公告</button>
  </div>
  <div class="info">
  <iframe id="page">
  </iframe>
  </div>
  <script>
  $(".button").click(function(){
      $(".options").fadeOut();
  });
  setInterval("showtime()",1000);
  function showtime(){
  var D = new Date();
  var t = D.toLocaleDateString()+D.toLocaleTimeString();
  document.getElementById("clock").innerText=t;
  }
  </script>
</body>
</html>
