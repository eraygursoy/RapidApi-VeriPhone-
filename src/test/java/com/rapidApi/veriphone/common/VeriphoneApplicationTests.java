package com.rapidApi.veriphone.common;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import veriphone.Client;
import veriphone.ExampleResponseDto;
import veriphone.VerifyResponseDto;

/**
 * @Author Eray Gürsoy
 */
@SpringBootTest
class VeriphoneApplicationTests {

    private static String phoneNumber;
    static String countryCode;
    static String phoneType;

    /**
     * PhoneTypes: fixedline, mobile , premiumrate, sharedcost, tollfree, voip
     */

    @BeforeAll
    public static void initParameters() {
        phoneNumber = "05368401740";
        countryCode = "TR";
        phoneType = "mobile";
    }

    @Test
    void test_verifyPhone() {

        Client client = new Client();
        VerifyResponseDto verifyResponseDto = client.getVerifyPhoneNumber(phoneNumber);
        Assert.assertNotNull(verifyResponseDto);

        System.out.println(verifyResponseDto);
    }

    @Test
    void test_examplePhone() {

        Client client = new Client();
        ExampleResponseDto responseDto = client.getExamplePhoneByCountryCodeAndType(countryCode, phoneType);
        Assert.assertNotNull(responseDto);

        System.out.println(responseDto);
    }
}
