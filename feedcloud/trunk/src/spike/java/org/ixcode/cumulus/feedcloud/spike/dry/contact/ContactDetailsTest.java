package org.ixcode.cumulus.feedcloud.spike.dry.contact;

import static org.junit.Assert.*;
import org.junit.*;

public class ContactDetailsTest {

    /**
     * This one has the number duplicated.
     * However, it does highlight exactly what the value is we are testing.
     * It kind of jumps out at you. 
     */
    @Test
    public void knowsItsTelephoneNumber_A() {
        ContactDetails contactDetails = new ContactDetailsBuilder()
                .telephoneNumber("07856 345 234")
                .toContactDetails();

        TelephoneNumber actualTelephoneNumber = contactDetails.getTelephoneNumber();

        assertEquals("telephoneNumber", new TelephoneNumber("07856 345 234"), actualTelephoneNumber);
    }

    /**
     * Here the local variable for the telephone number seems a little bit redundant.
     * Also i seem to have to scan around the code quite a bit to work out whats going on.
     * Its like its distracting me. I keep wanting to look at it to see what the value is.
     */
    @Test
    public void knowsItsTelephoneNumber_B() {
        final TelephoneNumber telephoneNumber = new TelephoneNumber("07856 345 234");

        ContactDetails contactDetails = new ContactDetailsBuilder()
                .telephoneNumber(telephoneNumber)
                .toContactDetails();


        TelephoneNumber actualTelephoneNumber = contactDetails.getTelephoneNumber();

        assertEquals("telephoneNumber", telephoneNumber, actualTelephoneNumber);
    }

    private static final TelephoneNumber TELEPHONE_NUMBER = new TelephoneNumber("07856 345 234");

    /**
     * Statics could tend to "leak" out into thr class, it would be ok, if they are shared by all tests, but
     * this quickly builds up into a nightmare if each test defines its own.
     */
    @Test
    public void knowsItsTelephoneNumber_C() {
        ContactDetails contactDetails = new ContactDetailsBuilder()
                .telephoneNumber(TELEPHONE_NUMBER)
                .toContactDetails();


        TelephoneNumber actualTelephoneNumber = contactDetails.getTelephoneNumber();

        assertEquals("telephoneNumber", TELEPHONE_NUMBER, actualTelephoneNumber);
    }


    /**
     * Can definitely count this one out - better to create a real telephone number (option B)
     */
    @Test
    public void knowsItsTelephoneNumber_D() {
        final String validTelephoneNumberString = "07856 345 234";

        ContactDetails contactDetails = new ContactDetailsBuilder()
                .telephoneNumber(validTelephoneNumberString)
                .toContactDetails();

        TelephoneNumber actualTelephoneNumber = contactDetails.getTelephoneNumber();

        assertEquals("telephoneNumber", new TelephoneNumber(validTelephoneNumberString), actualTelephoneNumber);
    }

    private static final String VALID_TELEPHONE_NUMBER_STRING = "07856 345 234";

    /**
     * Can definitely count this one out - better to create a real telephone number (option C)
     */
    @Test
    public void knowsItsTelephoneNumber_E() {
        ContactDetails contactDetails = new ContactDetailsBuilder()
                .telephoneNumber(VALID_TELEPHONE_NUMBER_STRING)
                .toContactDetails();

        TelephoneNumber actualTelephoneNumber = contactDetails.getTelephoneNumber();

        assertEquals("telephoneNumber", new TelephoneNumber(VALID_TELEPHONE_NUMBER_STRING), actualTelephoneNumber);
    }


}
