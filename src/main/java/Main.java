import Html.HtmlBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlBuilder builder = new HtmlBuilder();
        builder.buildAgentsFilesHTML();
        builder.buildListToolsFile();
    }
}
