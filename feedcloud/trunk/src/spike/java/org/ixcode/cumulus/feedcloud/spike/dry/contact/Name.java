package org.ixcode.cumulus.feedcloud.spike.dry.contact;

import org.apache.commons.lang.builder.*;

public class Name {
    private String forename;
    private String surname;

    public Name(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    public String toString() {
        return forename + " " + surname;
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
