import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random; 
import Jama.Matrix;

public class Query {
    private FreqMat original;
    private LSI lsi;

    public Query(FreqMat freqT,LSI freqTLSI){
        this.original = freqT;
        this.lsi = freqTLSI;
    }

    
    public void makeQuery1(int i, int j){
        RealVector d1 = lsi.getFreqMatLSI().getColumnVector(i);
        RealVector d2 = lsi.getFreqMatLSI().getColumnVector(j);
        double dist = d1.getDistance(d2);
        System.out.print("Degree of dissimilarity: ");
        System.out.print(dist);
        System.out.println("\n\n");
    }


    public void makeQuery2(int n_most_relevats){
        RealMatrix query = this.createNewQuery();
        Matrix printableQ = new Matrix(query.getData());
        System.out.println("\nOriginal Query");
        printableQ.print(printableQ.getColumnDimension(), 0);

        RealMatrix queryLSI = query.transpose().multiply(lsi.getU_().multiply(lsi.getS_()));
        Matrix printableQLSI = new Matrix(queryLSI.transpose().getData());
        System.out.println("\nLSI Query");
        printableQLSI.print(printableQLSI.getColumnDimension(), 0);

        RealVector theQuery = queryLSI.getRowVector(0);

        int []similarities = new int[n_most_relevats];

        for (int i = 0; i < n_most_relevats; i++) {
            similarities[i]= i;
        }
        
        for (int i = 0; i < original.get_documents();i++) {
            RealVector v = lsi.getFreqMatLSI().getColumnVector(i);
            double current = theQuery.cosine(v);
            for (int j = 0; j < n_most_relevats; j++) {
                if(current>similarities[j]){
                    similarities[j] = i;
                }
            }
        }

        RealMatrix res = new Array2DRowRealMatrix(lsi.getFreqMatLSI().getRowDimension(),n_most_relevats);
        for (int i = 0; i < n_most_relevats; i++){
            res.setColumn(i, lsi.getFreqMatLSI().getColumn(similarities[i]));
        }

        Matrix result = new Matrix(res.getData());
        System.out.println("\nQuery Result");
        result.print(n_most_relevats, 3);
    }

    private RealMatrix createNewQuery(){
        Random R = new Random(); 
        int lim = this.original.get_terms();
        double []vec_q = new double[lim];	
        int i; 	
        for( i=0; i < lim; i++ ) {
            int num = R.nextInt(51);
            if(num%7==0){
                vec_q[i]= 0;
            }
            else{
                vec_q[i]= num; 
            }
        }	
        RealMatrix newQ= new Array2DRowRealMatrix(vec_q);
        return newQ;
    }
}
