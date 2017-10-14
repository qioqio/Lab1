package com.untitled.wordgraph;
//2.4change
import java.io.*;
import java.util.*;

import static guru.nidi.graphviz.model.Factory.*;

import guru.nidi.graphviz.attribute.*;
import guru.nidi.graphviz.engine.*;
import guru.nidi.graphviz.model.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PanelNewText extends PanelApp {
    private JTextArea inputTextArea, outputTextArea;
    private JButton button;

    public PanelNewText() {

        setLookAndFeel();

        inputTextArea = new JTextArea("请输入文本", 10, 20);
        inputTextArea.setFont(myFont);

        outputTextArea = new JTextArea("输出文本", 10, 20);
        
        
       // "test"
        
        outputTextArea.setFont(myFont);
        button = new JButton("生成新文本");
        button.setFont(myFont);
        add(inputTextArea);
        add(button);
        add(outputTextArea);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    WordGraph WG = getWordGraph(initialWords);
                    outputTextArea.setText(generateNewText(WG, inputTextArea.getText()));
                } catch (NullPointerException npe) {
                    JOptionPane.showMessageDialog(null, "请输入文本文件", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private static String generateNewText(WordGraph G, String inputText) {
        String[] words = inputText.replaceAll("[^a-zA-Z ]", " ").replaceAll("\\s+", " ").trim().split(" ");
        Random rand = new Random();
        String newText = new String();
        for (int i = 0; i + 1 < words.length; i++) {
            newText += words[i] + " ";
            String[] bridgeWords = queryBridgeWordsList(G, words[i].toLowerCase(), words[i + 1].toLowerCase());
            if (bridgeWords.length != 0) {
                int j = rand.nextInt(bridgeWords.length);
                newText += bridgeWords[j] + " ";
            }
        }
        if (words.length > 0)
            newText += words[words.length - 1];
        return newText;
    }

}
