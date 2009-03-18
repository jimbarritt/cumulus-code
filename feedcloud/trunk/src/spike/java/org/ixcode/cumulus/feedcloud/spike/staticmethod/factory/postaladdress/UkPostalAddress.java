package org.ixcode.cumulus.feedcloud.spike.staticmethod.factory.postaladdress;

public class UkPostalAddress implements PostalAddress {

    public UkPostalAddress() {

    }

    public static PostalAddress createPostalAddress() {
        return new UkPostalAddress();
    }

    public void printToStandardOut() {
        System.out.println("This is a Uk Postal Address");
    }
}
