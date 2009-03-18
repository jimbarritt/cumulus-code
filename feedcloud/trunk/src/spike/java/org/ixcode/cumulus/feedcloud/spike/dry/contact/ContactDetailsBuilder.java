package org.ixcode.cumulus.feedcloud.spike.dry.contact;

public class ContactDetailsBuilder {
    private TelephoneNumber telephoneNumber = new TelephoneNumber("02345 234 565");
    private Name name = new Name("Johnny", "Dawes");

    public ContactDetailsBuilder telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = new TelephoneNumber(telephoneNumber);
        return this;
    }

    public ContactDetailsBuilder telephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public ContactDetails toContactDetails() {
        return new ContactDetails(name, telephoneNumber);
    }
}
