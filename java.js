// Получаем элементы canvas и angle
const canvas = document.getElementById("canvas");
const angleDiv = document.getElementById("angle");

// Получаем контекст рисования для canvas
const ctx = canvas.getContext("2d");

// Рисуем прямоугольник-ствол пушки
const gunWidth = 50;
const gunHeight = 10;
ctx.fillStyle = "gray";
ctx.fillRect(canvas.width - gunWidth, canvas.height - gunHeight, gunWidth, gunHeight);

// Добавляем обработчик события "mousemove" на элемент canvas
canvas.addEventListener("mousemove", function(event) {
  // Вычисляем координаты курсора мыши внутри canvas
  const rect = canvas.getBoundingClientRect();
  const mouseX = event.clientX - rect.left;
  const mouseY = event.clientY - rect.top;

  // Вычисляем угол между левым верхним углом стола пушки и курсором мыши
  const gunX = canvas.width - gunWidth;
  const gunY = canvas.height - gunHeight;
  const angle = Math.atan2(mouseY - gunY, mouseX - gunX);

  // Поворачиваем canvas на вычисленный угол
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.save();
  ctx.translate(gunX, gunY);
  ctx.rotate(angle);
  ctx.fillStyle = "gray";
  ctx.fillRect(0, -gunHeight/2, gunWidth, gunHeight);
  ctx.restore();

  // Выводим вычисленный угол в элемент angle
  angleDiv.innerHTML = "Angle: " + (angle * 180 / Math.PI).toFixed(2) + " degrees";
});
