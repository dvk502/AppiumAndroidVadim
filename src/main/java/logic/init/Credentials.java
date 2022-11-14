package logic.init;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class Credentials {

    public String DRIVER_LOGIN;
    public String DRIVER_PASSWORD;
    public String DRIVER_LOGIN_ANOTHER_ORGANIZATION;
    public String DRVIER_PASSWORD_ANOTHER_ORGANIZATION;
    public String CODRIVER_LOGIN;
    public String CODRIVER_PASSWORD;
    public String ORGPIN;
    public String FIRSTNAME;
    public String LASTNAME;
    public String EMAIL;
    public String REGPASSWORD;
    public String CONFPASSWORD;
    public String LICENSE;
    public String COMPANYNAME;
    public String USDOT;
    public String MCNUMBER;
    public String FLEETNAME;
    public String FLEETLASTNAME;
    public String EMAILFLEET;
    public String FLEETADRESS;
    public String CITYFIELD;
    public String ZIPCODE;
    public String PHONENUMBER;
    public String SMALPASS;
    public String CONFSMALLPASS;
    public String FLEETLOGIN;
    public String FLEETPASS;
    public String TRUCKNUMBER;
    public String ELDDEVICENUMBER;
    public String VINNUMBER;
    public String LICENSEPLATE;
    public String MAKE;
    public String MODEL;
    public String MODELYEAR;
    public String SAMELICENSE;
    public String FLEET_LOGIN;
    public String FLEET_PASS;
    public String OWNER_LOGIN;
    public String OWNER_PASS;
    public String LOGINNAME;
    public String WEBLOGIN;
    public String WEBPASS;
    public String DRIVERWEBNAME;
    public String DRIVERWEBLASTNAME;
    public String WEBORG;
    public String MYDRIVERNAME;
    public String MYDRIVERLASTNAME;
    public String DRIVERORG;
    public String EVENTHOUR;
    public String EVENTMINUTE;
    public String EVENTSTATE;
    public String EVENTCITY;
    public String EVENTCOMMENT;
    public String EVENTTRAILER;
    public String DISPLAYEDTRAILER;
    public String DISPlAYEDSHIPPING;
    public String EVENTSHIPPING;
    public String EVENTLICENSE;

    public long DRIVERID;

    Long dateInMs = new Date().getTime();

    public Credentials myFleet() {
        FLEET_LOGIN = "131315";
        FLEET_PASS = "test";
        return this;
    }

    public Credentials myOwner() {
        OWNER_LOGIN = "131315";
        OWNER_PASS = "test";
        return this;
    }

    public Credentials webAdmin() {
        WEBLOGIN = "5";
        WEBPASS = "test";
        WEBORG = "Koloso4ek";
        return this;
    }

   /* public Credentials webAdmin() {
        WEBLOGIN = "babenkoyana159@gmail.com";
        WEBPASS = "Yanab12345";
        WEBORG = "Koloso4ek";
        return this;
    } */

    public Credentials myDriverName() {
        MYDRIVERNAME = "name1";
        MYDRIVERLASTNAME = "lastname1";
        DRIVERORG = "MyAppium";
        return this;
    }

    public long sqlDriver1() {
        DRIVERID = 92807;
        return DRIVERID;
    }

    public long sqlDriver2() {
        DRIVERID = 92808;
        return DRIVERID;
    }

    //Driver login
    public Credentials driverCredentials() {
        DRIVER_LOGIN = "statustest1";
        DRIVER_PASSWORD = "test";
//        DRIVER_LOGIN = "cleardriver";
//        DRIVER_PASSWORD = "test";
        SMALPASS = "test1";
        CONFSMALLPASS = "test1";
        FLEETLOGIN = "131315";
        FLEETPASS = "test";
        return this;
    }

    public Credentials offDutyEventData() {
        EVENTHOUR = "5";
        EVENTMINUTE = "20";
        EVENTSTATE = "California";
        EVENTCITY = "Ontario";
        EVENTCOMMENT = "TestScorini";
        EVENTTRAILER = "Trailer12";
        EVENTLICENSE = "TestLicense";
        EVENTSHIPPING = "OffShipping";
        return this;
    }

    public Credentials drivingEventData() {
        EVENTHOUR = "8";
        EVENTMINUTE = "55";
        EVENTSTATE = "Ontario";
        EVENTCITY = "Ontario";
        EVENTCOMMENT = "TestScorini";
        EVENTTRAILER = "Trailer13";
        EVENTLICENSE = "TestLicense";
        EVENTSHIPPING = "DrShipping";
        return this;
    }

    public Credentials onDutyEventData() {
        EVENTHOUR = "13";
        EVENTMINUTE = "30";
        EVENTSTATE = "Kansas";
        EVENTCITY = "Ontario";
        EVENTCOMMENT = "TestScorini";
        EVENTTRAILER = "Trailer14";
        EVENTLICENSE = "TestLicense";
        EVENTSHIPPING = "OnShipping";
        return this;
    }

    public Credentials sleepEventData() {
        EVENTHOUR = "20";
        EVENTMINUTE = "00";
        EVENTSTATE = "Kansas";
        EVENTCITY = "Ontario";
        EVENTCOMMENT = "TestScorini";
        EVENTTRAILER = "Trailer15";
        EVENTLICENSE = "TestLicense";
        EVENTSHIPPING = "SlShipping";
        return this;
    }

    public Credentials compare1() {
        DISPLAYEDTRAILER = "Tr: Trailer12";
        DISPlAYEDSHIPPING = "Sh: OffShipping";
        return this;
    }

    public Credentials compare2() {
        DISPLAYEDTRAILER = "Tr: " + offDutyEventData().EVENTTRAILER + ", " + drivingEventData().EVENTTRAILER;
        DISPlAYEDSHIPPING = "Sh: " + offDutyEventData().EVENTSHIPPING + ", " + drivingEventData().EVENTSHIPPING;
        return this;
    }

    public Credentials compare3() {
        DISPLAYEDTRAILER = "Tr: " + offDutyEventData().EVENTTRAILER + ", " + drivingEventData().EVENTTRAILER + ", " + onDutyEventData().EVENTTRAILER;
        DISPlAYEDSHIPPING = "Sh: " + offDutyEventData().EVENTSHIPPING + ", " + drivingEventData().EVENTSHIPPING + ", " + onDutyEventData().EVENTSHIPPING;
        return this;
    }

    public Credentials compare4() {
        DISPLAYEDTRAILER = "Tr: " + sleepEventData().EVENTTRAILER;
        DISPlAYEDSHIPPING = "Sh: " + sleepEventData().EVENTSHIPPING;
        return this;
    }


    //CoDriverLogin
    public Credentials coDriverCredentials() {
        DRIVER_LOGIN_ANOTHER_ORGANIZATION = "00012";
        DRVIER_PASSWORD_ANOTHER_ORGANIZATION = "test";
        CODRIVER_LOGIN = "testplan1";
        CODRIVER_PASSWORD = "test";
        SMALPASS = "test1";
        CONFSMALLPASS = "test1";
        return this;
    }

    //Registration data Driver
    public Credentials driverData() {
        ORGPIN = "NPW4Q";
        FIRSTNAME = "Test" + dateInMs;
        LASTNAME = "Driver" + dateInMs;
        EMAIL = "appiumdriver" + dateInMs + "@gmail.com";
        REGPASSWORD = "test12345";
        CONFPASSWORD = "test12345";
        LICENSE = dateInMs.toString();
        SMALPASS = "test1";
        CONFSMALLPASS = "test1";
        SAMELICENSE = "45545";
        LOGINNAME = dateInMs.toString();
        return this;
    }

    //Registration data Fleet (not a driver)
    public Credentials fleetDataND() {
        COMPANYNAME = "Appium010621" + dateInMs;
        USDOT = "1" + dateInMs.toString().substring(4,12);
        MCNUMBER = "2" + dateInMs;
        EMAIL = "fleet1" + dateInMs + "@gmail.com";
        REGPASSWORD = "test12345";
        CONFPASSWORD = "test12345";
        FLEETNAME = "name-f.leet 1";
        FLEETLASTNAME = "last-n.amefleet 1";
        EMAILFLEET = "fleet1" + dateInMs + "@gmail.com";
        FLEETADRESS = "Montana";
        CITYFIELD = "Montana";
        ZIPCODE = "12345" /*+ dateInMs*/;
        PHONENUMBER = "5645646565";
        SMALPASS = "test1";
        CONFSMALLPASS = "test1";
        return this;
    }

    public Credentials truckCreate() {
        Date date = new Date();
        TRUCKNUMBER = "TestTruck" + date.getTime();
        ELDDEVICENUMBER = "Something" + date.getTime();
        VINNUMBER = getValidVinNumber();
        LICENSEPLATE = String.valueOf(date.getTime());
        MAKE = "test" + date.getTime();
        MODEL = "testmodel" + date.getTime();
        MODELYEAR = "2020";
        return this;
    }

    private String getValidVinNumber() {
        String newVin = generateRandomVin(17);
        while (!isVinValid(newVin)) {
            newVin = generateRandomVin(17);
        }
        return newVin;
    }

    public static void main(String[] args) {
        Credentials main = new Credentials();
        System.out.println(main.getValidVinNumber());
    }

    private static final String characters = "ABCDEFGHJKLMNPRSTUVWXYZ123456789";
    private static final String numbers = "1234567890";

    public String generateRandomVin(int length) {
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (i == 8 | i >= 13) {
                sb.append(numbers.charAt(random.nextInt(numbers.length())));
            } else {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
        }
        return sb.toString();
    }

    public static boolean isVinValid(String vin) {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9,
                2, 3, 4, 5, 6, 7, 8, 9 };
        int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };


        String s = vin;
        s = s.replaceAll("-", "");
        s = s.replaceAll(" ", "");
        s = s.toUpperCase();
        if (s.length() != 17)
            throw new RuntimeException("VIN number must be 17 characters");

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char c = s.charAt(i);
            int value;
            int weight = weights[i];

            // letter
            if (c >= 'A' && c <= 'Z') {
                value = values[c - 'A'];
                if (value == 0)
                    throw new RuntimeException("Illegal character: " + c);
            }

            // number
            else if (c >= '0' && c <= '9')
                value = c - '0';

                // illegal character
            else
                throw new RuntimeException("Illegal character: " + c);

            sum = sum + weight * value;

        }

        // check digit
        sum = sum % 11;
        char check = s.charAt(8);
        //System.out.println("Valid");
        //System.out.println("Invalid");
        if (sum == 10 && check == 'X') {
            //System.out.println("Valid");
            return true;
        } else return sum == transliterate(check);

    }

    private static int transliterate(char check){
        if(check == 'A' || check == 'J'){
            return 1;
        } else if(check == 'B' || check == 'K' || check == 'S'){
            return 2;
        } else if(check == 'C' || check == 'L' || check == 'T'){
            return 3;
        } else if(check == 'D' || check == 'M' || check == 'U'){
            return 4;
        } else if(check == 'E' || check == 'N' || check == 'V'){
            return 5;
        } else if(check == 'F' || check == 'W'){
            return 6;
        } else if(check == 'G' || check == 'P' || check == 'X'){
            return 7;
        } else if(check == 'H' || check == 'Y'){
            return 8;
        } else if(check == 'R' || check == 'Z'){
            return 9;
        } else if(Integer.valueOf(Character.getNumericValue(check)) != null){ //hacky but works
            return Character.getNumericValue(check);
        }
        return -1;
    }
}
