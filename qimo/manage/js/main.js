function showop1(){
  $("#op3").fadeOut();
  $("#op2").fadeOut();
  $("#op1").fadeToggle();
}
function showop2(){
  $("#op3").fadeOut();
  $("#op1").fadeOut();
  $("#op2").fadeToggle();
}
function showop3(){
  $("#op1").fadeOut();
  $("#op2").fadeOut();
  $("#op3").fadeToggle();
}
//课程
function lesspp(){
  $("iframe").attr("src","./lespp.html");
}
function chapterpp(){
  window.location.href="./zhangjietianjia.html"; 
}
function chaptercc(){
  $("iframe").attr("src","./zhangjiecaozuo.html");
}
function lessall(){
  $("iframe").attr("src","./lesall.html");
}
//学生
function stdpp(){
  $("iframe").attr("src","./stdpp.html");
}
function stdmm(){
  $("iframe").attr("src","./stdmm.html");
}
function stdcc(){
  $("iframe").attr("src","./stdcc.html");
}
function stdall(){
  $("iframe").attr("src","./stdall.html");
}
//公告
function ggpp(){
  $("iframe").attr("src","./gonggaopp.html");
}
function ggmm(){
  $("iframe").attr("src","./gonggaomm.html");
}
function ggall(){
  $("iframe").attr("src","./gonggaoall.html");
}
//验证 原生js
function valideText() {
    var a = document.getElementById("txt");
    if(a.value.length > 10){
        document.getElementById("txt1").innerText = "x 长度过长";
        a.focus();
    }else{
        document.getElementById("txt1").innerText = "";
    }
}

function validetel(){
    var reg = new RegExp("^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}$");
    var tel = document.getElementById("tel");
    if(!reg.test(tel.value)&& tel.value!="")
    {
        document.getElementById("tel1").innerText = "x 格式不匹配";
        tel.focus();
    }else{
        document.getElementById("tel1").innerText = "";
    }
}
function validemail(){

    var reg = new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    var mail = document.getElementById("mail");
    if(!reg.test(mail.value) && mail.value!="") {
        document.getElementById("mail1").innerText = "x 格式不匹配";
        mail.focus();
    }else{
        document.getElementById("mail1").innerText = "";
    }
}
function lastfontnumber() {
    var a = document.getElementById("tarea");
    var last=200-a.value.length;
    if(last!=200){
      document.getElementById("tarea1").innerText = "剩余可输入字符:"+String(200-a.value.length);
    }else{
      document.getElementById("tarea1").innerText = "";
    }

}
