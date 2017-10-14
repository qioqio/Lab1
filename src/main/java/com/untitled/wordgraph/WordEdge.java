//b1
package com.untitled.wordgraph;

import guru.nidi.graphviz.attribute.Color;

public class WordEdge {
    public WordNode to;
    public int weight;
    public Color color;
    public boolean visited;

    public WordEdge(WordNode _to) {
        to = _to;
        weight = 1;
        color = Color.BLACK;
        visited = false;
    }

    public void incWeight() {
        weight += 1;
    }
    //c41
}

// "test"