package XS;

import java.util.ArrayList;
import java.util.HashMap;

public class Piece{

    private String type;
    
    

    /**
     * Initialization of the pieces setting the type
     * @param type
     * @param pos
     */
    public Piece(String type){
        this.type = type;
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
    public int[] availableMoves(int player, String type, int pos){
        if(type.equals("")){
            return null;
        }
        ArrayList<Integer> availableMoves = new ArrayList<Integer>();
        
            


        return null;
    }

    /*
     * Returns Piece type (string)
     */
    public String getType(int pos){
        return type;
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
    }

      
}