package com.thoughtworks.cschuyle;

public abstract class WrappedInteger {

    protected int value;
    private String stringValue;
    private String toStringValue;
    private int hashCode;

    private WrappedInteger() {};

    WrappedInteger(int i) {
        value = i;
        rehash();
    }

    public int intValue() {
        return value;
    }

    public String stringValue() {
        return stringValue;
    }

    protected void rehash() {
        stringValue = ""+value;
        toStringValue = this.getClass().getSimpleName() + "<" + value + ">";
        hashCode = toString().hashCode();
    }

    public @Override String toString() {
        return toStringValue;
    }

    public @Override int hashCode() {
        return hashCode;
    }

}
