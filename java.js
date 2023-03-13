var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");

// Начальные координаты ствола пушки
var startX = 50;
var startY = canvas.height - 50;

// Размеры ствола пушки
var width = 50;
var height = 150;

// Рисуем ствол пушки
context.fillRect(startX, startY, width, height);

// Функция для расчета угла между двумя точками
function getAngle(x1, y1, x2, y2) {
    var dx = x2 - x1;
    var dy = y2 - y1;
    var angle = Math.atan2(dy, dx);
    return angle;
}

// Обрабатываем событие движения мыши
canvas.addEventListener("mousemove", function(event) {
    // Координаты курсора мыши
    var mouseX = event.clientX - canvas.offsetLeft;
    var mouseY = event.clientY - canvas.offsetTop;

    // Угол между левым верхним углом стола пушки и курсором мыши
    var angle = getAngle(startX, startY, mouseX, mouseY);

    // Поворачиваем ствол пушки на расчитанный угол
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.save();
    context.translate(startX + width / 2, startY);
    context.rotate(angle);
    context.fillRect(-width / 2, 0, width, height);
    context.restore();

    // Выводим расчитанный угол в левом верхнем углу экрана
    context.font = "bold 20px Arial";
    context.fillStyle = "black";
    context.fillText("Angle: " + angle.toFixed(2), 20, 40);
});
