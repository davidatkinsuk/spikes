package uk.co.davidatkins.spikes;

import lombok.Data;
import lombok.NonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Trees {

    private TreeNode root;

    @BeforeEach
    public void setup() {

        root = TreeNode.build(
                "root",
                TreeNode.build(
                        "a",
                        TreeNode.build(
                                "aa"
                        ),
                        TreeNode.build(
                                "ab"
                        )
                ),
                TreeNode.build(
                        "b",
                        TreeNode.build(
                                "ba"
                        ),
                        TreeNode.build(
                                "bb",
                                TreeNode.build(
                                        "bba"
                                )
                        )
                )
        );

    }

    @Test
    public void listDepthFirstTestRecursive() {

        StringBuilder output =new StringBuilder();
        listDepthFirstRecursive(root,output);
        assertEquals("aa,ab,a,ba,bba,bb,b,root,",output.toString());
    }

    public void listDepthFirstRecursive(TreeNode node, StringBuilder output) {

        node.children.forEach(n -> listDepthFirstRecursive(n,output));
        output.append(node.name);
        output.append(",");

    }


    @Test
    public void listBreadthFirstTestRecursive() {

        StringBuilder output =new StringBuilder();
        LinkedList queue = new LinkedList<>();
        queue.push(root);
        listBreadthFirstRecursive(queue,output);
        assertEquals("root,a,b,aa,ab,ba,bb,bba,",output.toString());
    }

    public void listBreadthFirstRecursive(LinkedList<TreeNode> queue, StringBuilder output) {

        if(queue.isEmpty()) {
            return;
        }

        TreeNode node = queue.poll();

        output.append(node.name);
        output.append(",");

        for(TreeNode child : node.children) {
            queue.add(child);
        }

        listBreadthFirstRecursive(queue, output);

    }



    public static class TreeNode {

        private String name;
        private List<TreeNode> children;

        public static TreeNode build(String name, TreeNode... children) {

            TreeNode node = new TreeNode();
            node.name = name;
            node.children = Arrays.asList(children);
            return node;

        }

    }

}
