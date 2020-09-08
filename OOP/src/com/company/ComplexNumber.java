package com.company;

import java.util.function.DoubleUnaryOperator;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        // Надо будет почитать Effective code, чтобы понять это
        final int prime = 37;
        int result = 1;
        result = prime * result + Double.hashCode(re);
        result = prime * result + Double.hashCode(im);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        // если одинаковые ссылки (то есть один и тот же объект), то верни true
        if (this == o) return true;
        // если это объекты не в одних и тех же классах или объект равен Null, то
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber complexNumber = (ComplexNumber) o;
        // сравниваем значения
        if (complexNumber.re != re || complexNumber.im != im) return false;
        return true;
    }

}
