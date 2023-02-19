package XS;
public class Piece{

    int pawn = 1;
    int knigh = 3;  
    int bishop= 3;
    int rook = 5;
    int queen = 9;
    int king = 10;

    int pos;
    String type;

    public Piece(String type, int pos){
        this.type = type;
        this.pos = pos;
    }
    
    /**
     * Show available moves of the Piece given by the paramters
     * Pawns can 
     * @param type
     * @param pos
     * @return
     */
    int[] availableMoves(String type, int pos){
        int[] ret;
        return null;
    }

    /**
     * returns Piece position (int)
     * @return
     */
    int getPos(){
        return pos;
    }

    /*
     * Returns Piece type (string)
     */
    String getType(){
        return type;
    }

    /**
     * Assumes move is valid
     * Changes Piece position
     * @param move
     */
    void move(int move){

    }
      
}