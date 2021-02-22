package Graphs;

import java.util.*;

public class TopologicalSorting {

    // give courses, can you finish them in an order (is there a topological sorting)?
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int pred[] = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int[] currCourse = prerequisites[i];
            int start = currCourse[1];
            int end = currCourse[0];
            if(graph.get(start) == null) graph.put(start, new ArrayList<>());
            graph.get(start).add(end);
            pred[end] += 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < pred.length; i++) {
            if (pred[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int vertex = q.poll();
            List<Integer> neighbours = graph.get(vertex);
            if (neighbours == null) continue;

            for(Integer n : neighbours) {
                pred[n] -= 1;
                if (pred[n] == 0) q.add(n);
            }
        }
        //check is cycle exists
        for(int i = 0; i < pred.length; i++)
            if (pred[i] != 0) return false;

        return true;
    }

    // give one of the topological orders
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] pred = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int[] currCourse = prerequisites[i];
            int start = currCourse[1];
            int end = currCourse[0];

            if (graph.get(start) == null) graph.put(start, new ArrayList<>());
            graph.get(start).add(end);
            pred[end] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;

        for(int i = 0; i < pred.length; i++) {
            if (pred[i] == 0) {
                q.add(i);
                order[index++] = i;
            }
        }

        while(!q.isEmpty()) {
            Integer vertex = q.poll();
            List<Integer> neighbours = graph.get(vertex);
            if(neighbours == null) continue;

            for(Integer n : neighbours) {
                pred[n] -= 1;
                if (pred[n] == 0) {
                    q.add(n);
                    order[index++] = n;
                }
            }
        }

        if (index == numCourses) return order;
        else return new int[0];
    }
}
