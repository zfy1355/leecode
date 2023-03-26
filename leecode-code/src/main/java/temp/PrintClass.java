package temp;

/**
 * 打印各种图案
 */
public class PrintClass {
    public static void main(String[] args) {
        printMatrix(3);
        printYangHuiTriangle(5);
    }

    /**
     * 打印n*n矩阵
     * @param n
     */
    public static void printMatrix(int n){
        int[][] s = new int[n][n];
        int k=0,i=0,j=0;
        int a =1;
        for(;k<(n+1)/2;k++){
            while(j<n-k){s[i][j++]=a++;}i++;j--;
            while(i<n-k){s[i++][j]=a++;}i--;j--;
            while(j>k-1){s[i][j--]=a++;}i--;j++;
            while(i>k){s[i--][j]=a++;}i++;j++;
        }
        for(i =0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(s[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * 打印杨辉三角
     * @param n
     */
    public static void printYangHuiTriangle(int n){
        int[][] a = new int[n][];
        for(int i=0;i<a.length;i++){
            a[i] = new int[i+1];
        }
        for(int i=0;i<a.length;i++){
            a[i][0] = 1;
            a[i][i] = 1;
        }
        for(int i=2;i<a.length;i++){
            for(int j=1;j<i;j++){
                a[i][j] = a[i-1][j-1]+a[i-1][j];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
