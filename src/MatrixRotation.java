
public class MatrixRotation {

	public MatrixRotation() {
		 int a[][] = { {1,  2,  3,  4},{5,  6,  7,  8},{9,  10, 11, 12},{13, 14, 15, 16} };
		 rotateMatrix(a);
	}
	
	
	private void rotateMatrix(int matrix[][]){
		
		int row = 0;
		int col = 0;
		int m=matrix.length;int n=matrix[0].length;
		while(row<m && col<n){
			int prev = matrix[row+1][col];
			if(row==m-1 || col==n-1)
				break;
			for(int i=col;i<n;i++){
				int cur = matrix[row][i];
				matrix[row][i] = prev;
				prev = cur;
			}
			row++;
			for(int i=row;i<m;i++){
				int cur = matrix[i][n-1];
				matrix[i][n-1] = prev;
				prev = cur;
			}
			n--;
			//if(row<m){
				for(int i=n-1;i>=col;i--){
					int cur = matrix[m-1][i];
					matrix[m-1][i] = prev;
					prev =cur;
				}
			//}
			m--;
			//if(col<n){
				for(int i=m-1;i>=row;i--){
					int cur = matrix[i][col];
					matrix[i][col] = prev;
					prev =cur;
				}
			//}
			col++;
			
		}
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" , ");
		}
		System.out.println();
		}
	}
	
	
}
