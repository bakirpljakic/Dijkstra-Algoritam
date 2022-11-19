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
    public static void main(String args) {
        String input = new String();
        String[] niz =  ExpressionEvaluator.stringUStringNiz(args);
        for (int i = 0; i < niz.length; i++) {
            input += (niz[i]+ " ");
        }
        try {
            double result = ExpressionEvaluator.evaluate(input.toString());
            System.out.println(" = " + result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}