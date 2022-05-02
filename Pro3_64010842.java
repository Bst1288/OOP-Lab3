import java.util.Scanner;

public class Pro3_64010842 {
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the matrix: ");
        int size = input.nextInt();
        int[][] matrix = new int[size][size];

        generateMat(matrix);
        displayMat(matrix);

        int column = 0;
        int row = 0;

        for(int n = 0; n < 2; n++){
            for(int i = 0; i < matrix.length; i++){
                if(sequenceRow( matrix,n,i )) {
                    System.out.println("All " + n + "s on row " + i);
                    row++;
                }
            }
        }

        for(int n = 0; n < 2; n++){
            for(int i = 0; i < matrix.length; i++){
                if(sequenceColumn( matrix,n,i )) {
                    System.out.println("All " + n + "s on column " + i);
                    column++;
                }
            }
        }

        if(column == 0){
            System.out.println("No same numbers on a column");
        }
        if(row == 0){
        	System.out.println("No same numbers on a row");
        }
		
		if(superDiagonal(matrix, 1) || superDiagonal(matrix, 0)){
			if(superDiagonal(matrix, 1))
				System.out.println("All 1's on superdiagonal");
			else if(superDiagonal(matrix, 0))
				System.out.println("All 0's on superdiagonal");
		}
		else{
			System.out.println("No same numbers on the superdiagonal");
		}

		if(diagonal(matrix, 1) || diagonal(matrix, 0)){
			if(diagonal(matrix, 1))
				System.out.println("All 1's on diagonal");
			else if(diagonal(matrix, 0))
				System.out.println("All 0's on diagonal");
		}
		else{
			System.out.println("No same numbers on the diagonal");
		}

		if(subDiagonal(matrix, 1) || subDiagonal(matrix, 0)){
			if(subDiagonal(matrix, 1))
				System.out.println("All 1's on subdiagonal");
			else if(subDiagonal(matrix, 0))
				System.out.println("All 0's on subdiagonal");
		}
		else{
			System.out.println("No same numbers on the subdiagonal");
		}
    }

    public static boolean sequenceRow(int[][] matrix, int n, int row){
        for(int i = 0; i < matrix[row].length; i++){
            if (matrix[row][i] != n)
				return false;
        }
        return true;
    }

    public static boolean sequenceColumn(int[][] matrix, int n, int column){
        for(int i = 0; i < matrix.length; i++){
            if (matrix[i][column] != n) 
				return false;
        }
        return true;
    }

	public static void generateMat(int[][] matrix){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random()*2);
            }
        }
    }

    public static void displayMat(int[][] matrix){
        System.out.println("");
        for(int i = 0; i < matrix.length; i++){
            for(int k = 0; k < matrix[i].length; k++){
                System.out.print(matrix[i][k]);
            }
            System.out.println(" ");
        }
    }

	public static boolean superDiagonal(int[][] matrix, int n) {
		//i is row and j is column
        //i + 1 = j
        for(int i = 0; i < matrix.length - 1; i++) {
            if (n != matrix[i][i+1]) 
				return false;
        }
        return true;
    }

    public static boolean diagonal(int[][] matrix, int n){
        boolean topLeftDownRight = true; // top left to bottom right
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][i] != n) 
				topLeftDownRight = false;
        }
        boolean downLeftTopRight = true; // bottom left to top right
        int k = 0;
        for(int i = matrix.length - 1; i >= 0; i--){
             if(matrix[i][k++] != n) 
				downLeftTopRight = false;
        }
        return topLeftDownRight || downLeftTopRight;
    }

    public static boolean subDiagonal(int[][] matrix, int n){
        //i is row and j is column
        //i - 1 = j
        for(int i = 1; i < matrix.length; i++){
            if (n != matrix[i][i-1]) 
				return false;
        }
        return true;
    }
}