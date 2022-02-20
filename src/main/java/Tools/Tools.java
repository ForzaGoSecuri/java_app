package Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tools {
    private List<Tool> tools = new ArrayList<>();

    public Tools() throws FileNotFoundException {
        this.parseFile();
    }

    /**
     * parse tools file for getting tools
     */
    private void parseFile() throws FileNotFoundException {
        List<String> toolsContent = new ArrayList<>();

        // get file containing agents list
        String toolsListFilePath = "C:\\Users\\Utilisateur\\Desktop\\mspr_dev_appli\\src\\main\\java\\files\\agents\\tools.txt";
        File toolList = new File(toolsListFilePath);

        //read file containing tools list
        Scanner listReader = new Scanner(toolList);
        while (listReader.hasNextLine()){
            toolsContent.add(listReader.nextLine());
        }

        // get all tools get in previous file
        for(String tool : toolsContent){
            // variable used for tools
            String name = "";
            String fullname = "";

            // build name and fullname
            String[] parts = tool.split(" ");
            boolean isName = true;
            for(String part : parts){
                if (isName){
                    name = part;
                    isName = false;
                }else{
                    fullname += part+' ';
                }
            }
            tools.add(new Tool(name, fullname.trim()));
        }
    }

    public List<Tool> getTools() {
        return tools;
    }
}
