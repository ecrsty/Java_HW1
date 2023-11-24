package Task3and4;

public class Employer {
    private String name;
    private int salary;
    private Division division;
    private PositionType position;

    public Employer(String name, int salary, Division division) {
        this.name = name;
        this.salary = salary;
        this.division = division;
    }
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Division getDivision() {
        return division;
    }

    public PositionType getPosition() {
        return position;
    }
}
