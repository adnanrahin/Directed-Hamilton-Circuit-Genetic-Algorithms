package directedhamiltoncircuit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> filecontent = readFile("/home/adnan/source-code/IdeaProjects/Directed-Hamilton-Circuit-Genetic-Algorithms/sourceFile.txt");
        Graph g = new Graph(5);

        System.out.println("Graph:");

        for (String str : filecontent) {
            String arr[] = str.split(" ");
            g.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }

        // print Graph
        g.printGraph();

        // Hamiltonian Circuit Algorithm
        System.out.println("Backtracking Hamiltonian Circuit Algorithm:");
        HamiltoninCircuit hamiltoninCircuit = new HamiltoninCircuit(g);
        hamiltoninCircuit.hamCircuit(g);
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
