package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * The type Expression evaluator test.
 */
class ExpressionEvaluatorTest {

    /**
     * Test testing additon of numbers.
     */
    @Test
    public void evaluateSabiranje() {
        Assertions.assertEquals(19, ExpressionEvaluator.evaluate("( 4 + 15 )"));
        Assertions.assertEquals(26, ExpressionEvaluator.evaluate("( ( 4 + 15 ) + 7 )"));
    }

    /**
     * Test testing subbstracion of numbers
     */
    @Test
    public void evaluateOduzimanje() {
        Assertions.assertEquals(15, ExpressionEvaluator.evaluate("( ( 25 - 5 ) - 5 )"));
        Assertions.assertEquals(0, ExpressionEvaluator.evaluate("( ( ( 25 - 5 ) + 5 ) - 25 )"));
    }

    /**
     * Test testing multiplication od numbers
     */
    @Test
    public void evaluateMnozenje() {
        Assertions.assertEquals(216, ExpressionEvaluator.evaluate("( 8 * 27 )"));
        Assertions.assertEquals(100, ExpressionEvaluator.evaluate("( ( 5 * 2 ) * 10 )"));
    }

    /**
     * Test testing dividing of numbers
     */
    @Test
    public void evaluateDijeljenje() {
        Assertions.assertEquals(3, ExpressionEvaluator.evaluate("( 9 / 3 )"));
        Assertions.assertEquals(1, ExpressionEvaluator.evaluate("( 28 / 4 ) / 7 )"));
    }

    /**
     * Test testing square root of a number
     */
    @Test
    public void evaluteKorijenovanje(){
        Assertions.assertEquals(3, ExpressionEvaluator.evaluate("( sqrt 9 )"));
        Assertions.assertEquals(9, ExpressionEvaluator.evaluate("( sqrt 81 )"));
    }

    /**
     *Test tests if exception will be thrown because the expression is not correctly formatted
     * should @throws RuntimeException
     */
    @Test
    public void testIzuzetka(){
        Assertions.assertThrows(RuntimeException.class,()->ExpressionEvaluator.evaluate("(8 + 5)"));
        Assertions.assertThrows(RuntimeException.class,()->ExpressionEvaluator.evaluate("( ( ( 8 + 5) + 5 ) + 5"));
        Assertions.assertThrows(RuntimeException.class,()->ExpressionEvaluator.evaluate("( ( ( 8 + 5) + 5 ) + 5 ) * 8 ) )"));
    }
}