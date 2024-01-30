package com.estructuras.datastrutures.graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*Graphs
*
* A graph is a data structure for storing connected data such as a network of people on a social media platform.
*
* How it works?
*
* A graph consists of vertices and edges. A vertex represents the entity (e.g., people) and an
* edge represents the relationship between entities (e.g., a person’s friendships).
*
* Weighted Graph
*
* If instead these edges carry relative weight, this graph is known as a weighted graph.
*
*Graph Representations
*
* Can be represented in different forms such as adjacency matrix and adjacency list
*
*Adjacency Matrix
*
* An adjacency matrix is a square matrix with dimensions equivalent to the number of vertices in the graph.
* The elements of the matrix typically have values 0 or 1. A value of 1 indicates adjacency between the vertices in the row and column and a value of 0 otherwise.
*
*
*Adjacency List
*
*
*An adjacency list is nothing but an array of lists. The size of the array is equivalent to the number of vertices in the graph.
*
*The list at a specific index of the array represents the adjacent vertices of the vertex represented by that array index.
*
*
*
*
*
*
* a graph is nothing but a collection of vertices and edges that can be represented
* as either an adjacency matrix or an adjacency list
*
* */
public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;




    public void addVertex(String label){
        this.adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label){
        Vertex v = new Vertex(label);
        this.adjVertices.values().stream().forEach(e ->e.remove(e));
        this.adjVertices.remove(new Vertex(label));
    }

    //add Edge

    public void addEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        this.adjVertices.get(v1).add(v2);
        this.adjVertices.get(v2).add(v1);
    }


    public void removeEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> eV1 = this.adjVertices.get(v1);
        List<Vertex> eV2 = this.adjVertices.get(v2);

        if(eV1 != null)
            eV1.remove(v2);
        if(eV2 != null)
            eV2.remove(v1);

    }


    public List<Vertex> getAdjVertices(String label){
        return  adjVertices.get( new Vertex(label));
    }



}
