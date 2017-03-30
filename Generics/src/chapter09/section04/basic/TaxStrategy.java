package chapter09.section04.basic;

/**
 * A basic Strategy pattern with parallel class hierarchies..
 */
interface TaxStrategy<P extends TaxPayer> {

    public long computeTax(P p);
}

class DefaultTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {

    private static final double RATE = 0.40;

    public long computeTax(P payer) {
        return Math.round(payer.getIncome() * RATE);
    }
}

class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {

    public long computeTax(P payer) {
        return 0;
    }
}

class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {

    public long computeTax(Trust trust) {
        return trust.isNonProfit() ? 0 : super.computeTax(trust);
    }
}
