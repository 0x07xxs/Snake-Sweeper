import java.security.SecureRandom;
import java.util.Scanner;

// Will be called by GameGrid_Test
public class GameGrid {

    public void run(){
        int [][] aiGrid = new int[10][10];  // Grid Size
        int iWallChance = 30;
        Scanner scnr = new Scanner(System.in);

        SecureRandom oRand = new SecureRandom();

        int iUserRow = 0;
        int iUserCol = 0;
        boolean startGame = true;

        for (int y = 0; y < aiGrid[0].length; y++) {
            for (int x = 0; x < aiGrid.length; x++) {
                int iChance = oRand.nextInt(100);

                if (iChance < iWallChance) { // Chances to get a wall
                    aiGrid[y][x] = 1;

                } else {
                    aiGrid[y][x] = 0;
                }
                System.out.print(aiGrid[y][x] + " ");
            }
            System.out.println();
        }

        LinkedList oLinkedList = new LinkedList();
        aiGrid[0][0] = 0; // Changes the first spot to a 0
        while(startGame) {
            System.out.println("Select you move enter down or right");
            String userInput = scnr.nextLine();

            if (userInput.equals("down")) {
                iUserRow++;

            }

            else if (userInput.equals("right")) {
                iUserCol++;
            }

            else{
                startGame = false;
            }

            if (aiGrid[iUserRow][iUserCol] == 1) {  // Checks if user hits a spot with 1
                System.out.println("You lose");
                startGame = false;
            }
            else if (iUserCol == 9 || iUserRow == 9) {  // Checks if user went through the whole grid
                System.out.print("You win");
                startGame = false;
            }

            oLinkedList.addHeadNode(iUserCol, iUserRow);
        }

        int numTurns = 0;
        Node oNode = oLinkedList.removeHeadNode();
        while(oNode != null){
            aiGrid[oNode.yPosition][oNode.xPosition] = 5;
            oNode = oLinkedList.removeHeadNode();
            numTurns++;
        }

        for (int y = 0; y < aiGrid[0].length; y++) {
            for (int x = 0; x < aiGrid.length; x++) {

                if (y == iUserRow && x == iUserCol) {  // Uses an X to see where the user is at
                    System.out.print("X ");
                } else {
                    System.out.print(aiGrid[y][x] + " ");  // Prints the grid
                }

            }
            System.out.println();
        }
        System.out.println("Your number of turns: " + numTurns);
    }
}
