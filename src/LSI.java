import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import Jama.Matrix;

public class LSI {
    private RealMatrix u;
    private RealMatrix s;
    private RealMatrix v;

    private RealMatrix u_;
    private RealMatrix s_;
    private RealMatrix v_;

    private RealMatrix freqMatLSI;
    
    private RealMatrix originalMat;
    private SingularValueDecomposition svd;
    public LSI(FreqMat raw_freqT){
        this.originalMat = raw_freqT.get_freqMat();
        this.svd = new SingularValueDecomposition(this.originalMat);
        this.u = this.svd.getU();
        this.s = this.svd.getS();
        this.v = this.svd.getVT();

        this.u_ = this.u.getSubMatrix(0, this.u.getRowDimension()-1, 0, 9);
        this.s_ = this.s.getSubMatrix(0, 9, 0, 9);
        this.v_ = this.v.getSubMatrix(0, 9, 0, this.v.getColumnDimension()-1);

        this.freqMatLSI = this.v_;
    }

    public RealMatrix getFreqMatLSI(){
        return this.freqMatLSI;
    }

    public RealMatrix getU(){
        return this.u;
    }

    public RealMatrix getS(){
        return this.s;
    }

    public RealMatrix getV(){
        return this.v;
    }

    public RealMatrix getU_(){
        return this.u_;
    }

    public RealMatrix getS_(){
        return this.s_;
    }

    public RealMatrix getV_(){
        return this.v_;
    }

    

    public void showFreqMatLSI(){
        double [][]mat = this.freqMatLSI.getData();
        Matrix printableMat = new Matrix(mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showU(){
        double [][]uMat = this.u.getData();
        Matrix printableMat = new Matrix(uMat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showS(){
        System.out.println(this.s.getTrace());
        double [][]sMat = this.s.getData();
        Matrix printableMat = new Matrix(sMat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showV(){
        double [][]vMat = this.v.getData();
        Matrix printableMat = new Matrix(vMat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showBack(){
        RealMatrix m = this.s.multiply(this.v);
        double [][]mat = m.getData();
        Matrix printableMat = new Matrix(mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }



    public void showU_(){
        double [][]u_Mat = this.u_.getData();
        Matrix printableMat = new Matrix(u_Mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showS_(){
        System.out.println(this.s_.getTrace());
        double [][]s_Mat = this.s_.getData();
        Matrix printableMat = new Matrix(s_Mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showV_(){
        double [][]v_Mat = this.v_.getData();
        Matrix printableMat = new Matrix(v_Mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    public void showBack_(){
        RealMatrix m1 = this.u_.multiply(this.s_);
        RealMatrix m2 = m1.multiply(this.v_);
        double [][]mat = m2.getData();
        Matrix printableMat = new Matrix(mat);
        printableMat.print(printableMat.getColumnDimension(),3);
    }
    
}
