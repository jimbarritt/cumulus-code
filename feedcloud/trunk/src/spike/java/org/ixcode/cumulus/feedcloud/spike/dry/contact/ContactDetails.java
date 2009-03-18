package org.ixcode.cumulus.feedcloud.spike.dry.contact;

import org.apache.commons.lang.builder.*;

public class ContactDetails {
    private Name name;
    private TelephoneNumber telephoneNumber;

    public ContactDetails(Name name, TelephoneNumber telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public String toString() {
        return "Name: " + name + ", TelephoneNumber: " + telephoneNumber;    
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hasCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
