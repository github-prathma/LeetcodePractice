import java.util.*;
import java.io.*;

//minels from all possible paths in a grid from top left to bottom right
class MatrixTraversal { 
    static List<Integer> minEls = new ArrayList<>();
    public static void printMatrix(int mat[][], int m, int n, int i, int j, int path[], int idx, int minPath) { 
        path[idx] = mat[i][j]; 
          
         // Reached the bottom of the matrix so we are left with 
        // only option to move right 
        int minP = 0;
        if (i < m && j < n) {
            if (mat[i][j] < minPath) {
                minP = mat[i][j];
            } else {
                minP = minPath;
            }
        }
        if (i == m - 1)  
        { 
            // int minPath = Integer.MAX_VALUE;
            for (int k = j; k < n; k++) 
            { 
                if (mat[i][k] < minPath) {
                    minPath = mat[i][k];
                }
                path[idx + k - j] = mat[i][k]; 
            } 
            minEls.add(minPath);
            for (int l = 0; l < idx + n - j; l++)  
            { 
                System.out.print(path[l] + " "); 
            } 
            System.out.println(); 
            return; 
        } 
          
        // Reached the right corner of the matrix we are left with 
        // only the downward movement. 
        if (j == n - 1)  
        { 
            // int minPath = Integer.MAX_VALUE;
            for (int k = i; k < m; k++)  
            { 
                if (mat[k][j] < minPath) {
                    minPath = mat[k][j];
                }
                path[idx + k - i] = mat[k][j]; 
            } 
            minEls.add(minPath);
            for (int l = 0; l < idx + m - i; l++)  
            { 
                System.out.print(path[l] + " "); 
            } 
            System.out.println(); 
            return; 
        } 
        // Print all the paths that are possible after moving down 
        printMatrix(mat, m, n, i + 1, j, path, idx + 1, minP); 
  
         // Print all the paths that are possible after moving right 
        printMatrix(mat, m, n, i, j + 1, path, idx + 1, minP);
    } 
      
    // Driver code 
    public static void main(String[] args)
    { 
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); 
        int n = sc.nextInt(); 

        int mat[][] = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int maxLengthOfPath = m + n - 1; 
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0, Integer.MAX_VALUE); 
        for (int i=0; i<minEls.size(); ++i) {
            System.out.print(minEls.get(i) + " ");
        }
        System.out.println();
        sc.close();
        return;
    } 
} 