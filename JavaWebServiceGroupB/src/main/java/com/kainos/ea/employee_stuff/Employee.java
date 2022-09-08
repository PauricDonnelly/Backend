package com.kainos.ea.employee_stuff;

public class Employee implements Payable, Comparable<Employee> {
    private short number; // employee number
    protected int salary;   // employee salary in pence
    private String firstName;  // employee first name
    private String lastName; //employee last name
    private String bankAccountNumber; // employee Bank Account number
    private String niNumber; // National Insurance
    private String phoneNumber; // Phone Number
    private String email; //email

    public Employee(short number, int salary, String firstName, String lastName, String bankAccountNumber, String niNumber, String phoneNumber, String email) {
        this.number = number;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccountNumber = bankAccountNumber;
        this.niNumber = niNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static final int MIN_SALARY = 7000_00;

    public int calcPay() { // calculate monthly pay in pence
        return getSalary() / 12;
    }

    public Employee() {
        number = -1;
        salary = MIN_SALARY;
    }

    public short getNumber() {
        return number;
    }

    public boolean setNumber(short thisNumber) {
        if (thisNumber > 0) {
            number = thisNumber;
            return true;
        } else {
            return false;
        }
    }

    public boolean setNumber(String thisNumber) {
        try{
            short s = Short.parseShort(thisNumber);
            return setNumber(s);
        } catch(NumberFormatException e){
            throw new BadNumber(e.getMessage());
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary >= MIN_SALARY) {
            this.salary = salary;
        } else {
            throw new SalaryTooLowException(
                    String.format("Salary £%,.2f is below the minimum salary £%,.2f.",
                            salary/100.0, MIN_SALARY/100.0));
        }
    }

//    public boolean equals(Object obj) {
//        if (obj instanceof Employee) {
//            Employee emp = (Employee) obj;
//            return this.getNumber() == emp.getNumber()
//                    && this.getName().equals(emp.getName())
//                    && this.getSalary() == emp.getSalary();
//        } else return false;
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Employee x){
        return Float.compare(this.getSalary(), x.getSalary());
    }
}