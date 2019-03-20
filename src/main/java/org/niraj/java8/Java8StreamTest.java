package org.niraj.java8;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class Java8StreamTest {

	public static void main(String[] args) {

		
		
		List<Integer> l1 =new ArrayList<>();
		for(int i=1;i<20;i++){
			l1.add(i);
		}
		System.out.println(l1);
		
		List<Integer> l2 = l1.stream().filter(i-> i%2==0).collect(Collectors.toList());
		System.out.println(l2);


		
		long count = l1.stream().filter(i-> i%2==0).count();
		
		Comparator<Integer> comp = (Integer i1, Integer i2)->{ return i2.compareTo(i1);};
		
		List<Integer> l3 = l2.stream().sorted(comp).collect(Collectors.toList());
		System.out.println(l3);
		long count1 = l3.stream().count();
		System.out.println(count1);

		Integer max = l1.stream().max(comp).get();
		Integer min = l1.stream().min(comp).get();
		System.out.println("Min and Max is  ==> " + min+"--"+max);
		
		
		l3.stream().forEach(i->System.out.println(i*i));
		
		
		List<Employee> empList = new ArrayList<Employee>();
			empList.add(new Employee(1, "Niraj", "niraj@gmail.com"));
			empList.add(new Employee(2, "Raju", "raju@koko.com"));
			empList.add(new Employee(3, "Sanjay", "sanjay@yahoo.com"));
			empList.add(new Employee(4, "Kanchan", "kanchan@gmail.com"));
		
		
		empList.stream().forEach( e-> {e.sendMail();} );
		
		
/*		int[] evenNumbers = new int[l2.size()];
        for(int i=0;i<l2.size();i++){
        	evenNumbers[i]=l2.get(i);
        }
		int sumOfEvenNumbers = IntStream.of(evenNumbers).sum();
		System.out.println(sumOfEvenNumbers);
*/
		
		
		
		
/*	
//      Even number printing using Lambda	
		List<Integer> l1 =new ArrayList<>();
		for(int i=1;i<20;i++){
			l1.add(i);
		}
		System.out.println(l1);
		
		List<Integer> l2 = l1.stream().filter(i-> i%2==0).collect(Collectors.toList());
		System.out.println(l2);
		*/

	
	
	}

}


class Employee{
	private int id;
	private String name;
	private String email;
	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public void sendMail() {

		System.out.println("Sending mail to "+ this.name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		System.out.println("Employee called "+ this.email);
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}