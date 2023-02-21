package XS;
public class Piece{

    public enum PieceType{
        NONE,
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING,
    }

    private int pos;
    private PieceType type;

    /**
     * Initialization of the pieces setting the type and its pos
     * @param type
     * @param pos
     */
    public Piece(PieceType type, int pos){
        this.type = type;
        this.pos = pos;
    }
    
    /**
     * Show available moves of the Piece given by the paramters:
     * Pawn: Pawns can move one or two squares forward on their first move, and one square forward on all subsequent moves. They capture diagonally, one square forward to the left or right.
     * Rook: Rooks can move horizontally or vertically, any number of squares, as long as their path is unobstructed. They capture by landing on the square occupied by an opposing piece.
     * Knight: Knights move in an "L" shape, two squares in a straight line and then one square to the left or right. They are the only pieces that can jump over other pieces. They capture by landing on the square occupied by an opposing piece.
     * Bishop: Bishops move diagonally, any number of squares, as long as their path is unobstructed. They capture by landing on the square occupied by an opposing piece.
     * Queen: Queens can move horizontally, vertically, or diagonally, any number of squares, as long as their path is unobstructed. They are the most powerful piece on the board and can move like both rooks and bishops. They capture by landing on the square occupied by an opposing piece.
     * King: Kings can move one square in any direction. They are the most important piece on the board, and if a player's king is threatened with capture (i.e., "in check"), the player must take steps to remove the threat. The game is won by checkmating the opponent's king, which means putting the king in check and not being able to get out of it on the next move.
     * @param type
     * @param pos
     * @return
     */
    int[] availableMoves(PieceType type, int pos){
        int[] ret;
        return null;
    }

    /*
     * Returns Piece type (string)
     */
    PieceType getType(int pos){
        return type;
    }


      
}