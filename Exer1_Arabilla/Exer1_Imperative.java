public class Exer1_Imperative {
    public static void main(String[] args) {
        int number = 7;
        String result;

        // Imperative: manually instruct each step
        if (number % 2 == 0) {
            result = "Even";
        } else {
            result = "Odd";
        }

        System.out.println("Number " + number + " is " + result + " (Imperative).");
    }
}