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
    }

    /**
     * TODO build the html using the standard output in a file
     */
    public void buildHtml(){

    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
