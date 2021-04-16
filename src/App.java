import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        FreqMat sampleFreqT;

        boolean to_continue = false;
        do{
            System.out.println("Welcome \nPress 'Y' key to create a sample Frequency Matrix");
            Scanner scanner= new Scanner(System.in);
            String userInput= scanner.nextLine();

            if (userInput.equals("Y") || userInput.equals("y")) {
                sampleFreqT = new FreqMat(12, 30);
                sampleFreqT.showFreqMat();

                System.out.println("Press 'Y' key to see LSI Frequency Matrix");
                userInput= scanner.nextLine();
                if (userInput.equals("Y") || userInput.equals("y")) {
                    LSI LSIfreqT = new LSI(sampleFreqT);
                    LSIfreqT.showFreqMatLSI();

                    System.out.println("Make a Query:\n");
                    System.out.println("(1) Given 2 docs (D1, D2), evaluate their degree of dissimilarity with Euclidean distance");
                    System.out.println("(2) Given a query Q, obtain the n most relevant documents to answer Q");
                    System.out.print("Press a number according to the query you want to make: ");
                    userInput= scanner.nextLine();
                    if (Integer.parseInt(userInput) == 1) {
                        System.out.print("Enter the index of the column that represents D1: ");
                        int d1 = scanner.nextInt();
                        System.out.print("Enter the index of the column that represents D2: ");
                        int d2 = scanner.nextInt();
                        // QUERY 1
                    }
                    else if(Integer.parseInt(userInput) == 2){
                        System.out.println("Press 'Y' key to create a sample Query");
                        userInput= scanner.nextLine();
                        if (userInput.equals("Y") || userInput.equals("y")) {
                            // GENERATE RANDOM QUERY
                        }
                        // QUERY 2
                    }
                }
            }
            
            System.out.println("Do you want to continue?\nPress 'Y' key to continue, or 'N' key to finish");
            userInput= scanner.nextLine();
            if (userInput.equals("Y") || userInput.equals("y")) {
                to_continue = true;
            }
            else if(userInput.equals("N") || userInput.equals("n")){
                to_continue = false;
            }
            scanner.close();
        }while(to_continue);
    }
}
