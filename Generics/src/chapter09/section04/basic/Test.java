package chapter09.section04.basic;

/**
 * A basic Strategy pattern with parallel class hierarchies.
 */
class Test {

    public static void main(String[] args) {
        //Every tax payer has an income, and, in addition, a trust may be nonprofit.
        //For example, we may define a person with an income of $100,000.00 and two trusts with the same income, one nonprofit and one otherwise:
        Person person = new Person(10000000);
        Trust nonProfit = new Trust(10000000, true);
        Trust forProfit = new Trust(10000000, false);

        // For each tax payer P there may be many possible strategies for computing tax.
        // Each strategy implements the interface TaxStrategy<P>,
        // which specifies a method computeTax that takes as argument a tax payer of type P and returns the tax paid.
        // Class Default TaxStrategy computes the tax by multiplying the income by a fixed tax rate of 40 percent,
        // while class DodgingTaxStrategy always computes a tax of zero:
        TaxStrategy<Person> defaultStrategy = new DefaultTaxStrategy<Person>();
        TaxStrategy<Person> dodgingStrategy = new DodgingTaxStrategy<Person>();
        assert defaultStrategy.computeTax(person) == 4000000;
        assert dodgingStrategy.computeTax(person) == 0;

        // Finally, class TrustTaxStrategy computes a tax of zero if the trust is nonprofit and uses the default tax strategy otherwise:
        TaxStrategy<Trust> trustStrategy = new TrustTaxStrategy();
        assert trustStrategy.computeTax(nonProfit) == 0;
        assert trustStrategy.computeTax(forProfit) == 4000000;
    }
}