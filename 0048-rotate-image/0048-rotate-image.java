class Solution {
    public void rotate(int[][] matrix) 
    {
        for(int i = 0; i<matrix.length; i++)
        {
            for(int j = i; j<matrix[i].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int x = 0; x<matrix[0].length; x++)
        {
            int i = 0;
            int j = matrix.length-1;
            while(i<j)
            {
                int temp = matrix[x][j];
                matrix[x][j] = matrix[x][i];
                matrix[x][i] = temp;
                i++; j--;
            }
        }
    }

}