package Lev06.task0609;

/* 
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра.


Требования:
1. Метод getDistance должен возвращать double.
2. Метод getDistance должен быть статическим.
3. Метод getDistance должен быть public.
4. Метод getDistance должен возвращать расстояние между точками.
5. Метод getDistance должен использовать метод double Math.sqrt(double a).
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double lenght = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));//напишите тут ваш код
    return lenght;
    }

    public static void main(String[] args) {

    }
}