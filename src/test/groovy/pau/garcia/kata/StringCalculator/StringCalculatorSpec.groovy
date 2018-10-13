package pau.garcia.kata.StringCalculator

import spock.lang.Specification

class StringCalculatorSpec extends Specification {
    // Here is where the fun starts... instead of dozens of unit tests like the 2 above, we can use data driven tests
    // data driven test with expected Strings output values
    def 'Should return sum of numbers'() {
        expect:
            StringCalculator.sum(a) == b
        where:
            a                   |b
            "1,3"               |1+3
            "1,2,3,4,5"         |1+2+3+4+5
            "1,3,5"             |1+3+5
            "1,3\n5"            |1+3+5
            "//_\n1_3\n5"       |1+3+5
            "//;\n1;3\n5"       |1+3+5
            ""                  |0
            "3"                 |3
    }

    def 'When any element is not a number or negative should return an informative message with all of them'() {
        // data driven test with expected Exceptions thrown. Notice that we are comparing Strings and Classes
        expect:
            String message
            Class exception
            try {
                StringCalculator.sum(a)
            } catch (Exception e) {
                message = e.getMessage()
                exception = e.getClass()
            }
            exception==b && message == c

        where:
            a                   |b                                  |c
            "1, 2"              |java.lang.NumberFormatException    |"For input string: \" 2\""
            "A,2"               |java.lang.NumberFormatException    |"For input string: \"A\""
            "1,XXX,5"           |java.lang.NumberFormatException    |"For input string: \"XXX\""
            "//;\n1;-3\n5"      |java.lang.RuntimeException         |StringCalculator.NEGATIVE_VALUES_NOT_ALLOWED + ":-3"
            "//;\n1;-3\n-12"    |java.lang.RuntimeException         |StringCalculator.NEGATIVE_VALUES_NOT_ALLOWED + ":-3;-12"
    }
}