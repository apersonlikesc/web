
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
    <script src="js/main.js"></script>
  <style type="text/css">
  textarea{
    width:100px;
    height:50px;
  }
  </style>
</head>
<body>

  <div class="pannel">
    <header>所有课程</header>
    <div class="searchbyname">
      课程名字:<input type="text" maxlength="20"/>
    </div>
    <div class="searchbyname">
      课程类别:
      <select>
        <option value ="python">Python</option>
        <option value ="java">Java</option>
        <option value="html">html</option>
        <option value="sql">sql</option>
      </select>
    </div>
    <button class="button">筛选</button>
    <table >
      <tr>
        <th>课程编号</th>
        <th>课程类型</th>
        <th>课程名称</th>
        <th>课程简介</th>
        <th>开课时间</th>
        <th>结束时间</th>
        <th>报名时间</th>
        <th>授课老师</th>
        <th>授课地点</th>

        <th>修改</th>
        <th>删除</th>
        <th>添加章节</th>
      </tr>
      <tr>
        <td>51233</td>
        <td>python</td>
        <td>Python入门</td>
        <td><textarea>你好,这是课程入门的属于说明</textarea></td>
        <td>1952.1.2</td>
        <td>1222.1.1</td>
        <td>1666.1.1</td>
        <td>张六</td>
        <td>寝室</td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
        <td><a href="#" onclick="chapterpp()">添加</a></td>
      </tr>
      <tr>
        <td>51233</td>
        <td>python</td>
        <td>Python入门</td>
        <td><textarea>你好,这是课程入门的属于说明</textarea></td>
        <td>1952.1.2</td>
        <td>1222.1.1</td>
        <td>1666.1.1</td>
        <td>张六</td>
        <td>寝室</td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
        <td><a href="#">添加</a></td>
      </tr>
      <tr>
        <td>51233</td>
        <td>python</td>
        <td>Python入门</td>
        <td><textarea>你好,这是课程入门的属于说明</textarea></td>
        <td>1952.1.2</td>
        <td>1222.1.1</td>
        <td>1666.1.1</td>
        <td>张六</td>
        <td>寝室</td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
        <td><a href="#">添加</a></td>
      </tr>
      <tr>
        <td>51233</td>
        <td>python</td>
        <td>Python入门</td>
        <td><textarea>你好,这是课程入门的属于说明</textarea></td>
        <td>1952.1.2</td>
        <td>1222.1.1</td>
        <td>1666.1.1</td>
        <td>张六</td>
        <td>寝室</td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
        <td><a href="#">添加</a></td>
      </tr>
      <tr>
        <td>51233</td>
        <td>python</td>
        <td>Python入门</td>
        <td><textarea>你好,这是课程入门的属于说明</textarea></td>
        <td>1952.1.2</td>
        <td>1222.1.1</td>
        <td>1666.1.1</td>
        <td>张六</td>
        <td>寝室</td>

        <td><a href="#">修改</a></td>
        <td><a href="#">删除</a></td>
        <td><a href="#">添加</a></td>
      </tr>

    </table>
    <button class="button">上一页</button>
    <button class="button">下一页</button>

    </div>
</body>
</html>