<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <style type="text/css">
  textarea{
    width:100px;
    height:50px;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>操作学生信息</header>
    <div class="searchbynum">
      真实姓名:<input type="text" maxlength="20" style="width:100px;"/>
    </div>
    <div class="searchbyname" maxlength="20">
      性别:<select>
            <option value ="1">男</option>
            <option value ="2">女</option>
          </select>
    </div>
    <div class="searchbyname" maxlength="20" >
      年龄:<input type="text" style="width:100px;" maxlength="2">
    </div>
    <div class="searchbyname">
      学历:<select>
        <option value ="1">大专</option>
        <option value ="2">本科</option>
        <option value="3">研究生</option>
        <option value="4">博士生</option>
      </select>
    </div>
    <button class="button">筛选</button>
    <table cellspacing="0">
      <tr>
        <th>真实姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>手机号</th>
        <th>邮箱号</th>
        <th>职称</th>
        <th>学历</th>
        <th>个人简介</th>
        <th>修改</th>
        <th>删除</th>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>
      <tr>
        <td>王二儿</td>
        <td>12</td>
        <td>男</td>
        <td>13212254123</td>
        <td>11231@七七.13213</td>
        <td>小工</td>
        <td>中专</td>
        <td><textarea>你好你好你好</textarea></td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
      </tr>

    </table>
    <button class="button">上一页</button>
    <button class="button">下一页</button>
    <button class="button">提交操作</button>
    </div>
</body>
</html>
