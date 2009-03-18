package org.ixcode.cumulus.feedcloud.spike.staticmethod.factory.postaladdressclient;

import org.junit.*;

public class PostalAddressClientTest {

    @Test
    public void createsAddressesAndPrintsThemOut() {
        PostalAddressClient client = new PostalAddressClient();

        client.goUsingNew();

        client.goUsingStaticFactoryMethod();

        client.goUsingFactoryObject();

    }

}
