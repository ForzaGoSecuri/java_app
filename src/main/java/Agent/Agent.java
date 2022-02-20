package Agent;

import Tools.Tool;

import java.util.List;

public class Agent {
    String lastname;
    String firstname;
    String password;
    String surname;
    String mission;
    List<Tool> tools;

    public Agent(String lastname, String firstname, String password, String mission, List<Tool> tools) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.mission = mission;
        this.tools = tools;
        this.surname = firstname.toLowerCase().charAt(0)+lastname.toLowerCase();
    }

    public List<Tool> getTools() {
        return tools;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getMission() {
        return mission;
    }

    public String getPassword() {
        return password;
    }

}
