
public class MouseInMaze {
	
	int dimen = 0;
	public MouseInMaze() {
		int matrix[][] = {  {1, 0, 0, 0},
        {1, 1, 0, 9},
        {0, 1, 0, 0},
        {0, 1, 1, 1}};
		
		dimen = matrix.length;
		
		System.out.println("path exists ---- "+checkIfPathExists(matrix, 0, 0));
		
	}
	
	private boolean checkIfPathExists(int [][] matrix,int x, int y){
		
		if(x>=0 && x<dimen && y>=0 && y<dimen){
			if(matrix[x][y]==9)
				return true;
			if(matrix[x][y]==1){
				if(checkIfPathExists(matrix,x+1,y))
					return true;
				if(checkIfPathExists(matrix,x,y+1))
					return true;
				
				return false;
			}
			
			return false;
			
		}else
			return false;
	
	}

}
