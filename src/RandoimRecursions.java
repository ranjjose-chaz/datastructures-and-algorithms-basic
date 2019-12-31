public class RandoimRecursions {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("\nSum of 1st " + n + " no.s");
        System.out.println(sumOfFirstN(n));

        System.out.println("\n" + n + "!");
        System.out.println(factorial(n));


    }


    public static int sumOfFirstN(int n){
        return (n == 0)? 0 : n+ sumOfFirstN(n-1);
    }



    public static int factorial(int n){
        return (n == 0) ? 1 : n * factorial(n-1);
    }


}
