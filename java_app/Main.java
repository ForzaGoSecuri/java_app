import Agent.Agents;
import Html.HtmlBuilder;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        Agents agents = new Agents();
        agents.parseFiles();

//        HtmlBuilder builder = new HtmlBuilder();
//        builder.buildAgentFile();
    }
}
