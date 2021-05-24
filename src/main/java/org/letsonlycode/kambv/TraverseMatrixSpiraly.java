package org.letsonlycode.kambv;

public class TraverseMatrixSpiraly {

    public static void main(String[] args) {

        int a[][] = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 9}};

        // 123698745
        if(a != null && a.length > 0){
            // rows
            int m = a.length;
            // column
            int n = a[0].length;

            int k = 0, l = 0;

            while(k < m && l < n){
                for (int i = l; i < n; i++) {
                    System.out.print(a[k][i]);
                }
                k++;
                for (int i = k; i < m; i++) {
                    System.out.print(a[i][n-1]);
                }
                n--;
                if(k<m){
                    for (int i = n-1; i>=l ; i--) {
                        System.out.print(a[m-1][i]);
                    }
                    m--;
                }

                if(l<n){
                    for (int i = m-1; i>=k ; i--) {
                        System.out.print(a[i][l]);
                    }
                    l++;
                }
            }
        }



    }
}
