package Tools;

public class Tool {
    private String name;
    private String fullName;


    /**
     * TODO
     *  - for full name if empty get the full name from the tool file
     *
     * @param name name of the tool
     * @param fullName full name of the tool, can be empty
     */
    public Tool(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
