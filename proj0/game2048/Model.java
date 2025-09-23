package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /**
     * Current contents of the board.
     */
    private Board board;
    /**
     * Current score.
     */
    private int score;
    /**
     * Maximum score so far.  Updated when game ends.
     */
    private int maxScore;
    /**
     * True iff game is ended.
     */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /**
     * Largest piece value.
     */
    public static final int MAX_PIECE = 2048;

    /**
     * A new 2048 game on a board of size SIZE with no pieces
     * and score 0.
     */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /**
     * A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes.
     */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /**
     * Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     * 0 <= COL < size(). Returns null if there is no tile there.
     * Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /**
     * Return the number of squares on one side of the board.
     * Used for testing. Should be deprecated and removed.
     */
    public int size() {
        return board.size();
    }

    /**
     * Return true iff the game is over (there are no moves, or
     * there is a tile with value 2048 on the board).
     */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /**
     * Return the current score.
     */
    public int score() {
        return score;
    }

    /**
     * Return the current maximum game score (updated at end of game).
     */
    public int maxScore() {
        return maxScore;
    }

    /**
     * Clear the board to empty and reset the score.
     */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /**
     * Add TILE to the board. There must be no Tile currently at the
     * same position.
     */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /**
     * Tilt the board toward SIDE. Return true iff this changes the board.
     * <p>
     * 1. If two Tile objects are adjacent in the direction of motion and have
     * the same value, they are merged into one Tile of twice the original
     * value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     * tilt. So each move, every tile will only ever be part of at most one
     * merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     * value, then the leading two tiles in the direction of motion merge,
     * and the trailing tile does not.
     */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;
        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board achanged, set the
        // changed local variable to true.
        board.setViewingPerspective(side);
        for(int col=0; col<board.size(); col++){
            boolean[] merged = new boolean[board.size()];
            for(int row=board.size()-2; row>=0; row--){
               if (merge(board,col,row,merged)){
                   changed = true;
               };
            }
        }
        checkGameOver();
        if (changed) {
            setChanged();
        }
        board.setViewingPerspective(Side.NORTH);
        //如果第三行是空的，就往上移动，但是如果第三行有东西，检查是否数值相同
        return changed;
    }
    //两个棋子一样，从下面移到上面
    public boolean merge(Board b, int col, int row, boolean[] merged) {
        Tile centerTile = board.tile(col, row);
        if (centerTile == null) return false;

        int index= placeAbleToMove(b,col,row,merged);
        if(index==row){return false;}

        Tile targetTile = b.tile(col, index);
        if (targetTile != null) { // 合并
            score += centerTile.value() * 2;
            merged[index] = true;
        }

        b.move(col, index, centerTile);
        return true;
    }

    /*可以移动到最上方的最佳位置
    从merge给当前的位置，找上方可移动到的位置
    *1.
     */
    public int placeAbleToMove(Board b, int col, int row, boolean[] merged){
        Tile center= board.tile(col, row);

        int targetRow=row;
        for(int r=row+1 ;r<b.size();r++){
            Tile above= board.tile(col, r);
            //如果上方不为空且是相同的数值      如果是空的
            if(above==null){
                targetRow=r;
            } else if ( above.value()==center.value()&&!merged[r]) {
                targetRow=r;
                break;
            }
            else    // 遇见了其他的数字 {
                break;
            }
        return targetRow;
    }






    /**
     * Checks if the game is over and sets the gameOver variable
     * appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /**
     * Determine whether game is over.
     */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /**
     * Returns true if at least one space on the Board is empty.
     * Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
        for (int row = 0; row < b.size(); row++) {
            for (int col = 0; col < b.size(); col++) {

                Tile value = b.tile(row, col);
                System.out.println("我写的" + value);
                //只要其中有一个value是0，那么就是null
                if (value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        for (int row = 0; row < b.size(); row++) {
            for (int col = 0; col < b.size(); col++) {
                Tile tile = b.tile(row, col);
                if (tile != null) {
                    if (tile.value() == MAX_PIECE) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
        /*
        //方法叫至少还有一步可以走
        条件1: 相邻的两个格子是相同的
        条件2: 至少还有一个空位
        */
        for (int row = 0; row < b.size(); row++) {
            for (int col = 0; col < b.size(); col++) {
                Tile tile = b.tile(row, col);
                if (sameTwoNeighbours(b, row, col) || tile == null) {
                    return true;
                }
            }
        }
        return false;
    }

    //这个函数是helper function，专门用来查看两边是否有相同的
    public static boolean sameTwoNeighbours(Board b, int row, int col) {
        Tile center = b.tile(row, col);
        if (center == null) return false; // 空格不算有相同邻居

        int size = b.size();
        int[] dr={1,-1,0,0};//方向偏移量 上下左右的顺序
        int[] dc={0,0,-1,1};
        for (int k = 0; k < 4; k++) {
            int newRow = row + dr[k];
            int newCol = col + dc[k];

            if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size) continue;

            Tile neighbor = b.tile(newRow, newCol);
            if (neighbor != null && neighbor.value() == center.value()) {
                return true; // 找到相同邻居
            }
        }

        return false; // 没有相同邻居
    }





    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
