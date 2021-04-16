import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import java.util.Random; 
import Jama.Matrix;

public class FreqMat{
    private RealMatrix freqMat;
    public FreqMat(int documents, int terms){
        Random R = new Random(); 
        double [][]frecT = new double[terms][documents];	
        int i,j; 	
        for( i=0; i < terms; i++ ) {
            for( j=0; j < documents; j++ ) {
                int num = R.nextInt(51);
                if(num%7==0){
                    frecT[i][j]= 0;
                }
                else{
                    frecT[i][j]= num; 
                }
            }	
        }	
        this.freqMat = new Array2DRowRealMatrix(frecT);
    }
    public RealMatrix get_freqMat(){
        return this.freqMat;
    }
    public int get_documents(){
        return this.freqMat.getColumnDimension();
    }
    public int get_terms(){
        return this.freqMat.getRowDimension();
    }
    public void showFreqMat(){
        double [][]frecT = this.freqMat.getData();
        Matrix printableMat = new Matrix(frecT);
        printableMat.print(printableMat.getColumnDimension(),0);
    }
}