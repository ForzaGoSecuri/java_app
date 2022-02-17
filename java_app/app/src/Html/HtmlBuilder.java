package Html;

import Agent.Agent;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HtmlBuilder {
    private final Integer FILESIZE = 50000;
    private final String DIRECTORY = "files/html";
    private final String FILEEXT = ".html";

    public HtmlBuilder() {
    }

    /**
     * build single agent html file
     */
    public void buildAgentFile() throws IOException {
        String filename = "agents";
        String content = """
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
                                            <a class="nav-link active" aria-current="page" href="#">page1</a>
                                            <a class="nav-link active" aria-current="page" href="#">page2</a>
                                            <a class="nav-link active" aria-current="page" href="#">page3</a>
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
                                <h1 class="text-nowrap">{firstname} {name}</h1>
                                <p class="mt-5">{mission}</p>
                            </div>
                            <img src="https://picsum.photos/500/300" alt="piéce identité {firstname} {name}">
                        </section>
                                    
                        <section class="mt-5 w-25">
                            <h2 class="text-center">Liste materiels</h2>
                            <table class="table mt-3">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">{number}</th>
                                    <td>{name}</td>
                                </tr>
                                </tbody>
                            </table>
                        </section>
                    </main>
                </body>
                </html>
                    """;

        System.out.println(content);
        this.makeFileAndWriteInto(filename, content);
    }

    /**
     * build listing of all agents html file
     */
    public void buildListAgentFile() throws IOException {
        String filename = "listAgents";

        String content = """
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
                                                <a class="nav-link active" aria-current="page" href="#">agents</a>
                                                <a class="nav-link active" aria-current="page" href="#">materiels</a>
                                                <a class="nav-link active" aria-current="page" href="#">page3</a>
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
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">{name}</th>
                                <td>{firstname}</td>
                            </tr>
                            </tbody>
                        </table>
                    </main>
                </body>
                </html>
                    """;

        System.out.println(content);
        this.makeFileAndWriteInto(filename, content);
    }

    /**
     * build listing of all tools html file
     */
    public void buildListToolsFile() throws IOException {
        String filename = "listTools";

        String content = """
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
                                                <a class="nav-link active" aria-current="page" href="#">agents</a>
                                                <a class="nav-link active" aria-current="page" href="#">materiels</a>
                                                <a class="nav-link active" aria-current="page" href="#">page3</a>
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
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">{name}</th>
                            </tr>
                            </tbody>
                        </table>
                    </main>
                </body>
                </html>
                    """;

        System.out.println(content);
        this.makeFileAndWriteInto(filename, content);
    }

    /**
     * make file and write content given into
     */
    private void makeFileAndWriteInto(String filename, String content) throws IOException {
        File file = new File(DIRECTORY+"/"+filename+FILEEXT);

        try{
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream br = new BufferedOutputStream(os, FILESIZE);
            br.write(content.getBytes(StandardCharsets.UTF_8));
            br.close();
        } catch (IOException exception){
            // create directory if not exist
            Files.createDirectory(Paths.get(DIRECTORY));

            // write content
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream br = new BufferedOutputStream(os, FILESIZE);
            br.write(content.getBytes(StandardCharsets.UTF_8));
            br.close();
        }
    }
}