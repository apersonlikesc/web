var WINDOW_WIDTH = document.documentElement.clientWidth;
var WINDOW_HEIGHT = document.documentElement.clientHeight;
var MARGIN_LEFT = Math.round(WINDOW_WIDTH / 10);
var MARGIN_TOP = Math.round(WINDOW_HEIGHT / 5);
var RADIUS = Math.round(WINDOW_WIDTH * 4 / 5 / 108) - 1;
var balls = [];
const colors = ["#51F511", "#66FAD5", "#EF1C3E", "#FFFA5F", "#DE48CD", "#310CF2"];

window.onload = function () {

    
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext("2d");

    canvas.width = WINDOW_WIDTH;
    canvas.height = WINDOW_HEIGHT;
    curShowTimeSeconds = new Date();
    setInterval(
        function () {
            render(context);
            update();
        }, 50);
}

function render( cxt ){
    cxt.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    
    var hours = curShowTimeSeconds.getHours();
    var minutes = curShowTimeSeconds.getMinutes();
    var seconds = curShowTimeSeconds.getSeconds();
    
    renderDigit( MARGIN_LEFT , MARGIN_TOP ,parseInt(hours/10) , cxt )
    renderDigit(MARGIN_LEFT + 15 * (RADIUS + 1), MARGIN_TOP, parseInt(hours % 10), cxt)
    renderDigit(MARGIN_LEFT + 30 * (RADIUS + 1), MARGIN_TOP, parseInt(10), cxt)
    renderDigit(MARGIN_LEFT + 39 * (RADIUS + 1), MARGIN_TOP, parseInt(minutes / 10), cxt);
    renderDigit(MARGIN_LEFT + 54 * (RADIUS + 1), MARGIN_TOP, parseInt(minutes % 10), cxt);
    renderDigit(MARGIN_LEFT + 69 * (RADIUS + 1), MARGIN_TOP, parseInt(10), cxt);
    renderDigit(MARGIN_LEFT + 78 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds / 10), cxt);
    renderDigit(MARGIN_LEFT + 93 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds % 10), cxt);
    for (var i = 0; i < balls.length; i++) {
        cxt.fillStyle = balls[i].color;
        cxt.beginPath();
        cxt.arc(balls[i].x, balls[i].y, RADIUS, 0, 2 * Math.PI, true);
        cxt.closePath();
        cxt.fill();
    }
}

function renderDigit(x, y, num, cxt) {
    cxt.fillStyle = "rgb(0,102,153)";
    for (var i = 0; i < digit[num].length; i++)
        for (var j = 0; j < digit[num][i].length; j++)
            if (digit[num][i][j] == 1) {
                cxt.beginPath()
                cxt.arc(x + (RADIUS + 1) + j * 2 * (RADIUS + 1), y + (RADIUS + 1) + i * 2 * (RADIUS + 1), RADIUS, 0, 2 * Math.PI);
                cxt.closePath();
                cxt.fill();
            }
}

function update() {
    var ShowTimeSeconds = new Date();
    var curhours = curShowTimeSeconds.getHours();
    var curminutes = curShowTimeSeconds.getMinutes();
    var curseconds = curShowTimeSeconds.getSeconds();

    var hours = ShowTimeSeconds.getHours();
    var minutes = ShowTimeSeconds.getMinutes();
    var seconds = ShowTimeSeconds.getSeconds();
    if(curShowTimeSeconds.getMilliseconds() != ShowTimeSeconds.getMilliseconds())
    {
        if (parseInt(curhours / 10) != parseInt(hours / 10)) {
            addballs(MARGIN_LEFT, MARGIN_TOP, parseInt(hours / 10));
        }
        if (parseInt(curhours % 10 )!= parseInt(hours % 10)) {
            addballs(MARGIN_LEFT + 15 * (RADIUS + 1), MARGIN_TOP, parseInt(hours % 10));
        }
        if (parseInt(curminutes / 10) != parseInt(minutes / 10)) {
            addballs(MARGIN_LEFT + 39 * (RADIUS + 1), MARGIN_TOP, parseInt(minutes / 10));
        }
        if (parseInt(curminutes % 10) != parseInt(minutes % 10)) {
            addballs(MARGIN_LEFT + 54 * (RADIUS + 1), MARGIN_TOP, parseInt(minutes % 10));
        }
        if (parseInt(curseconds / 10 )!= parseInt(seconds / 10)) {
            addballs(MARGIN_LEFT + 78 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds / 10));
        }
        if (parseInt(curseconds % 10) != parseInt(seconds % 10)) {
            addballs(MARGIN_LEFT + 93 * (RADIUS + 1), MARGIN_TOP, parseInt(seconds % 10));
        }
        curShowTimeSeconds = ShowTimeSeconds;
        
        updateBalls();
        
    } 
}

function updateBalls() {
   
    for (var i = 0; i < balls.length; i++) {
        balls[i].x += balls[i].vx;
        balls[i].y += balls[i].vy;
        balls[i].vy += balls[i].g;
        if (balls[i].y > WINDOW_HEIGHT - RADIUS) {
            balls[i].y = WINDOW_HEIGHT - RADIUS;
            balls[i].vy = -balls[i].vy * 0.6;
        }
    }
    var ballscount = 0;

    for (i = 0; i < balls.length; i++) {
        if (balls[i].x + RADIUS > 0 && balls[i].x - RADIUS < WINDOW_WIDTH) {
            balls[ballscount++] = balls[i]
        }
    }

    while (balls.length > Math.min(ballscount, 300)) {
        balls.pop();
    }
    
}
function addballs(x, y, num) {
    for (var i = 0; i < digit[num].length; i++)
        for (var j = 0; j < digit[num][i].length; j++)
            if (digit[num][i][j] == 1) {
                var newball = {
                    x: x + (RADIUS + 1) + j * 2 * (RADIUS + 1),
                    y: y + (RADIUS + 1) + i * 2 * (RADIUS + 1),
                    g: 1.5 + (Math.random()),
                    vx: Math.pow(-1, Math.floor(Math.random() * 100)) * 5,
                    vy: -Math.ceil(Math.random() * 10),
                    color: colors[Math.floor(Math.random() * colors.length)]
                }
                balls.push(newball);
            }
}