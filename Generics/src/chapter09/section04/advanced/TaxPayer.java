package chapter09.section04.advanced;

/**
 * An advanced Strategy pattern with recursive bounds.
 */
abstract class TaxPayer<P extends TaxPayer<P>> {

    public long income;  // in cents
    private TaxStrategy<P> strategy;

    public TaxPayer(long income, TaxStrategy<P> strategy) {
        this.income = income;
        this.strategy = strategy;
    }

    protected abstract P getThis();

    public long getIncome() {
        return income;
    }

    public long computeTax() {
        return strategy.computeTax(getThis());
    }
}

class Person extends TaxPayer<Person> {

    public Person(long income, TaxStrategy<Person> strategy) {
        super(income, strategy);
    }

    protected Person getThis() {
        return this;
    }
}

class Trust extends TaxPayer<Trust> {

    private boolean nonprofit;

    public Trust(long income, boolean nonprofit, TaxStrategy<Trust> strategy) {
        super(income, strategy);
        this.nonprofit = nonprofit;
    }

    protected Trust getThis() {
        return this;
    }

    public boolean isNonprofit() {
        return nonprofit;
    }
}



