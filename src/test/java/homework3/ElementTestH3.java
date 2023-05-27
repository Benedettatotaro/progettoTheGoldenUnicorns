package homework3;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.statistics.Statistics;
import org.junit.jupiter.api.Assertions;

public class ElementTestH3 {

    @Property
    @Report(Reporting.GENERATED)
    void validValues(@ForAll @IntRange(min = 1, max = 1000) int quantity,@ForAll @DoubleRange(min = 0.01, max = 1000 ) double cost, @ForAll("validStringValuesGenerator") String productName) {

        Assertions.assertNotNull(new ElementH3(productName, cost, quantity));
        Statistics.collect(quantity,cost);

    }

    @Property
    @Report(Reporting.GENERATED)
    void invalidIntValues(@ForAll("invalidIntValues") int quantity ) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new ElementH3("ciao", 20,quantity));
        Statistics.collect(quantity);

    }

    @Property
    @Report(Reporting.GENERATED)
    void invalidDoubleValues(@ForAll("invalidDoubleValues") double cost) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new ElementH3("ciao", cost,10));
        Statistics.collect(cost);

    }

    @Property
    @Report(Reporting.GENERATED)
    void invalidStringValues(@ForAll("invalidStringValuesGenerator") String productName) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> new ElementH3(productName, 20, 10));
        Statistics.collect(productName);

    }

    @Property
    @Report(Reporting.GENERATED)
    void validStringValues(@ForAll("validStringValuesGenerator") String productName) {

        Assertions.assertNotNull(new ElementH3(productName, 20, 10));
        Statistics.collect(productName);

    }

    @Provide
    private Arbitrary<Integer> invalidIntValues() {

        return Arbitraries.oneOf(Arbitraries.integers().lessOrEqual(0), Arbitraries.integers().greaterOrEqual(1001));

    }

    @Provide
    private Arbitrary<Double> invalidDoubleValues() {

        return Arbitraries.oneOf(Arbitraries.doubles().lessThan(0.01), Arbitraries.doubles().greaterThan(1000));

    }

    @Provide
    private Arbitrary<String> validStringValuesGenerator() {

        return Arbitraries.strings().ofMinLength(1).ofMaxLength(1000);

    }

    @Provide
    private Arbitrary<String> invalidStringValuesGenerator() {

        return Arbitraries.oneOf(Arbitraries.strings().ofLength(0), Arbitraries.just(null), Arbitraries.just("\n"), Arbitraries.just("\t"));

    }

}
