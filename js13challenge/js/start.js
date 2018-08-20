window.blur();

var issame = true;//signal the color of the word and background
var luckcynumber1 = 0;
var luckcynumber2 = 0;
var luckcynumber3 = 0;
// =============================================
//  colors and words //you can also update them
// =============================================
var colors = new Array();
colors[0] = 'red';
colors[1] = 'orange';
colors[2] = 'yellow';
colors[3] = 'blue';
colors[4] = 'purple';
colors[5] = 'pink';
colors[6] = 'grey';
var words = new Array();
words[0] = 'red';
words[1] = 'orange';
words[2] = 'yellow';
words[3] = 'blue';
words[4] = 'purple';
words[5] = 'pink';
words[6] = 'grey';
var level = 1;
changecolor();//init color;

// =============================================
// start function
// =============================================
function a(){
kontra.init();
// =============================================
//  background object
// =============================================
  var background = kontra.sprite({
    x: 0,
    y: 0,
    color: 'black',
    width: kontra.canvas.width,
    height: kontra.canvas.height,
  });
// =============================================
//  level max=3
// =============================================

var max = 0;
var time = 2;
// =============================================
//  score max=200 then 0 level up
// =============================================
var score = 0;
  document.onkeyup=function(e){
    if(kontra.keys.pressed('left') && !issame) {//judge the color
      changecolor();
      score +=10;
      if(score > max){
        max = score;
      }
      // if(score > 50){
      //   level = 2;
      //   background.color = colors[luckcynumber3];
      // }else if(score <= 50 && score >=0){
      //   level = 1;
      //   background.color = 'black';
      // }
      time = 2;
    }else if (kontra.keys.pressed('right') && issame) {//judge the color
      changecolor();
      score +=10;
      time = 2;
      if(score > max){
        max = score;
      }
      // if(score > 50){
      //   level = 2;
      //   background.color = colors[luckcynumber3];
      // }else if(score <= 50 && score >=0){
      //   level = 1;
      //   background.color = 'black';
      // }
    }else{
      score = 0;
    }
  }
// =============================================
//  gameLoop
// =============================================
  var loop = kontra.gameLoop({
    update:function(){
      if(time>0){
        time -=0.01;
      }else{
        time = 2;
        score = 0;
        changecolor();

      }
      if(score > 50){
        level = 2;
        background.color = colors[luckcynumber3];
      }else if(score <= 50 && score >=0){
        level = 1;
        background.color = 'black';
      }
    },
    render:function(){
      background.render();
      drawText(words[luckcynumber2],15,colors[luckcynumber1]);
      drawscore("score:"+score+"  max:"+max+"  level:"+level);
      drawtime("time:"+time);
    }
  });
  loop.start(); //start
}


// =============================================
// level 1 changecolor
// =============================================
function changecolor(){
  if(level == 1){
    luckcynumber1 = Math.floor(Math.random()*colors.length);
    luckcynumber2 = Math.floor(Math.random()*words.length);
    if (luckcynumber1 == luckcynumber2){ // judge the color of the word and the background
      issame = true;
    }else{
      issame = false;
    }
  }else if(level == 2){
     luckcynumber1 = Math.floor(Math.random()*colors.length);
     luckcynumber2 = Math.floor(Math.random()*words.length);
     luckcynumber3 = Math.floor(Math.random()*colors.length);
      if(luckcynumber3 == luckcynumber1){
        luckcynumber3 = (luckcynumber3+1) % colors.length;
      }
      if (luckcynumber1 == luckcynumber2){ // judge the color of the word and the background
        issame = true;
      }else{
        issame = false;
      }
  }
}

// =============================================
// level 2 changecolor
// =============================================

// function changecolor2(colors){
//   var luckcynumber1 = Math.floor(Math.random()*colors.length);
//   var luckcynumber2 = Math.floor(Math.random()*colors.length);
//   if (luckcynumber1 == luckcynumber2){ // judge the color of the word and the background
//     issame = true;
//   }else{
//     issame = false;
//   }
//   var wordcolor = colors[luckcynumber1];
//   var bgcolor = colors[luckcynumber2];
// }


