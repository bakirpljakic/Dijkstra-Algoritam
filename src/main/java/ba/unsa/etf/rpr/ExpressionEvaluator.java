package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Author: @Bakir Pljakic
 * Class ExpressionEvaluater
 * Class that evaulates arithmetic expressions using Dijkstra's algorithm
 */
public class ExpressionEvaluator {
    private static Stack<String> operatori = new Stack<String>();
    private static Stack<Double> vrijednosti = new Stack<Double>();

    /**
     * @param s returns an array of strings based on method parameter string
     * @return
     */
    public static String[] stringUStringNiz(String s) {
        return s.split(" ");
    }

    /**
     * Evaluate double.
     *
     * @param s the expression for evaluation as a String
     * @return double the evaluated expression
     */
    public static Double evaluate(String s) //throws RuntimeException
    {
        operatori = new Stack<>();
        vrijednosti = new Stack<>();
        String[] n = stringUStringNiz(s);
        for (int i = 0; i < n.length; i++) {
            if (n[i].equals("(")) ;
            else if (n[i].equals("+")) operatori.push(n[i]);
            else if (n[i].equals("-")) operatori.push(n[i]);
            else if (n[i].equals("*")) operatori.push(n[i]);
            else if (n[i].equals("/")) operatori.push(n[i]);
            else if (n[i].equals("sqrt")) operatori.push(n[i]);
            else if (n[i].equals(")")) {
                String op = operatori.pop();
                double vr = vrijednosti.pop();
                if (op.equals("+")) vr = vrijednosti.pop() + vr;
                else if (op.equals("-")) vr = vrijednosti.pop() - vr;
                else if (op.equals("*")) vr = vrijednosti.pop() * vr;
                else if (op.equals("/")) {
                    if (vr == 0) throw new RuntimeException("Nelegalna operacija!");
                    vr = vrijednosti.pop() / vr;
                } else if (op.equals("sqrt")) vr = Math.sqrt(vr);
                vrijednosti.push(vr);
            } else try {
                vrijednosti.push(Double.parseDouble(n[i]));
            } catch (Exception e) {
                throw new RuntimeException("Izraz nije validan");
            }

        }
        if (!operatori.empty()) throw new RuntimeException("Izraz nije validan");
        return vrijednosti.pop();
    }
}