import lam.CalculateThis;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        interface implementation
        /* Integer::sum behind the scenes
        *     public static int sum(int a, int b) { return a + b;}
        * */
        CalculateThis summer = Integer::sum;
//        15
        calc(5, 10, summer);


        CalculateThis multi = (one, two) -> one * two;
//        50
        calc(5, 10, multi);

    }

    public static void calc(int num1, int num2, CalculateThis calculate){

//        the use
        System.out.println(calculate.calculateHH(num1, num2));

    }
}