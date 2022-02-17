package Agent;

import Tools.Tools;
import Tools.Tool;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Agents {
    private final List<Agent> agents = new ArrayList<>();
    Tools tools = new Tools();

    public Agents() {}

    /**
     * get all agent files
     */
    public void parseFiles() throws FileNotFoundException {
        List<String> agentsContent = new ArrayList<>();

        // get file containing agents list
        String agentsListFilePath = "files/agents/agents.txt";
        File agentsList = new File(agentsListFilePath);

        //read file containing agents list
        Scanner listReader = new Scanner(agentsList);
        while (listReader.hasNextLine()){
            agentsContent.add(listReader.nextLine());
        }

        // get all agent get in previous file
        for(String filename : agentsContent){
            // variable used for agent
            String firstname = "";
            String lastname = "";
            String mission = "";
            String password = "";
            List<Tool> tools = new ArrayList<>();

            int count = 0; // used to know which variable fill

            // read corresponding agent file
            File agentFile = new File("files/agents/"+filename+".txt");
            Scanner agentData = new Scanner(agentFile);
            while(agentData.hasNextLine()){
                // fill variable
                switch (count){
                    case 0:
                        firstname = agentData.nextLine();
                        break;

                    case 1:
                        lastname = agentData.nextLine();
                        break;

                    case 2:
                        mission = agentData.nextLine();
                        break;

                    case 3:
                        password = agentData.nextLine();
                        break;

                    case 4:
                        break;

                    default:
                        tools.add(new Tool(agentData.nextLine(), ""));
                        break;
                }
                count++;
            }

            // add agent
            agents.add(new Agent(lastname, firstname, password, mission, tools));
        }

        System.out.println(agents.size());
    }

    /**
     * add new agent
     *
     * @param lastname agent lastname
     * @param firstname agent firstname
     * @param password agent password
     * @param mission agent mission
     * @param toolsName agent tools to attribute
     * @return boolean
     */
    public boolean addAgent(String lastname, String firstname, String password, String mission, List<String> toolsName){
        // check if the agent already exist
        if (!agentExist(lastname, firstname)){
            Agent newAgent = new Agent(lastname, firstname, password, mission, tools.getBunchOfTools(toolsName));
            agents.add(newAgent);
            return true;
        }
        return false;
    }

    /**
     * check if agent exist
     *
     * @param lastname agent lastname
     * @param firstName agent firstname
     * @return boolean
     */
    private boolean agentExist(String lastname, String firstName){
        for(Agent agent: agents){
            if (Objects.equals(agent.getLastname(), lastname) && Objects.equals(agent.getFirstname(), firstName)){
                return true;
            }
        }
        return false;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
