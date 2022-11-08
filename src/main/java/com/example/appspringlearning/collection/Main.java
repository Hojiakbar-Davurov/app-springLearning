package com.example.appspringlearning.collection;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
//        Mathematics.abc(1, 65);
//        Mathematics add = new Mathematics() {
//            @Override
//            public Integer operation(int a, int b) {
//                return a + b;
//            }
//        };
//        System.out.println(add);

//        Mathematics div = ((a, b) -> a * b);

//        System.out.println(add.operation(4, 5));
//        System.out.println(div.operation(4, 5));


//        final int x=5;
//        Mathematics mathematics=(a, b) -> {
//            a=x;
//            return a+b;
//        };
//        x=8;


//        System.out.println(operation("+").operation(2, 8));
//        System.out.println(operation("-").operation(2, 8));
//        System.out.println(operation("/").operation(2, 8));
//        System.out.println(operation("*").operation(2, 8));


//        Integer[] arr = {3, 5, 8, 4, 5, -10, -6};
//        Generic addEven = a -> a % 2 == 0;
//        Generic addPositive = a -> a > 0;
//        Generic addNegative = a -> a < 0;
//
//        System.out.println(sum(arr, addEven));
//        System.out.println(sum(arr, addPositive));
//        System.out.println(sum(arr, addNegative));


        /**
         * method reference
         */
        Mathematics math = Mathem::add;
        System.out.println(math.operation(6, 5));

    }

    static Integer sum(Integer[] a, Generic func) {
        Integer sum = 0;
        for (Integer integer : a) {
            if (func.isEquals(integer)) {
                sum += integer;
            }
        }
        return sum;
    }

    static Mathematics operation(String str) {
        switch (str) {
            case "+":
                return Integer::sum;
            case "-":
                return (a, b) -> a - b;
            case "/":
                return (a, b) -> a / b;
            case "*":
                return (a, b) -> a * b;
            default:
                return (a, b) -> 0;
        }
    }

}
