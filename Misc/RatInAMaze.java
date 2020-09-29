class Playground {
    public static void main(String[ ] args) 
    {
        System.out.println(solveMaze());
        //print solution path
        for(int i = 0; i<N; i++)
        {
            for(int j = 0; j<N; j++)
            {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int N = 4;
    static int maze[][] = {{1, 0, 0, 0},
                                {1, 1, 0, 1},
                                {0, 1, 0, 0},
                                {1, 1 ,1, 1}};
    static int sol[][] = new int[N][N];
    static boolean solveMaze()
    {
        if(solveMazeRec(0, 0) == false)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    static boolean solveMazeRec(int i, int j)
    {
        if(i == N-1 && j == N-1)
        {
            sol[i][j] = 1;
            return true;
        }
        if(isSafe(i, j) == true)
        {
            sol[i][j] = 1;
            if(solveMazeRec(i+1, j)) return true;
            else if(solveMazeRec(i, j+1)) return true;
            sol[i][j] = 1;
        }
        return false;
    }
    static boolean isSafe(int i, int j)
    {
        return (i<N && j<N && maze[i][j] == 1);
    }
}