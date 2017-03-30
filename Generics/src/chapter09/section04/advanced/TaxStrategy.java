package chapter09.section04.advanced;

/**
 * An advanced Strategy pattern with recursive bounds.
 */
interface TaxStrategy<P extends TaxPayer<P>> {

    public long computeTax(P p);
}

class DefaultTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {

    private static final double RATE = 0.40;

    public long computeTax(P payer) {
        return Math.round(payer.getIncome() * RATE);
    }
}

class DodgingTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {

    public long computeTax(P payer) {
        return 0;
    }
}

class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {

    public long computeTax(Trust trust) {
        return trust.isNonprofit() ? 0 : super.computeTax(trust);
    }
}



