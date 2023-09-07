import java.math.BigInteger;

public class Test29 {
    public static void main(String[] args) {
        //System.out.println(sumOfArithmeticProgression(4));

        int n = 10;
        System.out.print("Factorial of " + n + ": ");
        System.out.println(factorial(20000));

    }

    public static int sumOfArithmeticProgression(int number) {
        if (number <= 0)
            return 0;

        return number + sumOfArithmeticProgression(number - 1);

    }

    public static BigInteger factorial(int number) {
        if (number <= 1)
            return BigInteger.valueOf(1);

        return BigInteger.valueOf(number).multiply(factorial(number - 1));
    }

}
