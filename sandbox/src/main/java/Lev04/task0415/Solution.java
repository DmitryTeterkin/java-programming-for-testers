package Lev04.task0415;

/* 
Правило треугольника
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt(); //напишите тут ваш код
        int c = scanner.nextInt();

        if ((a+b)>c && (b+c)>a && (a+c)>b){
            System.out.println("Треугольник существует.");
        } else System.out.println("Треугольник не существует.");
    }
}