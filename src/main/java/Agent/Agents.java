package Agent;

import Tools.Tool;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agents {
    private final List<Agent> agents = new ArrayList<>();

    public Agents() throws FileNotFoundException {
        this.parseFiles();
    }

    /**
     * get all agent files
     */
    public void parseFiles() throws FileNotFoundException {
        List<String> agentsContent = new ArrayList<>();

        // get file containing agents list
        String agentsListFilePath = "C:\\Users\\Utilisateur\\Desktop\\mspr_dev_appli\\src\\main\\java\\files\\agents\\agents.txt";
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
            File agentFile = new File("C:\\Users\\Utilisateur\\Desktop\\mspr_dev_appli\\src\\main\\java\\files\\agents\\"+filename+".txt");
            Scanner agentData = new Scanner(agentFile);
            while(agentData.hasNextLine()){
                // fill variable
                switch (count){
                    case 0:
                        lastname = agentData.nextLine();
                        break;

                    case 1:
                        firstname = agentData.nextLine();
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
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
