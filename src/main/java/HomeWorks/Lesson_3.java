package HomeWorks;

import java.util.Arrays;

public class Lesson_3 {
        public static void main(String[] args) {
            // Задача 1
            System.out.println(checkSumBetween(10, 15));

            // Задача 2
            repeatString("Hello, world!", 5);

            // Задача 3
            PositiveOrNegative(-66);

            // Задача 4
            System.out.println(isPositiveNumber(-115));;

            // Задача 5
            System.out.println(isLeapYear(2040));;

            // Задача 6
            int[] arr = { 1, 0, 1, 1, 0, 1, 0, 0, 1, 1};
            System.out.println(Arrays.toString(arr));

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 1 ? 0 : 1;
            }
            System.out.println(Arrays.toString(arr));

            //Задача 7
            int[] arr100 = new int[100];
            for (int i = 0; i < arr100.length; i++) {
                arr100[i] = i + 1;
            }
            System.out.println(Arrays.toString(arr100));

            //Задача 8
            int[] arr6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            System.out.println(Arrays.toString(arr6));
            for (int i = 0; i < arr6.length; i++) {
               if (arr6[i] < 6) {
                   arr6[i] *= 2;
               };
            }
            System.out.println(Arrays.toString(arr6));

            //Задача 9
            int[][] diagonalArr = new int[5][5];
            for (int i = 0; i < diagonalArr.length; i++){
                for (int j = 0; j < diagonalArr.length; j++) {
                    if (i == j) {
                        diagonalArr[i][j] = 1;
                    }
                    if (j == diagonalArr.length-1-i) {
                        diagonalArr[i][j] = 1;
                    }
                    System.out.print(diagonalArr[i][j] + " ");
                }
                System.out.println();
            }

            //Задача 10
            System.out.println(Arrays.toString(arrayInit(6, 555)));

        }

        //Задача 1
        public static boolean checkSumBetween(int a, int b) {
            return ((a+b)>= 10 && (a+b)<= 20);
        }

        //Задача 2
        public static void  repeatString(String str, int n) {
            for (int i = 0; i < n; i++ ) {
                System.out.println(str);
            }
        }

        //Задача 3
        public static void PositiveOrNegative(int a) {
            System.out.println(a >= 0 ? "Положительное число" : "Отрицательное число");
        }

        //Задача 4
        public static boolean isPositiveNumber(int a) {
            return (a >= 0);
        }

        //Задача 5
       public static boolean isLeapYear(int year) {
            return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
       }

       // Задача 10
       public static int[] arrayInit(int len, int initialValue) {
            int[] array = new int[len];
            for (int i = 0; i < len; i++) {
                array[i] = initialValue;
            }
            return array;
       }

    }
