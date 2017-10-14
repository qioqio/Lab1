//b1
package com.untitled.wordgraph;

import java.util.HashMap;

import static guru.nidi.graphviz.model.Factory.*;
import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.*;
import guru.nidi.graphviz.model.*;

public class WordGraph {
    public HashMap<String, WordNode> nodes;
    public String color;

    public WordGraph() {
        nodes = new HashMap<String, WordNode>();
        color = "black";
    }
}
