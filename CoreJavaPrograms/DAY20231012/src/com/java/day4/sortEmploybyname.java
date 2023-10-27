package com.java.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Employee {
    private static String name;
    private int id;
    private String email;
    
    

    public Employee(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    

    // Getters and setters for the attributes (not shown for brevity)

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}

public class sortEmploybyname {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 1, "alice@example.com"));
        employees.add(new Employee("Bob", 2, "bob@example.com"));
        employees.add(new Employee("Eve", 3, "eve@example.com"));

        //System.out.println(name);
        
//        Employee obj = new Employee();
//        
//        obj.setId(1);
//        obj.setName("Rahul");
//        
//        Employee obj1 =new Employee();
//        obj1.setId(2);
        
        
        // String name= "rahul raman";
        
       
        
        // Sort the 'employees' ArrayList by name in ascending order using a custom Comparator
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                return e1.getName().compareTo(e2.getName());
//            }
//        });
//        Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return o1.getEmail().compareTo(o1.getEmail());
//			}
//        	
//		});
//        
//        
        Collections.sort(employees, new Comparator<Employee>() {

  			@Override
  			public int compare(Employee o1, Employee o2) {
  				return Integer.compare(o1.getId(), o2.getId());
  			}
          	
  		});
        
        
        // Now, the 'employees' ArrayList is sorted by name
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        
        
        Map<String,String> map = new ConcurrentHashMap<String, String>();
        
        
        map.put("fname", "Rahul");
        // map.put(null, "dedbe");
        map.put("lname", "dedbe");
       // map.put(null, "dedbe");
        System.out.println(map);
        
        
        
        
        Set<String> val = map.keySet();
        System.out.println(val);
        
        
        
       //System.out.println(map.get(null));
    }
}