package workbook.firstExercise;

public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World");


    hello("world");
    hello("user");
    hello("Dima");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {

    System.out.println("hello, " + somebody + "!");
  }

}
