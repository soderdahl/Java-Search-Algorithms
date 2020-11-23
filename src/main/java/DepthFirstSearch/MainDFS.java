package DepthFirstSearch;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;

public class MainDFS {

    public static void main(String[] args) throws IOException {
         File file1 = new File("src/main/resources/363-hard-words.txt");
        File file = new File("src/main/resources/selected four-letter words.txt");
         List<String> strings = Words.readFile(file);


        Words wordObj = new Words();
        List<Vertex> vertices = wordObj.constructVertex(strings);
        wordObj.addNeighbours(vertices);
        List<List<String>> wordList = new ArrayList<>();
        for (Vertex v: vertices) {
            System.out.println("Word: "+ v + "\n" +v.getNeighbourList());
                 }


        wordObj.writeFile("src/main/resources/result.txt", vertices);


    }
}






