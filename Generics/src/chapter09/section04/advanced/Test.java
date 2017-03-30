package chapter09.section04.advanced;

/**
 * An advanced Strategy pattern with recursive bounds.
 */
class Test {

    public static void main(String[] args) {
        // In the advanced version, each tax payer object contains its own tax strategy,
        // and the constructor for each kind of tax payer includes a tax strategy as an additional argument:
        Person person, dodger;
        person = new Person(10000000, new DefaultTaxStrategy<Person>());
        dodger = new Person(10000000, new DodgingTaxStrategy<Person>());
        
        // Now we may invoke a computeTax method of no arguments directly on the tax payer,
        // which will in turn invoke the computeTax method of the tax strategy, passing it the tax payer:
        assert person.computeTax() == 4000000;
        assert dodger.computeTax() == 0;

        Trust forProfit, nonProfit;
        forProfit = new Trust(10000000, false, new TrustTaxStrategy());
        nonProfit = new Trust(10000000, true, new TrustTaxStrategy());
        assert forProfit.computeTax() == 4000000;
        assert nonProfit.computeTax() == 0;
    }
}