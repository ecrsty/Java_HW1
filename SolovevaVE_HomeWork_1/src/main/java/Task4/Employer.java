package Task4;

public class Employer {
    private String name;
    private int salary;
    private Division division;
    private PositionType position;

    public Employer(String name, int salary, Division division, PositionType pos) {
        this.name = name;
        this.division = division;
        this.position = pos;
        this.salary = salary*pos.getMultiplier();
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
