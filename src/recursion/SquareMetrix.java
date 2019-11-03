package recursion;
import java.util.Random;


public class SquareMetrix {

    public static  int [][]  initMatrix(int n ){
        int [][] matrix = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]= new Random().nextInt(5);
            };
        }
        return matrix;
    }

    public int[][] SquareTmp(int n){
        int [][]  c =  initMatrix(n);
        int [][]  a =  initMatrix(n);
        int [][]  b =  initMatrix(n);

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                c[i][j]=0;
                for (int k=0;k<n;k++){
                    c[i][j]=c[i][j]+a[i][k]*b[k][j];
                }
            }
        }

        return c;
    }




    public static void main(String[] args){
        int n=6;
        int [][] matrix =  initMatrix(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.println(matrix[i][j]);
            };
        }

    }
}
