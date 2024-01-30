import java.util.Objects;
import java.util.Scanner;

public class Main {

  String[][] board;
  Boolean winner;
  Boolean draw;
  int winningPlayer;
  int playerTurn;

  public Main(){
    winningPlayer=0;
    draw=false;
    playerTurn=1;
    board=new String[6][7];
    newBoard();
    displayBoard();
  }

  private void newBoard(){
    for(int i=0;i<6;i++){
      for(int j=0;j<7;j++){
        board[i][j]=" - ";
      }
    }
  }

  private void displayBoard(){
    System.out.println(" ");
    System.out.println("       ***  CONNECT 4  ***");
    System.out.println(" ");
    for(int i=0;i<6;i++){
      for(int j=0;j<7;j++){
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  private boolean validInput(String s1){
    return((Objects.equals(s1,"1") || 
           Objects.equals(s1,"2") ||
           Objects.equals(s1,"3") ||
           Objects.equals(s1,"4") ||
           Objects.equals(s1,"5") ||
           Objects.equals(s1,"6") ||
           Objects.equals(s1,"7")));
  }

  private boolean isColumnFull(int col){
    return (board[0][col-1]== " X " || board[0][col-1]== " 0 ");
  }

  private int getNextAvailableSlot(int col){
    int pos=5;
    boolean found=false;
    while(pos>=0 && !found){
      if(!Objects.equals(board[pos][col]," X ")  && !Objects.equals(board[pos][col]," 0 ")){
        found=true;
      }else{
        pos--;
      }
    }
    return pos;
  }

  private void swapPlayerTurn(){
    if(playerTurn==1){
      playerTurn=2;
    }else{
      playerTurn=1;
    }
  }

  private void placePiece(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Player "+ playerTurn + " - Please select which column to place your piece(1-7):");
    String input=sc.nextLine();

    while(!validInput(input) || isColumnFull(Integer.parseInt(input))){
      while(!validInput(input)){
        System.out.println("Invalid input - please select a column from 1-7");
        input=sc.nextLine();
      }
      while(isColumnFull(Integer.parseInt(input))){
        System.out.println("Column full, choose another column");
        input=sc.nextLine();
        if(!validInput(input)){
          break;
        }
      }
    }
    int columnchoice=Integer.parseInt(input) - 1;

    System.out.println("Next available row in column: "+ getNextAvailableSlot(columnchoice));

    String pieceToPlace;
    if(playerTurn==1){
      pieceToPlace=" X ";
    }else{
      pieceToPlace=" 0 ";
    }

    board[getNextAvailableSlot(columnchoice)][columnchoice]=pieceToPlace;
    displayBoard();
    swapPlayerTurn();
  }

  private boolean isBoardFull(){
    boolean full=true;
    for(int i=0;i<1;i++){
      for(int j=0;j<7;j++){
        if(board[i][j]!=" X "  && board[i][i]!=" 0 "){
          full=false;
        }
      }
    }
    return full;
  }

  private String checkVerticalWinner(){
    String sym=null;
    for(int i=0;i<3;i++){
      for(int j=0;j<7;j++){
        if((board[i][j]==board[i+1][j]) && (board[i][j]==board[i+2][j]) && (board[i][j]==board[i+3][j])){
          if(board[i][j]==" X " || board[i][j]==" 0 "){
            sym=board[i][j];
          }
        }
      }
    }
    return sym;
  }

  private String checkHorizontalWinner(){
    String sym=null;
    for(int i=0;i<6;i++){
      for(int j=0;j<4;j++){
        if((board[i][j]==board[i][j+1]) && (board[i][j]==board[i][j+2]) && (board[i][j]==board[i][j+3])){
          if(board[i][j]==" X " || board[i][j]==" 0 "){
            sym=board[i][j];
          }
        }
      }
    }
    return sym;
  }

  private String checkLeftDiagonalWinner(){
    String sym=null;
    for(int i=0;i<3;i++){
      for(int j=0;j<4;j++){
        if((board[i][j]==board[i+1][j+1]) && (board[i][j]==board[i+2][j+2]) && (board[i][j]==board[i+3][j+3])){
          if(board[i][j]==" X " || board[i][j]==" 0 "){
            sym=board[i][j];
          }
        }
      }
    }
    return sym;
  }

  private String checkRightDiagonalWinner(){
    String sym=null;
    for(int i=0;i<3;i++){
      for(int j=3;j<7;j++){
        if((board[i][j]==board[i+1][j-1]) && (board[i][j]==board[i+2][j-2]) && (board[i][j]==board[i+3][j-3])){
          if(board[i][j]==" X " || board[i][j]==" 0 "){
            sym=board[i][j];
          }
        }
      }
    }
    return sym;
  }

  private int checkforwinner(){
    int winner=0;
    String sym=" ";

    if(checkVerticalWinner()==" X " || checkVerticalWinner()==" 0 "){
      sym=checkVerticalWinner();
    }else if(checkHorizontalWinner() == " X " || checkHorizontalWinner() == " 0 "){
      sym=checkHorizontalWinner();
    }else if(checkLeftDiagonalWinner() == " X " || checkLeftDiagonalWinner() == " 0 "){
      sym=checkLeftDiagonalWinner();
    }else if(checkRightDiagonalWinner() == " X " || checkRightDiagonalWinner() == " 0 "){
      sym=checkRightDiagonalWinner();
    }

    if(sym==" x "){
      winner=1;
    }else if(sym==" 0 "){
      winner=2;
    }
    return winner;
  }

  private boolean checkforDraw(){
    return (isBoardFull()==true && (checkforwinner()!=1 && checkforwinner()!=2));
  }

  private void showWinner(){
    System.out.println(" ");
    System.out.println("       PLAYER "+ winningPlayer + " WINS !!! ");
  }

  private void playGame(){
    while(winningPlayer==0){
      winningPlayer=checkforwinner();
      draw=checkforDraw();
      if(winningPlayer==1){
        showWinner();
        break;
      }else if(winningPlayer==2){
        showWinner();
        break;
      }else if(draw==true){
        System.out.println("It's a draw");
        break;
      }
      placePiece();
    }
  }


  public static void main(String[] args) {
    Main c4=new Main();
    c4.playGame();
  }
}
