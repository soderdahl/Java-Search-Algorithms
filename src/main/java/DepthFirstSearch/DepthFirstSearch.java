package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class DepthFirstSearch {

    private List<Vertex> maxStack;
    private int maxLength = 0;

    public DepthFirstSearch() {
        this.maxStack = new Stack();
    }



    public void dfs(List<Vertex> vertexList) {
           Vertex v = vertexList.get(0);
                //v.setVisited(true);
                dfsRecursive(v, new Stack());
                System.out.println("MaxLength: " +maxLength);
        for (Vertex maxV: maxStack ) {
            System.out.println("Max vertex: " +maxV);
        }


    }

    private void dfsRecursive(Vertex v, Stack stack) {
        stack.push(v);

        if (v.getNeighbourList().isEmpty()) {
            int size =stack.size();
            System.out.println("Size: "+ size);
            if (size > maxLength) {
                maxLength = size;
                this.maxStack = new ArrayList<>(stack);
            }

        }
        for (Vertex neighbor: v.getNeighbourList()) {
            if (stack.contains(neighbor)) {
                continue;
        }
            dfsRecursive(neighbor, stack);

    }
            stack.pop();


    }





/*
    private void dfsWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while (!stack.empty()) {

            Vertex actualVertex = this.stack.pop();
            System.out.println(actualVertex+ " ");

            for (Vertex v : actualVertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                  //  int size = this.stack.size();
                   // System.out.println("Size: "+size);
                }

            }
        }*/
}
