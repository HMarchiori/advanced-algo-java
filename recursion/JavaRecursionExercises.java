package recursion;

public class JavaRecursionExercises {

    // Exercise 1: Multiplication using recursion (two implementations)
    public static class Exercise1 {
        public static int multiply(int num, int times, int sum) {
            if (times > 0) {
                sum += num;
                times--;
                return multiply(num, times, sum);
            }
            return sum;
        }

        public static int multiplyAlt(int num, int times) {
            if (times < 0) throw new IllegalArgumentException();
            if (times == 0 || times == 1) return num;
            return num + multiplyAlt(num, times - 1);
        }

        public static void main(String[] args) {
            System.out.println(multiplyAlt(8, 6));
        }
    }

    // Exercise 2: Sum using recursion
    public static class Exercise2 {
        public static int sum(int a, int b) {
            if (b == 0) {
                return a;
            }
            return sum(a + 1, b - 1);
        }

        public static void main(String[] args) {
            System.out.println(sum(3, 2));
        }
    }

    // Exercise 3: Harmonic series calculation
    public static class Exercise3 {
        public static double harmonicSeries(double terms, double sum) {
            if (terms > 0) {
                sum += 1 / terms;
                terms--;
                return harmonicSeries(terms, sum);
            }
            return sum;
        }

        public static void main(String[] args) {
            System.out.println(harmonicSeries(5, 0));
        }
    }

    // Exercise 4: String reversal
    public static class Exercise4 {
        public static String reverseString(String str, int length) {
            if (length < 1) return "";
            if (length == 1) return String.valueOf(str.charAt(0));
            return str.charAt(length - 1) + reverseString(str, length - 1);
        }

        public static void main(String[] args) {
            String str = "testing exercise 4";
            System.out.println(reverseString(str, str.length()));
        }
    }

    // Exercise 5: Special sequence calculation
    public static class Exercise5 {
        public static int sequence(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            return 2 * sequence(n - 1) + 3 * sequence(n - 2);
        }

        public static void main(String[] args) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(sequence(i) + " ");
            }
        }
    }

    // Exercise 6: Ackermann function
    public static class Exercise6 {
        public static int ackermann(int m, int n) {
            if (m == 0) return n + 1;
            if (m > 0 && n == 0) return ackermann(m - 1, 1);
            return ackermann(m - 1, ackermann(m, n - 1));
        }

        public static void main(String[] args) {
            System.out.println(ackermann(3, 4)); // Should print 125
        }
    }

    // Exercise 7: Sum and product of array elements
    public static class Exercise7 {
        public static int[] calculateSumAndProduct(int[] nums, int index) {
            if (index == nums.length) {
                return new int[]{0, 1};
            }

            int[] result = calculateSumAndProduct(nums, index + 1);
            result[0] += nums[index];
            result[1] *= nums[index];

            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5};
            int[] result = calculateSumAndProduct(nums, 0);
            System.out.println("Sum: " + result[0]);
            System.out.println("Product: " + result[1]);
        }
    }

    // Exercise 8: Palindrome check and base conversion
    public static class Exercise8 {
        public static boolean isPalindrome(String str, int start, int end) {
            if (start >= end) return true;
            if (str.charAt(start) != str.charAt(end)) return false;
            return isPalindrome(str, start + 1, end - 1);
        }

        public static String convertToBinary(int n) {
            if (n < 0) throw new IllegalArgumentException();
            if (n == 0) return "0";
            if (n == 1) return "1";
            String digit = (n % 2 == 0) ? "0" : "1";
            return convertToBinary(n / 2) + digit;
        }

        public static void main(String[] args) {
            String word = "abcba";
            System.out.println(isPalindrome(word, 0, word.length() - 1)
                    ? "It's a palindrome!" : "Not a palindrome!");
            System.out.println(convertToBinary(2244432));
        }
    }

    // Exercise 9: Generate permutations
    public static class Exercise9 {
        public static void generatePermutations(char[] letters, int start) {
            if (start == letters.length - 1) {
                System.out.println(String.valueOf(letters));
                return;
            }

            for (int i = start; i < letters.length; i++) {
                swap(letters, start, i);
                generatePermutations(letters, start + 1);
                swap(letters, start, i);
            }
        }

        private static void swap(char[] letters, int i, int j) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }

        public static void main(String[] args) {
            int n = 3;
            char[] letters = new char[n];

            for (int i = 0; i < n; i++) {
                letters[i] = (char) ('A' + i);
            }

            generatePermutations(letters, 0);
        }
    }

    // Exercise 10: Generalized Fibonacci sequence
    public static class Exercise10 {
        public static int generalizedFib(int f0, int f1, int n) {
            if (n == 0) return f0;
            if (n == 1) return f1;
            return generalizedFib(f0, f1, n - 1) + generalizedFib(f0, f1, n - 2);
        }

        public static void main(String[] args) {
            int f0 = 3;
            int f1 = 5;
            int n = 10;

            for (int i = 0; i < n; i++) {
                System.out.print(generalizedFib(f0, f1, i) + " ");
            }
        }
    }

    // Main class to run all exercises
    public static void main(String[] args) {
        System.out.println("Running all recursion exercises:");

        System.out.println("\nExercise 1:");
        Exercise1.main(args);

        System.out.println("\nExercise 2:");
        Exercise2.main(args);

        System.out.println("\nExercise 3:");
        Exercise3.main(args);

        System.out.println("\nExercise 4:");
        Exercise4.main(args);

        System.out.println("\nExercise 5:");
        Exercise5.main(args);

        System.out.println("\nExercise 6:");
        Exercise6.main(args);

        System.out.println("\nExercise 7:");
        Exercise7.main(args);

        System.out.println("\nExercise 8:");
        Exercise8.main(args);

        System.out.println("\nExercise 9:");
        Exercise9.main(args);

        System.out.println("\nExercise 10:");
        Exercise10.main(args);
    }
}