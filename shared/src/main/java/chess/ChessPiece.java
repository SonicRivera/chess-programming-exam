package chess;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;
    public boolean blocked;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
        this.blocked = false;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return this.pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return this.type;
    }

    public String getSymbol(){
        if (getTeamColor() == ChessGame.TeamColor.WHITE){
            if (getPieceType() == PieceType.ROOK){
                return "R ";
            } else if (getPieceType() == PieceType.KNIGHT){
                return "N ";
            } else if(getPieceType() == PieceType.BISHOP){
                return "B ";
            } else if(getPieceType() == PieceType.QUEEN){
                return "Q ";
            } else if(getPieceType() == PieceType.KING){
                return "K ";
            } else if (getPieceType() == PieceType.PAWN){
                return "P ";
            }
        } else {
            if (getPieceType() == PieceType.ROOK){
                return "r ";
            } else if (getPieceType() == PieceType.KNIGHT){
                return "n ";
            } else if(getPieceType() == PieceType.BISHOP){
                return "b ";
            } else if(getPieceType() == PieceType.QUEEN){
                return "q ";
            } else if(getPieceType() == PieceType.KING){
                return "k ";
            } else if (getPieceType() == PieceType.PAWN){
                return "p ";
            }
        }
        return "";
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (getPieceType() == PieceType.KING){
            KingMovesCalculator King = new KingMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return King.calculateMoves();
        }
        if (getPieceType() == PieceType.KNIGHT){
            KnightMovesCalculator Knight = new KnightMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return Knight.calculateMoves();
        }
        if (getPieceType() == PieceType.QUEEN){
            QueenMovesCalculator Queen = new QueenMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return Queen.calculateMoves();
        }
        if (getPieceType() == PieceType.BISHOP){
            BishopMovesCalculator Bishop = new BishopMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return Bishop.calculateMoves();
        }
        if (getPieceType() == PieceType.ROOK){
            RookMovesCalculator Rook = new RookMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return Rook.calculateMoves();
        }
        if (getPieceType() == PieceType.PAWN){
            PawnMovesCalculator Pawn = new PawnMovesCalculator(board,myPosition, board.getPiece(myPosition));
            return Pawn.calculateMoves();
        }

        return new ArrayList<>();
    }
}
