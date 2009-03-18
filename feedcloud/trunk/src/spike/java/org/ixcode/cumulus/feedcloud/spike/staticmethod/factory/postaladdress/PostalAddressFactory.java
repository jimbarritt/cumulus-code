package org.ixcode.cumulus.feedcloud.spike.staticmethod.factory.postaladdress;

public class PostalAddressFactory {

    public PostalAddressFactory() {

    }

    public PostalAddress createUkPostalAddress() {
        return new UkPostalAddress();
    }

    public PostalAddress createUsPostalAddress() {
        return new UsPostalAddress();
    }

}
