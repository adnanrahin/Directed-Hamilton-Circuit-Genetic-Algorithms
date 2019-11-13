package directedhamiltoncircuit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> FileContent = readFile("/home/adnan/source-code/IdeaProjects/" +
                "Directed-Hamilton-Circuit-Genetic-Algorithms/sourceFile.txt");
        String v = FileContent.get(0);
        int NumberOfVertex = Integer.parseInt(v);
        Graph g = new Graph(NumberOfVertex);
        for (int i = 1; i < FileContent.size(); i++) {
            String arr[] = FileContent.get(i).split(" ");
            g.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }

        // print Graph
        String graphPath = g.printGraph();

        // Hamiltonian Circuit Algorithm
        HamiltoninCircuit hamiltoninCircuit = new HamiltoninCircuit(g);
        String solution = hamiltoninCircuit.hamCircuit();

        String printScreen = "Graph: \n" + graphPath + "Solution: \n" + solution;
        System.out.println(printScreen);
    }

    public static List<String> readFile(String filepath) {

        List<String> fileContents = new ArrayList<>();

        try (Scanner input = new Scanner(new FileReader(filepath))) {

            while (input.hasNextLine()) {
                String string = input.nextLine();
                fileContents.add(string);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileContents;
    }
}
