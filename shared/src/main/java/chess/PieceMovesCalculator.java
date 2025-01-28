package chess;

import java.util.ArrayList;

public class PieceMovesCalculator {

    private final ChessBoard board;
    private final ChessPosition startPosition;
    private final ChessPiece piece;
    private final int row;
    private final int col;

    public PieceMovesCalculator(ChessBoard board, ChessPosition startPosition, ChessPiece piece){
        this.board = board;
        this.startPosition = startPosition;
        this.piece = piece;
        this.row = startPosition.getRow();
        this.col = startPosition.getColumn();

    }

    public Boolean isBlocked(ChessBoard board, ChessPosition end, ChessPiece piece){
        if(board.getPiece(end) != null){
            return board.getPiece(end).getTeamColor() == piece.getTeamColor();
        }
        return false;
    }

    public ArrayList<ChessMove> calculateMoves(){
        return new ArrayList<>();
    }
}
