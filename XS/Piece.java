package XS;

import java.util.ArrayList;
import java.util.HashMap;

public class Piece{

    private String type;
    private static String NONE = ".";
    private static char BLACK = 'b';
    private static char WHITE = 'w';
    /**
     * Show available moves of the Piece given by the paramters:
     * Pawn: Pawns can move one or two squares forward on their first move, and one square forward on all subsequent moves. They capture diagonally, one square forward to the left or right.
     * Rook: Rooks can move horizontally or vertically, any number of squares, as long as their path is unobstructed. They capture by landing on the square occupied by an opposing piece.
     * Knight: Knights move in an "L" shape, two squares in a straight line and then one square to the left or right. They are the only pieces that can jump over other pieces. They capture by landing on the square occupied by an opposing piece.
     * Bishop: Bishops move diagonally, any number of squares, as long as their path is unobstructed. They capture by landing on the square occupied by an opposing piece.
     * Queen: Queens can move horizontally, vertically, or diagonally, any number of squares, as long as their path is unobstructed. They are the most powerful piece on the board and can move like both rooks and bishops. They capture by landing on the square occupied by an opposing piece.
     * King: Kings can move one square in any direction. They are the most important piece on the board, and if a player's king is threatened with capture (i.e., "in check"), the player must take steps to remove the threat. The game is won by checkmating the opponent's king, which means putting the king in check and not being able to get out of it on the next move.
     * @param i
     * @param board
     * @return
     */
    public static ArrayList<Integer> availableMoves(char piece_colour, int pos, String[] board){
        String piece_type = board[pos];
        if(piece_type.equals("")){
            return null;
        }
        ArrayList<Integer> available_moves = new ArrayList<Integer>();
        if(piece_type.charAt(1) == 'k'){
            return KnightMoves(pos, board);
        }
        if(piece_type.charAt(1) == 'b'){
            return BishopMoves(pos, board);
        }
        if(piece_type.charAt(1) == 'Q'){
            return QueenMoves(pos, board);
        }
        if(piece_type.charAt(1) == 'K'){
            return KingMoves(pos, board);
        }
        if(piece_type.charAt(1) == 'p'){
            return PawnMoves(pos, board);
        }
        return available_moves;
    }



    private static ArrayList<Integer> KingMoves(int pos, String[] board) {
        int[] king_dir = new int[]{
            pos - 9 , pos - 8 , pos  -7, 
            pos + 1 , /*pos*/   pos - 1,
            pos + 9 , pos + 8 , pos  +7, 
        };

        //init
        ArrayList<Integer> avail_moves = new ArrayList<Integer>();

        //logic
        for (int move : king_dir) {
            if(Math.abs((pos + move % 8) - (pos % 8)) <= 2 && move + pos < 63 && move + pos > 0){
                if(!board[pos + move].equals(NONE) || !(board[pos + move].charAt(0) == board[pos].charAt(0))){
                    avail_moves.add(move);
                }
            }
        }
        return avail_moves;
    }



    public static ArrayList<Integer> PawnMoves(int pos, String[] board) {
        int[] pawn_dir = new int[]{
            9 , 8 , 7
        };

        //init
        ArrayList<Integer> avail_moves = new ArrayList<Integer>();
        char piece_colour = getColour(pos, board);

        //logic
        for (int move : pawn_dir) {
            if(piece_colour == BLACK){          //BLACK PAWNS MOVE IN THE OPOSITE DIRECTION
                move *= -1;
            }

            if(isInInside(pos, move) && Math.abs(move) != 8 && !board[pos + move].equals(NONE) && piece_colour != getColour(pos + move, board)){//COMER PEÇAS
                avail_moves.add(move);
            }else if(Math.abs(move) == 8 && isInInside(pos, move) && board[pos + move].equals(NONE)){                                           //MOVE FORWARDS once
                    if((pos >= 48 && pos <= 55 && (piece_colour == BLACK)) || ((pos >= 8 && pos <= 15) && piece_colour == WHITE)){
                        avail_moves.add(move * 2);                                                                                              //MOVE TWICE
                    }
                    avail_moves.add(move);
            }
        }
        return avail_moves;
    }



    private static ArrayList<Integer> QueenMoves(int pos, String[] board) {
        return null;
    }



    private static ArrayList<Integer> BishopMoves(int pos, String[] board) {
        return null;
    }



    private static ArrayList<Integer> KnightMoves(int pos, String[] board) {
        return null;
    }

    private static char getColour(int pos, String[] board){
        return !board[pos].equals(NONE) ? board[pos].charAt(0) : 'n';
    }


    /*
     * Returns Piece type (string)
     */
    public String getType(int pos){
        return type;
    }

    /**
     * Checks if the movement is legal by checking if the piece didnt go behond the board boundaries
     * @param pos
     * @param move
     * @returns true if the move is legal or false if its ilegal
     */
    public static boolean isInInside(int pos, int move){
        return pos + move <= 63 && pos + move >= 0 && Math.abs(((pos + move) % 8) - (pos % 8)) <= 2;
    }

    private static HashMap<Character, Integer> translate = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);
    }};

    /**
     * Translate Chess Coords to VectorV2
     * VectorV2[0] = f
     * VectorV2[1] = 2
     * @param move
     * @return
     */
    public static int[] CoordsToV2(String move){
        String[] moveInArray = move.split("-");
        int[] ret = new int[2];
        ret[0] = Integer.parseInt(moveInArray[1]);
        ret[1] = translate.get(moveInArray[0].charAt(0));
        return ret;
    }

    /**
     * Translate VectorV2 to Chess Coords
     * VectorV2[0] = f
     * VectorV2[1] = 2
     * @param move
     * @return
     */
    public static String V2ToCoords(int[] vectorv2){
        char coord = '-';
        for (HashMap.Entry<Character, Integer> entry : translate.entrySet()) {
            if (entry.getValue() == vectorv2[1]) {
                coord = entry.getKey();
                break;
            }
        }

        if(coord == '-'){
            return null;
        }
        return Character.toString(coord) + "-" + Integer.toString(vectorv2[0]);
    }

    public static void main(String[] args) {
        // System.out.println(V2ToCoords(CoordsToV2("b-2")));
        int[] board = new int[64];
        for(int i = 0; i < board.length; i++){
            board[i] = i;
            System.out.print(board[i] + " ");
            if(i % 8 == 7){
                System.out.println("");
            }
        }
        
        System.out.println(isInInside(0, -1));
    }

      
}