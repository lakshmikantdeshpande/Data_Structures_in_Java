package clair;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int compareTo(Employee emp) {
        if (this.getSalary() == emp.getSalary())
            return 0;
        else if (this.getSalary() < emp.getSalary())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
                + "]";
    }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + id;
    // result = prime * result + ((name == null) ? 0 : name.hashCode());
    // result = prime * result + salary;
    // return result;
    // }
    //
    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Employee other = (Employee) obj;
    // if (id != other.id)
    // return false;
    // if (name == null) {
    // if (other.name != null)
    // return false;
    // } else if (!name.equals(other.name))
    // return false;
    // if (salary != other.salary)
    // return false;
    // return true;
    // }

}