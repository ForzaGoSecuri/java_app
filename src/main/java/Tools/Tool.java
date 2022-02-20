package Tools;

public class Tool {
    private String name;
    private String fullName;


    /**
     * @param name name of the tool
     * @param fullName full name of the tool, can be empty
     */
    public Tool(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }
}