// =============================================
// function to draw words
// =============================================
function drawText(string,size,color) {
    var needed = [];
    if (string) {
        string = string.toUpperCase();
        for (var i = 0; i < string.length; i++) {
            var letter = letters[string.charAt(i)];
            if (letter) {
                needed.push(letter);
            }
          }
        var currX =kontra.canvas.width/2-(string.length*2)*size;
        kontra.context.fillStyle = color;
        for (i = 0; i < needed.length; i++) {
            letter = needed[i];
            var currY = kontra.canvas.height/2 -3*size;
            var addX = 0;
            for (var y = 0; y < letter.length; y++) {
                var row = letter[y];
                for (var x = 0; x < row.length; x++) {
                    if (row[x]) {
                        kontra.context.fillRect(currX + x * size , currY , size, size);
                    }
                }
                addX = Math.max(addX, row.length * size);
                currY += size;
            }
            currX += size + addX;
          }
    }
}
function drawscore(string,x,y){
  var size = 5;
  var needed = [];
  if (string) {
      string = string.toUpperCase();
      for (var i = 0; i < string.length; i++) {
          var letter = letters[string.charAt(i)];
          if (letter) {
              needed.push(letter);
          }
        }
      var currX =5;
      kontra.context.fillStyle = 'white';
      for (i = 0; i < needed.length; i++) {
          letter = needed[i];
          var currY = 5;
          var addX = 0;
          for (var y = 0; y < letter.length; y++) {
              var row = letter[y];
              for (var x = 0; x < row.length; x++) {
                  if (row[x]) {
                      kontra.context.fillRect(currX + x * size , currY , size, size);
                  }
              }
              addX = Math.max(addX, row.length * size);
              currY += size;
          }
          currX += size + addX;
        }
  }
}
function drawtime(string){
  var size = 5;
  var needed = [];
  if (string) {
      string = string.toUpperCase();
      for (var i = 0; i < string.length; i++) {
          var letter = letters[string.charAt(i)];
          if (letter) {
              needed.push(letter);
          }
        }
      var currX =5;
      kontra.context.fillStyle = 'white';
      for (i = 0; i < needed.length; i++) {
          letter = needed[i];
          var currY = kontra.canvas.height - 30;
          var addX = 0;
          for (var y = 0; y < letter.length; y++) {
              var row = letter[y];
              for (var x = 0; x < row.length; x++) {
                  if (row[x]) {
                      kontra.context.fillRect(currX + x * size , currY , size, size);
                  }
              }
              addX = Math.max(addX, row.length * size);
              currY += size;
          }
          currX += size + addX;
        }
  }
}


