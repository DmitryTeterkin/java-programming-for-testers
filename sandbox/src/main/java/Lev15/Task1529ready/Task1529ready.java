package Lev15.Task1529ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane", то считать второй параметр типа int(количество пассажиров), статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().


Требования:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
2. Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован метод public static void reset().
5. Метод reset должен считывать строки с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset.
 */
public class Task1529ready {
  public static void main(String[] args) {

  }

  static {
    try {
      reset(); //add your code here - добавьте код тут
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    public static void reset() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //add your code here - добавьте код тут
    String s = reader.readLine();
    if (s.equals("helicopter")) {
      result = new Helicopter();
      System.out.println(result);
    } else if (s.equals("plane")){
      String num = reader.readLine();
      result = new Plane(Integer.parseInt(num));
      System.out.println(result);
    }
    reader.close();
  }

  public static Flyable result;
}
