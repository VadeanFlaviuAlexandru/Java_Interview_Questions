package RandomTestFoundOnline2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyMembers {
//    You are given a list of people. For each person you know their first name, last name and date
//    of birth. All first names and dates of birth are unique. The date of birth is given in the
//    standard date format (YYYY-MM-DD). You must group them by their last name.
//
//    Print the families sorted by their number of members starting with the largest.
//    Within a family print the first names sorted by their age starting with the oldest.
//    Focus on correctness, performance and code quality.


    public static class Person {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;

        public Person(String firstName, String lastName, LocalDate dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Mihai Enescu 1980-01-02",
                "George Ionescu 1992-06-20",
                "Maria Popescu 1995-03-13",
                "Elena Popescu 1990-12-13",
                "Andrei Ionescu 1996-03-01",
                "Sergiu Ionescu 1990-02-01"
        );
        List<Person> people = createPeople(names);
        Map<String, List<Person>> families = groupByLastName(people);
        print(families);
    }

    private static List<Person> createPeople(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("The list of names cannot be empty");
        }
        List<Person> people = new ArrayList<>();
        for (String name : names) {
            String[] arr = name.split("\\s+");
            if (arr.length < 3) {
                throw new IllegalArgumentException("Invalid input format: " + name);
            }
            try {
                String firstName = arr[0];
                String lastName = arr[1];
                LocalDate dob = LocalDate.parse(arr[2]);
                people.add(new Person(firstName, lastName, dob));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for: " + name);
            }
        }
        return people;
    }

    private static Map<String, List<Person>> groupByLastName(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getLastName));
    }

    private static void print(Map<String, List<Person>> groupedByLastName) {
        groupedByLastName.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.print(entry.getKey() + ": ");
                    String firstNames = entry.getValue().stream()
                            .sorted(Comparator.comparing(Person::getDateOfBirth))
                            .map(Person::getFirstName)
                            .collect(Collectors.joining(", "));
                    //the example given didn't have a comma, so I added one. Hope it's ok.
                    System.out.println(firstNames);
                });
    }
}
