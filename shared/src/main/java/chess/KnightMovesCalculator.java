package chess;

import java.util.ArrayList;

public class KnightMovesCalculator extends PieceMovesCalculator{

    private final ChessBoard board;
    private final ChessPosition startPosition;
    private final ChessPiece piece;
    private final int row;
    private final int col;

    public KnightMovesCalculator(ChessBoard board, ChessPosition startPosition, ChessPiece piece){
        super(board, startPosition, piece);
        this.board = board;
        this.startPosition = startPosition;
        this.piece = piece;
        this.row = startPosition.getRow();
        this.col = startPosition.getColumn();

    }


    public ArrayList<ChessMove> calculateMoves(){
        ArrayList<ChessMove> moves = new ArrayList<>();
        ChessPosition start = new ChessPosition(row, col);
        ChessPosition end;

        int[][] directions = {
                {2,1}, {2,-1}, {-2,1}, {-2,-1},
                {1,2}, {1,-2}, {-1,2}, {-1,-2},
        };

        for (int[] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow <= 8 && newRow >=1 && newCol >= 1 && newCol <=8){
                end = new ChessPosition(newRow, newCol);
                if(!isBlocked(board, end, piece)){
                    moves.add(new ChessMove(start, end, null));
                }
            }

        }

        return  moves;
    }
}