// =============================================
// Pixel Font
// =============================================
var letters = {
    'A': [
        [, 1],
        [1, , 1],
        [1, , 1],
        [1, 1, 1],
        [1, , 1]
    ],
    'B': [
        [1, 1],
        [1, , 1],
        [1, 1, 1],
        [1, , 1],
        [1, 1]
    ],
    'C': [
        [1, 1, 1],
        [1],
        [1],
        [1],
        [1, 1, 1]
    ],
    'D': [
        [1, 1],
        [1, , 1],
        [1, , 1],
        [1, , 1],
        [1, 1]
    ],
    'E': [
        [1, 1, 1],
        [1],
        [1, 1, 1],
        [1],
        [1, 1, 1]
    ],
    'F': [
        [1, 1, 1],
        [1],
        [1, 1],
        [1],
        [1]
    ],
    'G': [
        [, 1, 1],
        [1],
        [1, , 1, 1],
        [1, , , 1],
        [, 1, 1]
    ],
    'H': [
        [1, , 1],
        [1, , 1],
        [1, 1, 1],
        [1, , 1],
        [1, , 1]
    ],
    'I': [
        [1, 1, 1],
        [, 1],
        [, 1],
        [, 1],
        [1, 1, 1]
    ],
    'J': [
        [1, 1, 1],
        [, , 1],
        [, , 1],
        [1, , 1],
        [1, 1, 1]
    ],
    'K': [
        [1, , , 1],
        [1, , 1],
        [1, 1],
        [1, , 1],
        [1, , , 1]
    ],
    'L': [
        [1],
        [1],
        [1],
        [1],
        [1, 1, 1]
    ],
    'M': [
        [1, 1, 1, 1, 1],
        [1, , 1, , 1],
        [1, , 1, , 1],
        [1, , , , 1],
        [1, , , , 1]
    ],
    'N': [
        [1, , , 1],
        [1, 1, , 1],
        [1, , 1, 1],
        [1, , , 1],
        [1, , , 1]
    ],
    'O': [
        [1, 1, 1],
        [1, , 1],
        [1, , 1],
        [1, , 1],
        [1, 1, 1]
    ],
    'P': [
        [1, 1, 1],
        [1, , 1],
        [1, 1, 1],
        [1],
        [1]
    ],
    'Q': [
        [, 1, 1],
        [1, , , 1],
        [1, , , 1],
        [1, , 1, 1],
        [1, 1, 1, 1]
    ],
    'R': [
        [1, 1],
        [1, , 1],
        [1, , 1],
        [1, 1],
        [1, , 1]
    ],
    'S': [
        [1, 1, 1],
        [1],
        [1, 1, 1],
        [, , 1],
        [1, 1, 1]
    ],
    'T': [
        [1, 1, 1],
        [, 1],
        [, 1],
        [, 1],
        [, 1]
    ],
    'U': [
        [1, , 1],
        [1, , 1],
        [1, , 1],
        [1, , 1],
        [1, 1, 1]
    ],
    'V': [
        [1, , , , 1],
        [1, , , , 1],
        [, 1, , 1],
        [, 1, , 1],
        [, , 1]
    ],
    'W': [
        [1, , , , 1],
        [1, , , , 1],
        [1, , , , 1],
        [1, , 1, , 1],
        [1, 1, 1, 1, 1]
    ],
    'X': [
        [1, , , , 1],
        [, 1, , 1],
        [, , 1],
        [, 1, , 1],
        [1, , , , 1]
    ],
    'Y': [
        [1, , 1],
        [1, , 1],
        [, 1],
        [, 1],
        [, 1]
    ],
    'Z': [
        [1, 1, 1, 1, 1],
        [, , , 1],
        [, , 1],
        [, 1],
        [1, 1, 1, 1, 1]
    ],
    ':': [
        [, , ],
        [1, , ],
        [, , , ],
        [1, , ],
        [, , ]
    ],
    '0': [
        [1, 1, 1],
        [1, , 1],
        [1, , 1],
        [1, , 1],
        [1, 1, 1]
    ],
    '1': [
        [, 1],
        [, 1],
        [, 1],
        [, 1],
        [, 1]
    ],
    '2': [
        [1, 1, 1],
        [, , 1],
        [1, 1, 1],
        [1, , ],
        [1, 1, 1]
    ],
    '3': [
        [1, 1, 1],
        [, , 1],
        [1, 1, 1],
        [, , 1],
        [1, 1, 1]
    ],
    '4': [
        [1, , 1],
        [1, , 1],
        [1, 1, 1],
        [, , 1],
        [, , 1]
    ],
    '5': [
        [1, 1, 1],
        [1, , ],
        [1, 1, 1],
        [, , 1],
        [1, 1, 1]
    ],
    '6': [
        [1, 1, 1],
        [1, , ],
        [1, 1, 1],
        [1, , 1],
        [1, 1, 1]
    ],
    '7': [
        [1, 1, 1],
        [, , 1],
        [, , 1],
        [, , 1],
        [, , 1]
    ],
    '8': [
        [1, 1, 1],
        [1, , 1],
        [1, 1, 1],
        [1, , 1],
        [1, 1, 1]
    ],
    '9': [
        [1, 1, 1],
        [1, , 1],
        [1, 1, 1],
        [, , 1],
        [1, 1, 1]
    ],
    ' ': [
        [, , ],
        [, , ],
        [, , ],
        [, , ],
        [, , ]
    ],
    '.': [
        [, , ],
        [, , ],
        [, , ],
        [, , ],
        [,1, ]
    ],
};
