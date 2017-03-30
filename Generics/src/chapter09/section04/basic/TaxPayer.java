package chapter09.section04.basic;

/**
 * A basic Strategy pattern with parallel class hierarchies.
 */
abstract class TaxPayer {

    public long income; // in cents

    public TaxPayer(long income) {
        this.income = income;
    }

    public long getIncome() {
        return income;
    }
}

class Person extends TaxPayer {

    public Person(long income) {
        super(income);
    }
}

class Trust extends TaxPayer {

    private boolean nonProfit;

    public Trust(long income, boolean nonProfit) {
        super(income);
        this.nonProfit = nonProfit;
    }

    public boolean isNonProfit() {
        return nonProfit;
    }
}
