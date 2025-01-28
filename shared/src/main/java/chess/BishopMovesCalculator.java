package chess;

import java.util.ArrayList;

public class BishopMovesCalculator extends PieceMovesCalculator{

    private final ChessBoard board;
    private final ChessPosition startPosition;
    private final ChessPiece piece;
    private final int row;
    private final int col;

    public BishopMovesCalculator(ChessBoard board, ChessPosition startPosition, ChessPiece piece){
        super(board, startPosition, piece);
        this.board = board;
        this.startPosition = startPosition;
        this.piece = piece;
        this.row = startPosition.getRow();
        this.col = startPosition.getColumn();

    }

    @Override
    public Boolean isBlocked(ChessBoard board, ChessPosition end, ChessPiece piece){
        if(board.getPiece(end) != null){
            if (board.getPiece(end).getTeamColor() == piece.getTeamColor()) {
                return true;
            } else {
                piece.blocked = true;
                return false;
            }
        }
        return piece.blocked;
    }


    public ArrayList<ChessMove> calculateMoves(){
        ArrayList<ChessMove> moves = new ArrayList<>();
        ChessPosition start = new ChessPosition(row, col);
        ChessPosition end;

        int[][] directions = {
                {1,1}, {-1,1},
                {-1,-1}, {1,-1}
        };

        for (int[] direction: directions){
            int newRow = row;
            int newCol = col;
            piece.blocked = false;

            while (true){
                newRow += direction[0];
                newCol += direction[1];

                if (newRow > 8 || newRow < 1 || newCol < 1 || newCol > 8) {
                    break;
                }
                end = new ChessPosition(newRow, newCol);

                if(isBlocked(board, end, piece)){
                    break;
                }

                moves.add(new ChessMove(startPosition, end, null));

            }

        }

        return  moves;
    }
}
