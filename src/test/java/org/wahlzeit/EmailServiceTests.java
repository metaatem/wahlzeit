package org.wahlzeit;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.mailing.EmailServiceTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ EmailAddressTest.class, EmailServiceTest.class })
class EmailServiceTests {
}

