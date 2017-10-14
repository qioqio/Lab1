//b1

package com.untitled.wordgraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import static guru.nidi.graphviz.model.Factory.*;
import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.*;
import guru.nidi.graphviz.model.*;

public class WordNode implements Comparable<WordNode> {
    static final int INF = Integer.MAX_VALUE;
    public HashMap<String, WordEdge> edges;
    public String text;

    // for painting
    public Color color;
    public Node node;

    // for calculating the shortest path
    
    
    
    
    //b1
    public HashSet<WordNode> pre;
    public TreeSet<WordNode> suc;
    public int distance;
    public boolean visited;
    public int countPaths;
 
    public WordNode(String _text) {
        text = _text;
        edges = new HashMap<String, WordEdge>();
        color = Color.WHITE;
    }

    public void addEdge(WordNode v) {
        if (edges.containsKey(v.text)) {
            edges.get(v.text).incWeight();
        } else {
            edges.put(v.text, new WordEdge(v));
        }
    }

    public boolean hasEdge(String text) {
        return edges.containsKey(text);
    }
    
    public int compareTo(WordNode rhs) {
        return text.compareTo(rhs.text);
    }
}
