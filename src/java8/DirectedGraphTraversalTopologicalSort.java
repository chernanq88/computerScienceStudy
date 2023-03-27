package java8;

import java.util.*;

public class DirectedGraphTraversalTopologicalSort {
    static class Node{

        String name;
        List<Node> adjacentNodes= new ArrayList<>();
        Node(String name){
            this.name=name;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Node)obj).name.equals(this.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        Node a=new Node("A");
        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node e=new Node("E");
        Node f=new Node("F");
        Node g=new Node("G");
        Node h=new Node("H");

        a.adjacentNodes.add(c);
        b.adjacentNodes.addAll(Arrays.asList(c,d));
        c.adjacentNodes.add(e);
        d.adjacentNodes.add(f);
        e.adjacentNodes.addAll(Arrays.asList(h,f));
        f.adjacentNodes.add(g);

        List<Node> nodos=new ArrayList<>(Arrays.asList(a,b,c,d,e,f,g,h));

        nodos.stream().forEach(DirectedGraphTraversalTopologicalSort::traverseGraph);

        Collections.reverse(topologicalSort);

        System.out.println(topologicalSort);

    }
    private static final Set<Node> visitados= new HashSet<>();
    private static final Stack<Node> topologicalSort= new Stack<>();
    private static void traverseGraph(Node node) {

        if (!visitados.contains(node)){
            System.out.println(node.name);
            visitados.add(node);
        }else{
            return;
        }
        node.adjacentNodes.forEach(adjacente-> traverseGraph(adjacente));

        //Topological Sort executes when a visited node is about to be left
        topologicalSort.push(node);
    }

}
