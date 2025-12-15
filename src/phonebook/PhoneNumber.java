package phonebook;

/**
 * A phone number, such as 718-951-0430 consists of an area code (718), 
 * a prefix (951), and a line number (0430).
 */
public record PhoneNumber(String areaCode, String prefix, String lineNumber) {
    @Override
    public String toString() {
        return areaCode + "-" + prefix + "-" + lineNumber;
    }
}
