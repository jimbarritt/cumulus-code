package org.ixcode.cumulus.feedcloud.spike.staticmethod.factory.postaladdressclient;

import org.ixcode.cumulus.feedcloud.spike.staticmethod.factory.postaladdress.*;

public class PostalAddressClient {

   public PostalAddressClient() {

   }

    /**
     * Most direct greates coupling
     */
    public void goUsingNew() {
        PostalAddress address = new UkPostalAddress();

        address.printToStandardOut();
    }

    /**
     * Medium Indirect medium coupling
     */
    public void goUsingStaticFactoryMethod() {
        PostalAddress address = UkPostalAddress.createPostalAddress();

        address.printToStandardOut();
    }

    /**
     * Most indirect least coupling
     */
    public void goUsingFactoryObject() {
        PostalAddressFactory factory = new PostalAddressFactory();
        PostalAddress ukAddress = factory.createUkPostalAddress();
        PostalAddress usAddress = factory.createUsPostalAddress();


        ukAddress.printToStandardOut();
        usAddress.printToStandardOut();
    }


}
