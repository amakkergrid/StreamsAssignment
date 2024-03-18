import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        Employee employee1 = new Employee(1,"Ansh",22,20000,"Male","IT");
        Employee employee2 = new Employee(2,"Pratik",23,30000,"Male","HR");
        Employee employee3 = new Employee(3,"Riya",21,25000,"Female","FINANCE");
        Employee employee4 = new Employee(4,"Aditya",24,15000,"Male","DEV");
        Employee employee5 = new Employee(5,"Isha",25,40000,"Female","MGR");
        Employee employee6 = new Employee(6,"Isha",23,35000,"Female","HR");

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);


//        Employee with the highest salary
        Optional<Employee> maxSalary = list.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxSalary);



//        Group them by gender
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList()))));



//        Sort by name in ascending and age in descending
        list.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Comparator.comparing(Employee::getAge).reversed())).toList().forEach(System.out::println);



//        Employee count in each department
        System.out.println(list.stream().map(Employee::getDeptName).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));



//        Highest Salary in each department
        System.out.println(list.stream().collect(Collectors.toMap(Employee::getDeptName, Function.identity(), BinaryOperator.maxBy(Comparator.comparingLong(Employee::getSalary)))));


        List<Person> personList = new ArrayList<>();
        Address address1 = new Address("India","Delhi","834003");
        Address address2 = new Address("USA","New York","43221");
        Address address3 = new Address("United Kingdom","Wales","2344");
        Address address4 = new Address("United Kingdom","London","1232");

        List<Address>addressList1 = new ArrayList<>();
        List<Address>addressList2 = new ArrayList<>();
        List<Address>addressList3 = new ArrayList<>();

        addressList1.add(address1);
        addressList1.add(address3);
        addressList2.add(address1);
        addressList2.add(address2);
        addressList3.add(address4);
        addressList3.add(address2);

        Person person1 = new Person("1","John Snow",addressList1);
        Person person2 = new Person("2","John Thompson",addressList2);
        Person person3 = new Person("3","Steve Smith",addressList3);
        Person person4 = new Person("4","David Johnson",addressList2);
        Person person5 = new Person("4","David Johnson",addressList2);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

//        Remove all duplicate Persons Objects
        personList.stream().distinct().toList().forEach(System.out::println);



//        Sort Persons by their name and city in descending order
        personList.stream().sorted(Comparator.comparing(Person::getName).reversed()).forEach(System.out::println);


//        Extract first 3 Persons whose address in city New York or Person name contains John
        personList.stream().filter(x->x.getName().contains("John") || x.getAddresses().stream().anyMatch(address -> address.getCity().equalsIgnoreCase("New York"))).limit(3).forEach(System.out::println);


//        Get Person Name in UPPER CASE
        personList.stream().map(x->x.getName().toUpperCase()).distinct().toList().forEach(System.out::println);


//        get the person group by addresses
        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getAddresses,Collectors.mapping(Person::getName,Collectors.toList()))));
    }
}
