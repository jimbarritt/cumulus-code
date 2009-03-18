package org.ixcode.cumulus.feedcloud.spike.dry.contact;

import org.apache.commons.lang.builder.*;

public class TelephoneNumber {
    private String telephoneNumber;

    public TelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String toString() {
        return telephoneNumber;
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hasCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
