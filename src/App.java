import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
        FreqMat sampleFreqT;
        LSI LSIfreqT;
        Query query;
    

        clearScreen();
        System.out.println("\nWELCOME\n");

        System.out.println("\nOriginal Frequency Matrix");
        sampleFreqT = new FreqMat(12, 40);
        sampleFreqT.showFreqMat();

        System.out.println("\nReduced Frequency Matrix");
        LSIfreqT = new LSI(sampleFreqT);
        LSIfreqT.showFreqMatLSI();

        System.out.println("\nMAKE QUERIES:\n");
        query = new Query(sampleFreqT, LSIfreqT);
        // QUERY 1
        System.out.println("(1) Given 2 documents (D1, D2), evaluate their degree of dissimilarity with Euclidean distance\n");
        System.out.print("Enter the index (0-11) of the column that represents D1: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter the index (0-11) of the column that represents D2: ");
        int id2 = scanner.nextInt();
        query.makeQuery1(id1,id2);
        // QUERY 2
        System.out.println("(2) Given a query Q, obtain the n most relevant documents to answer Q\n");
        System.out.println("There are 12 documents, this retrieves the n most relevant to answer the query");
        System.out.print("Set a value (1-12) for n: ");
        int n = scanner.nextInt();
        query.makeQuery2(n);

        scanner.close(); 
    }

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
