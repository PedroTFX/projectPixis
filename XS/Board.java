package XS;

public class Board{

    static public int[] board = new int[64];

    /**
     * Initializes the Board, with the pieces int the starting position:
     * Each player starts with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns.
     * The pieces are set up on the board as follows:
     * 
     * a. The two rooks are placed on the corners of the player's own first rank (the row closest to the player).
     * b. The two knights are placed next to the rooks.
     * c. The two bishops are placed next to the knights.
     * d. The queen is placed on the remaining square of her own color. For example, if a player is playing with white pieces, the queen is placed on the white square.
     * e. The king is placed on the remaining square of his own color, next to the queen.
     * f. The eight pawns are placed on the second rank (the row in front of the pieces) in front of the other pieces.
     * 
     * The players sit on opposite sides of the board, with the white pieces starting on the first rank and the black pieces starting on the eighth rank.
     * @param board
     */
    void initialBoard(Piece[] board){
        
    }

    void availableMoves(int player, Piece[] board){

    }

     /**
     * Assumes move is valid
     * Changes Piece position by move increment
     * @param move
     */
    void move(int move, int piecePos){
        //clean previous pos
        String piece = board[piecePos].getType();
        board[piecePos] = new Piece("none", piecePos);

        //move to new pos
        board[piecePos + move] = piece;
    }

    public static void main(String[] args) {
        
    }
}