import Agent.Agent;
import Tools.Tools;
import Tools.Tool;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class TestAgents {
    final private String lastname = "lastname";
    final private String firstname = "firstname";
    final private String password = "password";
    final private String surname = "flastname";
    final private String mission = "mission";

    private Agent agentMock() throws FileNotFoundException {
        Tools tools = new Tools();
        return new Agent(lastname, firstname, password, mission, tools.getTools());
    }

    @Test
    public void testAgentFirstName() throws FileNotFoundException {
        Assert.assertEquals(firstname, agentMock().getFirstname());
    }

    @Test
    public void testAgentLastName() throws FileNotFoundException {
        Assert.assertEquals(lastname, agentMock().getLastname());
    }

    @Test
    public void testAgentSurName() throws FileNotFoundException {
        Assert.assertEquals(surname, agentMock().getSurname());
    }

    @Test
    public void testAgentPassword() throws FileNotFoundException {
        Assert.assertEquals(password, agentMock().getPassword());
    }

    @Test
    public void testAgentMision() throws FileNotFoundException {
        Assert.assertEquals(mission, agentMock().getMission());
    }

}
