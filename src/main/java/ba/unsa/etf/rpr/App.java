package ba.unsa.etf.rpr;

/**
 * The type App.
 */
public class App {
    /**
     * The entry point of application.
     *
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