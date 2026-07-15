
public class App {
    public static void main(String[] args) throws Exception {
        // runFibonaci();
        // runFibonaciRecursivePD();
        runFibonaciInterativo();
        runFibonaciInterativo2();
        
    }

    private static void runFibonaciInterativo2() {
        System.out.println("\nFibonacci Interativo2:");
        long startTime = System.nanoTime();
        int num = 48;
        long i = runFibonaciRecursivet2(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
        
    }

    private static void runFibonaciInterativo() {
        System.out.println("\nFibonacci Interativo:");
        long startTime = System.nanoTime();
        int num = 48;
        long i = runFibonaciRecursiveTabulacion(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    private static long runFibonaciRecursiveTabulacion(int n) {
        if (n <= 1) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static long runFibonaciRecursivet2(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0; 
        long b = 1;
        long c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;

    }

    private static void runFibonaciRecursivePD() {
        System.out.println("\nFibonacci Recursivo:");
        long startTime = System.nanoTime();
        int num = 48;
        long[] memo = new long[num + 1];
        long i = fibonacci(num, memo);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static void runFibonaci() {
        System.out.println("\nFibonacci Normal:");
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    public static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

}