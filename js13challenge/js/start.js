var issame = false;//signal the color of the word and background
function a(){
// =============================================
// kontra init
// =============================================
  kontra.init();
// =============================================
//  word object
// =============================================
  var word = kontra.sprite({

  });
// =============================================
//  background object
// =============================================
  var background = kontra.sprite({
    x: 0,
    y: 0,
    color: 'blue',
    width: kontra.canvas.width,
    height: kontra.canvas.height,
  });
// =============================================
//  level max=3
// =============================================
  var level = 1;
// =============================================
//  score max=200 then 0 level up
// =============================================
  var score = 0;
// =============================================
//  gameLoop
// =============================================
  var loop = kontra.gameLoop({
    update:function(){

      if (kontra.keys.pressed('left')) {
      
      }
      if (kontra.keys.pressed('right')) {
      //judge
      }
    },
    render:function(){
      background.render();
      //word.render();
    }
  });
// =============================================
//  start
// =============================================
  loop.start();
}
// =============================================
// level 1 changecolor
// =============================================
function changecolor1(colors, words){
  var luckcynumber1 = Math.floor(Math.random()*colors.length);
  var luckcynumber2 = Math.floor(Math.random()*words.length);
  if (luckcynumber1 == luckcynumber2){ // judge the color of the word and the background
    issame = true;
  }else{
    issame = false;
  }

}

// =============================================
// level 2 changecolor
// =============================================

function changecolor2(colors){
  var luckcynumber1 = Math.floor(Math.random()*colors.length);
  var luckcynumber2 = Math.floor(Math.random()*colors.length);
  if (luckcynumber1 == luckcynumber2){ // judge the color of the word and the background
    issame = true;
  }else{
    issame = false;
  }
  var wordcolor = colors[luckcynumber1];
  var bgcolor = colors[luckcynumber2];
}

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
        var currX = 0;
        //kontra.context.fillStyle = color;
        for (i = 0; i < needed.length; i++) {
            letter = needed[i];
            var currY = 0;
            var addX = 0;
            for (var y = 0; y < letter.length; y++) {
                var row = letter[y];
                for (var x = 0; x < row.length; x++) {
                    if (row[x]) {
                        context.fillRect(currX + x * size , currY , size, size);
                    }
                }
                addX = Math.max(addX, row.length * size);
                currY += size;
            }
            currX += size + addX;
    }
    }
}




//I use Pixel Font letters, but I also added some additional letters that I needed
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
};
