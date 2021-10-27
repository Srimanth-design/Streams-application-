/**
 * @author SrimanthChintha
 *
 */

package com.streams.project;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = Arrays.asList(new Employee("srimanth", "Vizag", 234),
				new Employee("Hemanth", "Bangalore", 235), new Employee("Karthik", "Vietnam", 236),
				new Employee("Ajay", "Chennai", 237), new Employee("Karunya", "Vizag", 238));

		// printing all the employees using forEach

		for (Employee employee : employeeList) {
			System.out.println(employee);
		}

		// printing based on city using stream,filter and iterator

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("Enter city: ");
		String city = scan.nextLine();

		Stream<Employee> newStream = employeeList.stream();
		Stream<Employee> cityStream = newStream.filter((x) -> {
			return x.city.equals(city);
		});
		Iterator<Employee> li = cityStream.iterator();
		while (li.hasNext()) {
			Employee employee = (Employee) li.next();
			System.out.println(employee);
		}

		// print after sorting the data (sorted by name)

		System.out.println();
		System.out.println("Printing after sorting: ");
		System.out.println();
		Stream<Employee> newStream4 = employeeList.stream().sorted((x, y) -> {
			return x.name.compareTo(y.name);
		});
		Iterator<Employee> li5 = newStream4.iterator();
		while (li5.hasNext()) {
			Employee employee = (Employee) li5.next();
			System.out.println(employee);
		}

		System.out.println();

		// printed employee names by Id

		System.out.print("Enter Id: ");
		int empId = scan.nextInt();
		Stream<Employee> newStream2 = employeeList.stream();
		Optional<Employee> idStream = newStream2.filter((x) -> {
			return x.empId == empId;
		}).findFirst();
		try {
			if (idStream.isPresent()) {
				System.out.println();
				System.out.println(idStream.get());
			} else {
				throw new NullPointerException("Not found");
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Employee names that start with k
		System.out.println();
		System.out.println("Employee names if available starting with 'K' ");
		System.out.println();

		Stream<Employee> newStream3 = employeeList.stream();
		Stream<Employee> kStream = newStream3.filter((x) -> {
			return x.name.startsWith("K");
		});
		Iterator<Employee> newIt = kStream.iterator();
		while (newIt.hasNext()) {
			Employee e = (Employee) newIt.next();
			System.out.println(e);
		}

	}

}
