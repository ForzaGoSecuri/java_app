import Tools.Tool;
import Tools.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Objects;

public class TestTools {
    final private String name = "name";
    final private String fullName = "fullName";

    private Tool toolMock(){
        return new Tool(name, fullName);
    }

    private Tools toolsMock() throws FileNotFoundException {
        return new Tools();
    }

    private String[] getToolName(){
        return new String[]{
                "mousqueton",
                "gants",
                "brassard",
                "menottes",
                "cyno",
                "talky",
                "lampe",
                "kit",
                "taser",
                "lacrymo",
        };
    }

    private String[] getToolFullName(){
        return new String[]{
                "Mousqueton",
                "Gants d’intervention",
                "Brassard de sécurité",
                "Porte menottes",
                "Bandeau agent cynophile",
                "Talkies walkies",
                "Lampe Torche",
                "Kit oreillette",
                "Tasers",
                "Bombes lacrymogènes",
        };
    }

    @Test
    public void testToolName(){
        Assert.assertEquals(name, toolMock().getName());
    }

    @Test
    public void testToolFullName(){
        Assert.assertEquals(fullName, toolMock().getFullName());
    }

    @Test
    public void testToolsListNameParsed() throws FileNotFoundException {
        boolean result = true;
        Tools tools = toolsMock();

        for(int i = 0; i<tools.getTools().size(); i++){
            if (!Objects.equals(tools.getTools().get(i).getName(), getToolName()[i])) {
                System.out.println(tools.getTools().get(i).getName()+" different of "+getToolName()[i]);
                result = false;
                break;
            }
        }

        Assert.assertTrue(result);
    }

    @Test
    public void testToolsListFullNameParsed() throws FileNotFoundException {
        boolean result = true;
        Tools tools = toolsMock();

        for(int i = 0; i<tools.getTools().size(); i++){

            String resultFullName = tools.getTools().get(i).getFullName();
            String awaitFullName = getToolFullName()[i];

            if (!Objects.equals(resultFullName, awaitFullName)){
                System.out.println(resultFullName+" different of "+awaitFullName);
                result = false;
                break;
            }
        }

        Assert.assertTrue(result);
    }
}
