package DepthFirstSearch;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Words {



    public static List<String> readFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            List<String> collect = bufferedReader.lines().collect(Collectors.toList());
            bufferedReader.close();
            return collect;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeFile(String fileName, List<Vertex> wordList) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
    try {
        fw = new FileWriter(new File(fileName));
        bw = new BufferedWriter(fw);
        for (int i = 0; i < wordList.size(); i++) {
            bw.write(wordList.get(i).getNeighbourList().toString());

            bw.write("\n");
    }

        }catch (Exception e) {
        System.out.println("Error "+ e.getMessage());
        throw e;
    } finally {
        try {
            bw.close();
        } catch (Exception e) {
        }
        try {
            fw.close();
        } catch (Exception e) {
        }
    }
    }

    public static List<String> dfsStrings(Optional<List<String>> strings) {
        List<String> result = new ArrayList<>();
        String s1 = strings.get().get(0);
        result.add(s1);
        dfsStringMatch(s1, strings, result);
        return result;
    }

   public static List<String> dfsStringMatch(String s1, Optional<List<String>> strings, List<String> result) {
        for (int i = 1; i< strings.get().size() ;i++) {
            List<Integer> indexList = new ArrayList<>();
            String s2 = strings.get().get(i);
            for (int j = 0; j < s2.length(); j++){
                char c = s2.charAt(j);
                String s = String.valueOf(c);

                for (int k = 0; k < s1.length(); k++) {
                    if (s.matches(String.valueOf(s1.charAt(k))) && !indexList.contains(k)) {
                        indexList.add(k);
                    }
                }
                System.out.println("C: "+c);
            }
            //System.out.println("CharList: "+indexList);
            if (indexList.size() >2){
                result.add(s2);
                s1 = s2;
            }
        }
        System.out.println("Result" +result);
        return result;
    }

    public List<Vertex> constructVertex(List<String> strings) {

        return strings.stream().map(s -> new Vertex(s)).collect(Collectors.toList());
    }
    public void addNeighbours(List<Vertex> vertices) {
        vertices.stream().forEach(v -> checkForNeighbuor(vertices, v));
    }

    public boolean isNeighbour(String word1, String word2){
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i< word1.length(); i++ ) {
            char c = word1.charAt(i);
            for (int k = 0; k < word2.length(); k++) {
                if (c == word2.charAt(k) && !indexList.contains(k)) {
                    indexList.add(k);
                    break;
                }
            }
        }
       return indexList.size() > 2;

    }

    public void checkForNeighbuor(List<Vertex> vertexList, Vertex currentVertex) {

        for (int i = 0; i < vertexList.size(); i++) {
            if (currentVertex.equals(vertexList.get(i))){
                continue;
            }
            if (isNeighbour(currentVertex.getName(),vertexList.get(i).getName())){
              currentVertex.addNeighbour(vertexList.get(i));
            }
        }
    }

}
