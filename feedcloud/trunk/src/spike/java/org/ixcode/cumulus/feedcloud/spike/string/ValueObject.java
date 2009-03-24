package org.ixcode.cumulus.feedcloud.spike.string;

class ValueObject {

    private final long longValue;


    public ValueObject(long longValue) {
        this.longValue = longValue;
    }

    public String toStringWithconcatenation() {
        return "" + longValue;
    }

    public String toStringWithStringBuilder() {
        return new StringBuilder().append(longValue).toString();
    }
}
