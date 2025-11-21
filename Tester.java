import java.awt.*;

public class Tester {
    public static void main(String[] args) {
        /*
          NOTE: NumberSquare constructor parameters must be in the order (neighbors, row, col)
            for all test cases to pass. 
         */
        testMineSquare();
        testNumberSquare();
        testGrid();
    }

    public static void testMineSquare() {
        boolean testsPassed = true;
        System.out.println("Testing MineSquare...");
        MineSquare square = new MineSquare(2, 3);
        if(!(square.getRow() == 2)) {
            System.err.println("FAILED to assign row to provided value");
            testsPassed = false;
        }
        if(!(square.getColumn() == 3)) {
            System.err.println("FAILED to assign col to provided value");
            testsPassed = false;
        }
        if(!(square.getNeighbors() == -1)) {
            System.err.println("FAILED to return -1 when calling getNeighbors()");
            testsPassed = false;
        }
        if(!(square.isMine())) {
            System.err.println("FAILED to return true when calling isMine()");
            testsPassed = false;
        }
        if(square.isFlagged()) {
            System.err.println("FAILED to set flagged to false by default");
            testsPassed = false;
        }
        if(square.isUncovered()) {
            System.err.println("FAILED to set uncovered to false by default");
            testsPassed = false;
        }
        if(!square.getFlagColor().equals(Color.RED)) {
            System.err.println("FAILED to set flagColor to Color.RED by default");
            testsPassed = false;
        }
        if(!square.getBackgroundColor().equals(Color.RED)) {
            System.err.println("FAILED to set backgroundColor to Color.RED by default");
            testsPassed = false;
        }
        if(!square.getBorderColor().equals(Color.WHITE)) {
            System.err.println("FAILED to set borderColor to Color.WHITE by default");
            testsPassed = false;
        }
        if(!square.getCoveredColor().equals(Color.GREEN)) {
            System.err.println("FAILED to set coveredColor to Color.GREEN by default");
            testsPassed = false;
        }
        square.toggleFlag();
        if(!square.isFlagged()){
            System.err.println("FAILED to change flagged to true on first call of toggleFlag()");
            testsPassed = false;
        }
        else{
            square.uncover();
            if(square.isUncovered()){
                System.err.println("FAILED to prevent square from being uncovered when it is flagged");
                testsPassed = false;
            }
        }
        square.toggleFlag();
        if(square.isFlagged()){
            System.err.println("FAILED to change flagged back to false on second call of toggleFlag()");
            testsPassed = false;
        }
        else{
            square.uncover();
            if(!square.isUncovered()){
                System.err.println("FAILED to uncover square when calling uncover()");
                testsPassed = false;
            }
        }

        if(testsPassed)
            System.out.println("All tests passed :)\n");
    }

    public static void testNumberSquare() {
        boolean testsPassed = true;
        System.out.println("Testing NumberSquare...");
        NumberSquare square = new NumberSquare(4, 2, 3);
        if(!(square.getRow() == 2)) {
            System.err.println("FAILED to assign row to provided value");
            testsPassed = false;
        }
        if(!(square.getColumn() == 3)) {
            System.err.println("FAILED to assign col to provided value");
            testsPassed = false;
        }
        if(!(square.getNeighbors() == 4)) {
            System.err.println("FAILED to assign provided value to neighbors in constructor");
            testsPassed = false;
        }
        if(square.isMine()) {
            System.err.println("FAILED to return false when calling isMine()");
            testsPassed = false;
        }
        if(square.isFlagged()) {
            System.err.println("FAILED to set flagged to false by default");
            testsPassed = false;
        }
        if(square.isUncovered()) {
            System.err.println("FAILED to set uncovered to false by default");
            testsPassed = false;
        }
        if(!square.getFlagColor().equals(Color.RED)) {
            System.err.println("FAILED to set flagColor to Color.RED by default");
            testsPassed = false;
        }
        if(!square.getBackgroundColor().equals(Color.LIGHT_GRAY)) {
            System.err.println("FAILED to set backgroundColor to Color.LIGHT_GRAY by default");
            testsPassed = false;
        }
        if(!square.getBorderColor().equals(Color.WHITE)) {
            System.err.println("FAILED to set borderColor to Color.WHITE by default");
            testsPassed = false;
        }
        if(!square.getCoveredColor().equals(Color.GREEN)) {
            System.err.println("FAILED to set coveredColor to Color.GREEN by default");
            testsPassed = false;
        }
        square.toggleFlag();
        if(!square.isFlagged()){
            System.err.println("FAILED to change flagged to true on first call of toggleFlag()");
            testsPassed = false;
        }
        else{
            square.uncover();
            if(square.isUncovered()){
                System.err.println("FAILED to prevent square from being uncovered when it is flagged");
                testsPassed = false;
            }
        }
        square.toggleFlag();
        if(square.isFlagged()){
            System.err.println("FAILED to change flagged back to false on second call of toggleFlag()");
            testsPassed = false;
        }
        else{
            square.uncover();
            if(!square.isUncovered()){
                System.err.println("FAILED to uncover square when calling uncover()");
                testsPassed = false;
            }
        }

        if(testsPassed)
            System.out.println("All tests passed :)\n");
    }

    public static void testGrid() {
        boolean testsPassed = true;
        System.out.println("Testing Grid...");
        Grid grid = new Grid(2, 2, 2, 0, 0);

        if(grid.getNumMines() != 2){
            System.err.println("FAILED to assign provided value to numMines in constructor");
            testsPassed = false;
        }
        if(grid.getNumFlaggedSquares() != 0){
            System.err.println("FAILED to set numFlaggedSquares to 0 in constructor");
            testsPassed = false;
        }
        if(grid.hasMineBeenUncovered()){
            System.err.println("FAILED to set mineUncovered to false in constructor");
            testsPassed = false;
        }
        if(grid.hasWon()){
            System.err.println("FAILED to return false at start of game when calling hasWon()");
            testsPassed = false;
        }
        grid.userMove(5, 5, "flag", false);
        grid.userMove(35, 35, "flag", true);
        if(grid.getNumFlaggedSquares() != 2){
            System.err.println("FAILED to update numFlaggedSquares accordingly after 2 squares were flagged");
            testsPassed = false;
        }
        grid.userMove(35, 35, "flag", true);
        if(grid.getNumFlaggedSquares() != 1){
            System.err.println("FAILED to update numFlaggedSquares accordingly after 1 square was un-flagged");
            testsPassed = false;
        }
        grid.userMove(5, 5, "uncover", true);
        grid.userMove(35, 5, "uncover", true);
        grid.userMove(5, 35, "uncover", true);
        grid.userMove(35, 35, "uncover", true);
        if(!grid.hasMineBeenUncovered()){
            System.err.println("FAILED to update mineUncovered after a mine has been uncovered");
            testsPassed = false;
        }

        do {
            grid = new Grid(2, 2, 2, 0, 0);
            grid.userMove(5, 5, "uncover", false);
        }while(grid.hasMineBeenUncovered());
        grid.userMove(5, 5, "flag", true);
        if(grid.getNumFlaggedSquares() != 0){
            System.err.println("FAILED to prevent user from flagging a square that is already uncovered");
            testsPassed = false;
        }

        if(testsPassed)
            System.out.println("All tests passed :)\n");
    }

}