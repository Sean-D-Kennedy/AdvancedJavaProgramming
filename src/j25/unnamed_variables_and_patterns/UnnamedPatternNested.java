package j25.unnamed_variables_and_patterns;

record Address(String city, String country) {}
record Person(String name, int age, Address address) {}

public class UnnamedPatternNested {
    public static void main(String[] args) {
        Person person = new Person("Mary",
                                    30,
                                        new Address("New York", "USA"));

        // firstly, neither 'age' nor 'city' are used
        if (person instanceof Person(String name, int age, Address(String city, String country))) {
            System.out.println(name + " lives in " + country);
        }
        // now, both 'age' and 'city' are unnamed; making it explicit that they are not used
        if (person instanceof Person(String name, _, Address(_, String country))) {
            System.out.println(name + " lives in " + country);
        }
    }
}