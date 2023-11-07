public class Address {
    private String street;
    private String city;
    private Country country;

    public Address(String street, String city, Country country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }
}