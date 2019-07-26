package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {

        Character [][] board;

    public Board(Character[][] matrix) {
        this.board= matrix;
    }

    public Boolean isInFavorOfX() {
        return getWinner().equals("X");
    }

    public Boolean isInFavorOfO() {
        return getWinner().equals("O");
    }

    public Boolean isTie() {
        return getWinner().equals("");
    }


    public String getWinner() {
        String winner= "";
        Character[] diagonal1= {board[0][0], board[1][1], board[2][2]};
        winner= threeInARow(diagonal1);
        if(!winner.equals("")){
            return winner;
        }
        Character[] diagonal2= {board[0][2], board[1][1], board[2][0]};
        winner= threeInARow(diagonal2);
        for(int i=0; i< board.length; i++){
            winner= threeInARow(board[i]);
            if(!winner.equals("")){
                return winner;
            }
            Character[] column= new Character[board.length];
            for(int j=0; j<board.length; j++){
                column[j]= board[j][i];
            } winner= threeInARow(column);
            if(!winner.equals("")){
                return winner;
            }

        }



        return winner;
    }


    private String threeInARow (Character[] moves){
        int countX= 0;
        int countO =0;

        for(Character move: moves){
            if (move.equals('X')){
                countX++;
            }else if (move.equals('O')){
                countO++;

            }
        }if( countX== 3){
            return "X";
        }else if (countO ==3){
            return "O";
        }
        return "";
    }




}
