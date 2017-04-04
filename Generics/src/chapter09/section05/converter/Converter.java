package chapter09.section05.converter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

enum Currency {DOLLAR, EURO, POUND}

// uncomment if use stab:)
interface CView extends Observer/*<CModel, CView, Currency>*/ {

}

class RateView extends JTextField implements CView {

    private final CModel model;
    private final Currency currency;

    public RateView(final CModel model, final Currency currency) {
        this.model = model;
        this.currency = currency;
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double rate = Double.parseDouble(getText());
                model.setRate(currency, rate);
            }
        });
        model.addObserver(this);
    }

    public void update(CModel model, Currency currency) {
        if (this.currency == currency) {
            double rate = model.getRate(currency);
            setText(String.format("%10.6f", rate));
        }
    }

    // not need if use stab:)
    public void update(Observable model, Object currency) {
        update((CModel) model, (Currency) currency);
    }
}

class ValueView extends JTextField implements CView {

    private final CModel model;
    private final Currency currency;

    public ValueView(final CModel model, final Currency currency) {
        this.model = model;
        this.currency = currency;
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(getText());
                model.setValue(currency, value);
            }
        });
        model.addObserver(this);
    }

    public void update(CModel model, Currency currency) {
        if (currency == null || currency == this.currency) {
            double value = model.getValue(this.currency);
            setText(String.format("%15.2f", value));
        }
    }

    // not need if ise stab:)
    public void update(Observable model, Object currency) {
        update((CModel) model, (Currency) currency);
    }
}

// uncomment if ise stab:)
class CModel extends Observable/*<CModel, CView, Currency>*/ {

    private final EnumMap<Currency, Double> rates;
    private long value;  // in cents

    public CModel() {
        rates = new EnumMap<Currency, Double>(Currency.class);
    }

    public void initialize(double... initialRates) {
        for (int i = 0; i < initialRates.length; i++)
            setRate(Currency.values()[i], initialRates[i]);
    }

    public void setRate(Currency c, double f) {
        rates.put(c, f);
        setChanged();
        notifyObservers(c);
    }

    public void setValue(Currency c, double v) {
        value = Math.round(v / getRate(c) * 100);
        setChanged();
        notifyObservers(null);
    }

    public double getRate(Currency c) {
        return rates.get(c);
    }

    public double getValue(Currency c) {
        return value * getRate(c) / 100;
    }
}

class Converter extends JFrame {

    public Converter() {
        CModel model = new CModel();
        setTitle("Currency converter");
        setLayout(new GridLayout(Currency.values().length + 1, 3));
        add(new JLabel("currency"));
        add(new JLabel("rate"));
        add(new JLabel("value"));
        for (Currency c : Currency.values()) {
            add(new JLabel(c.name()));
            add(new RateView(model, c));
            add(new ValueView(model, c));
        }
        model.initialize(1.0, 0.83, 0.56);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new Converter().setVisible(true);
    }
}


