class Employee1 {
    // Private fields (encapsulated data)
    private int id;
    private String name;

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

 class Main2 {
    public static void main(String[] args) {
        Employee1 emp = new Employee1();

        // Using setters
        emp.setId(101);
        emp.setName("Geek");

        // Using getters
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
    }
}