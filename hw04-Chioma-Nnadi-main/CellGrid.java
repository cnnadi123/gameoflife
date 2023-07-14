package hw04;
import java.util.Random;

public class CellGrid
{
	private boolean[][] cells;
	private int maxRows;
	private int maxCols;
	public CellGrid(int mRows, int mCols)
	{
		maxRows = mRows;
		maxCols = mCols;
		cells = new boolean[mRows][mCols];
		for(int i = 0; i < mRows; i++)
			for(int j = 0; j < mCols; j++)
				cells[i][j] = false;
	}

	public boolean[][] getCells() {
		return cells;
	}

	public void randomStart()
	{
		java.util.Random random = new java.util.Random();
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = random.nextBoolean();
	}

	public int count(int i, int j) {
		int count = 0;
		//for(int i = 1; i < maxRows; i++){
		//	for(int j = 1; j < maxCols; j++){
		try{ //default
			if(cells[i-1][j] == true) count +=1;
			if(cells[i-1][j-1]== true) count +=1;
			if(cells[i-1][j+1]==true) count +=1;
			if(cells[i][j-1]==true) count +=1;
			if(cells[i][j+1]==true) count +=1;
			if(cells[i+1][j-1]==true) count +=1;
			if(cells[i+1][j+1]==true) count +=1;
			if(cells[i+1][j]==true) count +=1;
		}//end of try 1
		catch (java.lang.ArrayIndexOutOfBoundsException a){
			try{ //leftmost i, no i-1
				if(cells[i][j-1]==true) count +=1;
				if(cells[i][j+1]==true) count +=1;
				if(cells[i+1][j-1]==true) count +=1;
				if(cells[i+1][j+1]==true) count +=1;
				if(cells[i+1][j]==true) count +=1;
			}//end of try 2
			catch(java.lang.ArrayIndexOutOfBoundsException b){
				try{//leftmost j, no j-1
					if(cells[i-1][j] == true) count +=1;
				//	if(cells[i-1][j-1]== true) count +=1;
					if(cells[i-1][j+1]==true) count +=1;
				//	if(cells[i][j-1]==true) count +=1;
					if(cells[i][j+1]==true) count +=1;
				//	if(cells[i+1][j-1]==true) count +=1;
					if(cells[i+1][j+1]==true) count +=1;
					if(cells[i+1][j]==true) count +=1;
				}
				catch(java.lang.ArrayIndexOutOfBoundsException c){
					try{//rightmost i, no i+1
					if(cells[i-1][j] == true) count +=1;
					if(cells[i-1][j-1]== true) count +=1;
					if(cells[i-1][j+1]==true) count +=1;
					if(cells[i][j-1]==true) count +=1;
					if(cells[i][j+1]==true) count +=1;
				//if(cells[i+1][j-1]==true) count +=1;
				//if(cells[i+1][j+1]==true) count +=1;
				//if(cells[i+1][j]==true) count +=1;
					}
					catch(java.lang.ArrayIndexOutOfBoundsException d){ //no j+1
						try{
							if(cells[i-1][j] == true) count +=1;
							if(cells[i-1][j-1]== true) count +=1;
							//	if(cells[i-1][j+1]==true) count +=1;
							if(cells[i][j-1]==true) count +=1;
							//	if(cells[i][j+1]==true) count +=1;
							if(cells[i+1][j-1]==true) count +=1;
							//if(cells[i+1][j+1]==true) count +=1;
							if(cells[i+1][j]==true) count +=1;}

						catch(java.lang.ArrayIndexOutOfBoundsException e){
							try{//no i+1 or j+1
							if(cells[i-1][j] == true) count +=1;
							if(cells[i-1][j-1]== true) count +=1;
						//	if(cells[i-1][j+1]==true) count +=1;
							if(cells[i][j-1]==true) count +=1;}
						//	if(cells[i][j+1]==true) count +=1;
						//	if(cells[i+1][j-1]==true) count +=1;
						//	if(cells[i+1][j+1]==true) count +=1;
						//	if(cells[i+1][j]==true) count +=1;
							catch(java.lang.ArrayIndexOutOfBoundsException f){
								try{//no i-1 or j-1
								//	if(cells[i-1][j] == true) count +=1;
								//	if(cells[i-1][j-1]== true) count +=1;
								//	if(cells[i-1][j+1]==true) count +=1;
								//	if(cells[i][j-1]==true) count +=1;
									if(cells[i][j+1]==true) count +=1;
								//	if(cells[i+1][j-1]==true) count +=1;
									if(cells[i+1][j+1]==true) count +=1;
									if(cells[i+1][j]==true) count +=1;
								}
								catch(java.lang.ArrayIndexOutOfBoundsException g){
									try{//no i-1 or j+1
										//if(cells[i-1][j] == true) count +=1;
									//	if(cells[i-1][j-1]== true) count +=1;
									//	if(cells[i-1][j+1]==true) count +=1;
										if(cells[i][j-1]==true) count +=1;
									//	if(cells[i][j+1]==true) count +=1;
										if(cells[i+1][j-1]==true) count +=1;
									//	if(cells[i+1][j+1]==true) count +=1;
										if(cells[i+1][j]==true) count +=1;
									}
									catch(java.lang.ArrayIndexOutOfBoundsException h){
										//no i+1 or j-1
										if(cells[i-1][j] == true) count +=1;
										//if(cells[i-1][j-1]== true) count +=1;
										if(cells[i-1][j+1]==true) count +=1;
										//if(cells[i][j-1]==true) count +=1;
										if(cells[i][j+1]==true) count +=1;
										//if(cells[i+1][j-1]==true) count +=1;
									//	if(cells[i+1][j+1]==true) count +=1;
										//if(cells[i+1][j]==true) count +=1;

		}}}}}}}}
		return count;
	}
	public void applyUpdate()
	{
		//boolean[][] neighbors = new boolean[maxRows][maxCols];
		for(int i = 0; i < maxRows; i++){
			for(int j = 0; j < maxCols; j++){
				int neighbors = count(i,j);
				if(cells[i][j] == true){
					if(neighbors>3) cells[i][j] = false;
					else if(neighbors<2) cells[i][j] = false;
					else{
						cells[i][j] = true;}
				}
				else if(cells[i][j] == false){
					if(neighbors==3) cells[i][j] = true;
					else{
						cells[i][j] = false;}
				}
			}
		}


	}

	public void gosperStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[5][1] = true;
		cells[5][2] = true;
		cells[6][1] = true;
		cells[6][2] = true;
		cells[1][25] = true;
		cells[2][23] = true;
		cells[2][25] = true;
		cells[3][13] = true;
		cells[3][14] = true;
		cells[3][21] = true;
		cells[3][22] = true;
		cells[3][35] = true;
		cells[3][36] = true;
		cells[4][12] = true;
		cells[4][16] = true;
		cells[4][21] = true;
		cells[4][22] = true;
		cells[4][35] = true;
		cells[4][36] = true;
		cells[5][11] = true;
		cells[5][17] = true;
		cells[5][21] = true;
		cells[5][22] = true;
		cells[6][11] = true;
		cells[6][15] = true;
		cells[6][17] = true;
		cells[6][18] = true;
		cells[6][23] = true;
		cells[6][25] = true;
		cells[7][11] = true;
		cells[7][17] = true;
		cells[7][25] = true;
		cells[8][12] = true;
		cells[8][16] = true;
		cells[9][13] = true;
		cells[9][14] = true;
	}

	public void gliderStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[1][3] = true;
		cells[2][4] = true;
		cells[3][2] = true;
		cells[3][3] = true;
		cells[3][4] = true;
	}
}
