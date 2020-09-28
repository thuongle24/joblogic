package automation.utils;

import com.github.javafaker.Faker;
import io.vavr.collection.List;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;

import java.util.Locale;

public class CustomerFakeData {

    private static String langTag;
    static Locale locale;
    static Faker faker;

    public CustomerFakeData(String langTag)
    {
        locale=Locale.forLanguageTag(langTag);
        faker = new Faker(locale);
    }

    public static String getName() {
        //Generating the first name
        String getName = faker.name().fullName();
        return getName;
    }

    public static String getFirstName() {
        //Generating the first name
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String getLastName() {
        //Generating last name
        String lastName = faker.name().lastName();
        return lastName;
    }

    public static String getEmailID() {
        //Generating email Id
        String emailId = faker.internet().emailAddress();
        return emailId;
    }

    public static String getAddress1() {
        //Generating address1
        String address1 = faker.address().buildingNumber() + " "
                + faker.address().streetAddress();
        return address1;
    }

    public static String getAddress2() {
        //Generating address2
        String address2 = faker.address().secondaryAddress();
        return address2;
    }

    public static String getAddress3() {
        //Generating address3
        String address3 = faker.address().city();
        return address3;
    }

    public static String getAddress4() {
        //Generating address4
        String address4 = getCountry();
        return address4;
    }

    public static String getZipCode() {
        //Generating address4
        String zipCode = faker.address().zipCode();
        return zipCode;
    }

    public static String getPhoneNumber() {
        //Generating phone number
        String phoneNumber = faker.phoneNumber().phoneNumber();
        return phoneNumber;
    }

    public static String getEmail() {
        //Generating email
        //It works by replacing ‘?' with random letters and ‘#' with random numbers
        String email = faker.bothify("????##@gmail.com");
        return email;
    }

    public static String getCountry() {
        //Generating country
        String country = locale.getDisplayCountry();
        return country;
    }

    public static String getReferenceNumber() {
        //Generating reference number
        //code creates a lower-case alphanumeric string of length 1
        String referenceNumber = faker.regexify("[a-z1-9]{10}");
        return referenceNumber;
    }
}
