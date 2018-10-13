package pau.garcia.kata.StringCalculator

import spock.lang.Specification

class StringCalculatorOldWaySpec extends Specification {
    // Individual, classic unit test (JUnit style)
    def 'Should return sum'() {
        given: "A new String"
            String numbers

        when: "Three numbers in String"
            numbers = "1,2,3"

        then: "Sum should be returned"
            StringCalculator.sum(numbers) == 6
    }
    def 'When one number is negative should raise an error'() {
        given: "A String with Delimiter specified"
            String numbers = "//;\n1;-3\n5"

        when: "sum is called"
            int sum = StringCalculator.sum(numbers)

        then: "Sum should be returned"
            RuntimeException e = thrown()
            e.message == StringCalculator.NEGATIVE_VALUES_NOT_ALLOWED + ":-3"
    }
    // ... 14 more times?
}