package phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private final Map<Name, Set<PhoneNumber>> map = new HashMap<>();
    // Example:
    // John Doe: [123-456-7890, 321-654-0987]
    // Mark Smith: [123-456-7890]
    // Jane Doe: [321-654-0987, 111-111-1111, 222-222-2222]

    // associates the given phoneNumber with the given name
    // the name might already exist in the phonebook
    public void add(Name name, PhoneNumber phoneNumber) {
        if (!map.containsKey(name)) {
            map.put(name, new HashSet<>());
        }

        map.get(name).add(phoneNumber);
    }

    // removes the given name along with its phone numbers
    public void remove(Name name) {
        map.remove(name);
    }

    // removes the given phoneNumber for the given name
    public void remove(Name name, PhoneNumber phoneNumber) {
        if (map.containsKey(name)) {
            map.get(name).remove(phoneNumber);
        }
    }

    // returns all phone numbers associated with the given name
    public Set<PhoneNumber> lookup(Name name) {
        return map.get(name);
    }

    // returns all names associated with the given phoneNumber
    public Set<Name> reverseLookup(PhoneNumber phoneNumber) {
        Set<Name> names = new HashSet<>();

        for (Map.Entry<Name, Set<PhoneNumber>> entry : map.entrySet()) {
            Name name = entry.getKey();
            Set<PhoneNumber> phoneNumbers = entry.getValue();

            if (phoneNumbers.contains(phoneNumber)) {
                names.add(name);
            }
        }

        return names;
    }

    // returns all the names in the phonebook
    public Set<Name> names() {
        return map.keySet();
    }

    // returns all the phone numbers in the phonebook
    public Set<PhoneNumber> phoneNumbers() {
        Set<PhoneNumber> result = new HashSet<>();

        for (Set<PhoneNumber> phoneNumbers : map.values()) {
            for (PhoneNumber phoneNumber : phoneNumbers) {
                result.add(phoneNumber);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Name, Set<PhoneNumber>> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    // returns the maximum number of phone numbers per name
    public int maxPhoneNumbers() {
        int max = 0;

        for (Set<PhoneNumber> phoneNumbers : map.values()) {
            if (phoneNumbers.size() > max) {
                max = phoneNumbers.size();
            }
        }

        return max;
    }
}
