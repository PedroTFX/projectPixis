package XS;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tests {

    static boolean movementTests(){
        boolean bottomLimit = Piece.isInInside(0, -8);
        boolean leftLimit = Piece.isInInside(40, -1);
        boolean rightLimit = Piece.isInInside(39, 1);
        boolean upperLimit = Piece.isInInside(61, 8);
        if(bottomLimit){
            print("bottom");
        }
        if(leftLimit){
            print("left");
        }
        if(rightLimit){
            print("right");
        }
        if(upperLimit){
            print("upper");
        }
        return !bottomLimit && !leftLimit && !rightLimit && !upperLimit;
    }

    static void showMovement(String type, int pos){
        String[] board = new String[64];
        for(int i = 0; i < board.length ; i++){
            board[i] = ".";
        }
        board[pos] = type;

        ArrayList<Integer> moves = new ArrayList<Integer>();
        if(type.charAt(1) == 'p'){
            moves = Piece.PawnMoves(pos, board);
        }



        for(int i = 0; i < board.length; i++){
            String square = board[i] + " ";
            for(int j = 0; j < moves.size();j++){
                if(pos + moves.get(j) == i){
                    moves.remove(j);
                    square = "m ";
                }
            }
            System.out.print(square);
            
            if(i % 8 == 7){
                System.out.println("");
            }
        }
    }



    static void print(String msm){
        System.out.println(msm);
    }

    public static void main(String[] args) {
        System.out.println("movementTests(): " + movementTests());
        showMovement("bp", 8);
    }
}
