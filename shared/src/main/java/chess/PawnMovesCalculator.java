package chess;

import java.util.ArrayList;

public class PawnMovesCalculator extends PieceMovesCalculator{

    private final ChessBoard board;
    private final ChessPosition startPosition;
    private final ChessPiece piece;
    private final int row;
    private final int col;

    public PawnMovesCalculator(ChessBoard board, ChessPosition startPosition, ChessPiece piece){
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

        int promotionRow;
        int startRow;
        int direction;

        if (piece.getTeamColor() == ChessGame.TeamColor.BLACK){
            promotionRow = 1;
            startRow = 7;
            direction = -1;
        } else {
            promotionRow = 8;
            startRow = 2;
            direction = 1;
        }

        //Forward
        if (row + direction <= 8  && row + direction >= 1){
            end = new ChessPosition(row + direction, col);
            if(board.getPiece(end) == null){
                if (end.getRow() == promotionRow){
                    moves.add(new ChessMove(start, end, ChessPiece.PieceType.ROOK));
                    moves.add(new ChessMove(start, end, ChessPiece.PieceType.KNIGHT));
                    moves.add(new ChessMove(start, end, ChessPiece.PieceType.BISHOP));
                    moves.add(new ChessMove(start, end, ChessPiece.PieceType.QUEEN));
                } else {
                    moves.add(new ChessMove(start, end, null));
                }
            }
        }

        //Double Forward
        if (row == startRow){

            end = new ChessPosition(row + direction, col);
            if(board.getPiece(end) == null){
                end = new ChessPosition(row + direction * 2 , col);
                if(board.getPiece(end) == null){
                    if (end.getRow() == promotionRow){
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.KNIGHT));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.QUEEN));
                    } else {
                        moves.add(new ChessMove(start, end, null));
                    }
                }

            }
        }


        //Diagonal
        int[][] directions = {
                {direction,1}, {direction,-1},
        };

        for (int[] diags: directions){
            if (row+diags[0] <= 8 && row+diags[0] >=1 && col + diags[1] >= 1 && col + diags[1] <= 8){
                ChessPiece target = board.getPiece(new ChessPosition(row+diags[0], col+diags[1]));
                if (target != null && target.getTeamColor() != piece.getTeamColor()){
                    end = new ChessPosition(row+diags[0], col+diags[1]);
                    if (end.getRow() == promotionRow){
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.KNIGHT));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(start, end, ChessPiece.PieceType.QUEEN));
                    } else {
                        moves.add(new ChessMove(start, end, null));
                    }

                }
            }
        }



        return  moves;
    }
}
