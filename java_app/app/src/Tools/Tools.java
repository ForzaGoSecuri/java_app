package Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tools {
    private List<Tool> tools;


    /**
     * add new tool in the list
     *
     * @param name name of the new tool
     * @param fullName full name of new the tool
     */
    public boolean addTool(String name, String fullName){
        // check if the tool already exist
        for(Tool tool : tools){
            if (Objects.equals(tool.getName(), name)){
                return false;
            }
        }

        // add tool
        Tool newTool = new Tool(name, fullName);
        this.tools.add(newTool);

        return true;
    }

    /**
     * @param name new name of the tool
     * @param fullName new full name of the tool
     * @return boolean
     */
    public boolean updateTool(String name, String fullName){
        for(Tool tool : tools){
            if (Objects.equals(tool.getName(), name)){
                tool.setName(name);
                tool.setFullName(fullName);
                return true;
            }
        }
        return false;
    }

    /**
     * remove tool
     *
     * @param name name of the deleted object
     * @return boolean
     */
    public boolean removeTool(String name){
        for(Tool tool : tools){
            if (Objects.equals(tool.getName(), name)){
                tools.remove(tool);
                return true;
            }
        }
        return false;
    }

    /**
     * get specified tools with the given string name list
     * @param toolsName tools name to get
     * @return List<Tool>
     */
    public List<Tool> getBunchOfTools(List<String> toolsName){
        List<Tool> toolList = new ArrayList<Tool>();

        for(Tool tool : tools){
            for(String toolName : toolsName){
                if (Objects.equals(tool.getName(), toolName)){
                    toolList.add(tool);
                    toolsName.remove(toolName);
                }
            }
        }

        return toolList;
    }

    public List<Tool> getTools() {
        return tools;
    }
}
