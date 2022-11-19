package ba.unsa.etf.rpr;

/**
 * Author: @Bakir Pljakic
 * Class App
 * Class that parses and validates console input from args parameter
 */
public class App {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String input = new String();
        for (int i = 0; i < args.length; i++) {
            input += (args[i]+ " ");
        }
        try {
            double result = ExpressionEvaluator.evaluate(input.toString());
            System.out.println(" = " + result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}