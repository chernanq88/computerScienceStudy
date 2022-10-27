package graphs.undirected;


import java.util.*;

/**
 *
 * Tree: Connected graph with no cicles
 *       with only one component
 *
 *
 *
 *
 */
public class CycleDetection {


    /**
     * Node = Edge
     */
    static class Node {

        String identifier;
        private List<Node> edges=new ArrayList<>();

        Node(String identifier){
            this.identifier=identifier;
        }

    }


    /**
     *
     *
     *  Undirected graph only requires simple DFS, Do need to cache extra values of visited nodes
     *
     *              Component 1        Component2
     *
     *              A ---- C
     *
     *              |      |
     *              |      |
     *              |      |
     *
     *              B ---- E
     *              |
     *              |
     *              |
     *
     *              D ----- F          G ------ H
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        Node b=new Node("B");
        Node c=new Node("C");
        Node d=new Node("D");
        Node a=new Node("A");
        Node e=new Node("E");
        Node f=new Node("F");
        Node g=new Node("G");
        Node h=new Node("H");
        a.edges.addAll(List.of(b,c));
        c.edges.addAll(List.of(a,e));
        b.edges.addAll(List.of(a,e,d));
        f.edges.addAll(List.of(d));
        d.edges.addAll(List.of(f,b));

        List<Node> nodes=List.of(a,b,c,d,e,f,g,h);



        Boolean isThereACycle= isThereACycle(a, new HashMap<>(),null);
        System.out.println("Is there a cycle? " + isThereACycle);

        b=new Node("B");
        c=new Node("C");
        d=new Node("D");
        a=new Node("A");
        e=new Node("E");
        f=new Node("F");

        a.edges.addAll(List.of(b,c));
        c.edges.addAll(List.of(a));
        b.edges.addAll(List.of(a,e,d));
        f.edges.addAll(List.of(d));
        d.edges.addAll(List.of(f,b));


        isThereACycle= isThereACycle(a, new HashMap<>(),null);
        System.out.println("Is there a cycle? " + isThereACycle);



    }



    /**
     *
     * Pass the slate of visited and find later if the parent was visited before
     *
     * @param n
     * @param visited
     * @param parent
     * @return
     */
    static boolean isThereACycle(Node n, Map<String, Boolean> visited, Node parent){

        System.out.println("Visiting node " + n.identifier);

        visited.put(n.identifier, true);

        for (Node node : n.edges) {

            /**
             If the parent is in the adjacency list, do not move to that direction
             */
            if(parent!=null && parent.identifier.equals(node.identifier))
                continue;


            if (visited.getOrDefault(node.identifier,false))
                return true;

            /**
             run dfs on the node and verify there is no cycle
             */
            if ( isThereACycle(node, visited, n))
                return true;
        }

        return false;
    }
}
