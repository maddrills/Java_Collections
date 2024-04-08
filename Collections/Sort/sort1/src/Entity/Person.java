package Entity;

public class Person implements Comparable<Person>{

    private String name;
    private Integer rollNumber;
    private Integer age;

    public Person(String name, Integer rollNumber, Integer age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return STR."person{name='\{name}\{'\''}, rollNumber=\{rollNumber}, age=\{age}\{'}'}";
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
