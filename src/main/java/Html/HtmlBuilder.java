package Html;

import Agent.Agent;
import Agent.Agents;
import Tools.Tool;
import Tools.Tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlBuilder {

    public HtmlBuilder() {
    }

    /**
     * build single agent html file
     */
    private void buildAgentFile(Agent agent) throws IOException {
        String imgPath = "files/picture/"+agent.getSurname()+".png";
        String contentStart = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous" defer></script>
                    <title>GoSecuri</title>
                </head>
                <body>
                <header>
                    <nav class="navbar navbar-light bg-light fixed-top">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="#">Go-Securi</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                                <div class="offcanvas-header">
                                    <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                </div>
                                <div class="offcanvas-body">
                                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                        <li class="nav-item">
                                            <a class="nav-link active" aria-current="page" href="listAgents.html">Liste des agents</a>
                                            <a class="nav-link active" aria-current="page" href="listTools.html">Liste des outils</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </nav>
                </header>

                    <main class="d-flex flex-column justify-content-center align-items-center mt-5">
                        <section class="d-flex flex-row justify-space-around mt-5">
                            <div class="d-flex flex-column" style="margin-right: 25%">
                                <h1 class="text-nowrap">"""+ agent.getFirstname()+""" 
                                 """+agent.getLastname()+"""
                                </h1>
                                <p class="mt-5">"""+agent.getMission()+"""
            </p>
                            </div>
                            <img src='"""+imgPath+ """
                            ' alt="piéce identité\040"""+agent.getFirstname()+" "+agent.getLastname()+"""
                        ">
                        </section>
                                    
                        <section class="mt-5 w-25">
                            <h2 class="text-center">Liste materiels</h2>
                            <table class="table mt-3">
                                <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                </tr>
                                </thead>
                                <tbody>""";

                String contentList = "";
                                for(Tool tool : agent.getTools()){
                                    contentList += "<tr><td>"+tool.getName()+"</td></tr>";
                                }

                String contentEnd = """
                                </tbody>
                            </table>
                        </section>
                    </main>
                </body>
                </html>
                    """;

        String content = contentStart+contentList+contentEnd;
        this.makeHTMLFileAndWriteInto(agent.getSurname(), content);
    }

    /**
     * build listing of all agents html file
     */
    private void buildListAgentFile(Agents agents) throws IOException {
        String filename = "listAgents"; // html page name

        String contentStart = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous" defer></script>
                    <title>GoSecuri</title>
                </head>
                <body>
                    <header>
                        <nav class="navbar navbar-light bg-light fixed-top">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="#">Go-Securi</a>
                                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                                    <div class="offcanvas-header">
                                        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                                        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                    </div>
                                    <div class="offcanvas-body">
                                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                            <li class="nav-item">
                                                <a class="nav-link active" aria-current="page" href="listAgents.html">Liste des agents</a>
                                                <a class="nav-link active" aria-current="page" href="listTools.html">Liste des outils</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </header>
                               
                    <main class="d-flex flex-column justify-content-center align-items-center mt-5">
                        <h1 class="text-center">Liste des agents</h1>
                        <table class="table mt-5 w-50 text-center">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Firstname</th>
                                <th scope="col">Show more</th>
                            </tr>
                            </thead>
                            <tbody>""";

        String contentList= "";
        for(Agent agent : agents.getAgents()){
            contentList += "<tr><th scope=\"row\">"+agent.getLastname()+"</th><td>"+agent.getFirstname()+"</td><td><a href='"+agent.getSurname()+".html'>Show more</a></td></tr>";
        }

        String contentEnd = """
                            </tbody>
                        </table>
                    </main>
                </body>
                </html>
                    """;

        String content = contentStart+contentList+contentEnd;
        System.out.println(content);
        this.makeHTMLFileAndWriteInto(filename, content);
    }

    /**
     * build agents html file
     */
    public void buildAgentsFilesHTML() throws IOException {
        Agents agents = new Agents();
        this.buildListAgentFile(agents);
        for (Agent agent : agents.getAgents()){
            this.buildAgentFile(agent);
        }
    }

    /**
     * build listing of all tools html file
     */
    public void buildListToolsFile() throws IOException {
        String filename = "listTools";
        Tools tools = new Tools();

        String contentStart = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous" defer></script>
                    <title>GoSecuri</title>
                </head>
                <body>
                    <header>
                        <nav class="navbar navbar-light bg-light fixed-top">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="#">Go-Securi</a>
                                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                                    <div class="offcanvas-header">
                                        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                                        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                    </div>
                                    <div class="offcanvas-body">
                                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                            <li class="nav-item">
                                                <a class="nav-link active" aria-current="page" href="listAgents.html">Liste des agents</a>
                                                <a class="nav-link active" aria-current="page" href="listTools.html">Liste des outils</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </header>
                               
                    <main class="d-flex flex-column justify-content-center align-items-center mt-5">
                        <h1 class="text-center">Liste du matériel</h1>
                        <table class="table mt-5 w-50 text-center">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Fullname</th>
                            </tr>
                            </thead>
                            <tbody>""";
        String contentList = "";
        for(Tool tool : tools.getTools()){
            contentList += "<tr><td scope='row'>"+tool.getName()+"</td><td scope='row'>"+tool.getFullName()+"</td></tr>";
        }
        String contentEnd = """
                            </tbody>
                        </table>
                    </main>
                </body>
                </html>
                    """;

        String content = contentStart+contentList+contentEnd;
        this.makeHTMLFileAndWriteInto(filename, content);
    }

    /**
     * make file and write content given into
     */
    private void makeHTMLFileAndWriteInto(String filename, String content) throws IOException {
        String directory = "C:\\Users\\Utilisateur\\Desktop\\mspr_dev_appli\\src\\main\\java\\files\\html";
        int fileSize = 50000;
        String fileExt = ".html";
        File file = new File(directory+"/"+filename+fileExt);

        try{
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream br = new BufferedOutputStream(os, fileSize);
            br.write(content.getBytes(StandardCharsets.UTF_8));
            br.close();
        } catch (IOException exception){
            // create directory if not exist
            Files.createDirectory(Paths.get(directory));

            // write content
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream br = new BufferedOutputStream(os, fileSize);
            br.write(content.getBytes(StandardCharsets.UTF_8));
            br.close();
        }
    }
}