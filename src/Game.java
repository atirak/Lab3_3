import java.util.Scanner;

public class Game {
    private static ox ox;
    private static Scanner kb = new Scanner(System.in);
    private static int col, row;


    public static void main(String[] args) {
        ox = new ox();
        while (true) {
            printTable();
            input();
            if(ox.checkWin(col,row)){
                printTable();
                printWin();
                printScore();
                ox.reset();
                continue;
            }if(ox.isDraw()){
                printTable();
                printDraw();
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();

        }
    }

    private static void input() {
        System.out.print(ox.getCurrentPlayer() + " (Col): ");
        col = kb.nextInt();
        System.out.print(ox.getCurrentPlayer() + " (Row): ");
        row = kb.nextInt();
        ox.put(col, row);
    }
    private static void printTable() {
        System.out.print(ox.getTableString());
    }

    private static void printDraw() {
        System.out.println("Draw");
    }

    private static void printWin() {
        System.out.println(ox.getCurrentPlayer() + " " + "Win");
    }

    private static void printScore() {
        System.out.println("X win : " + ox.getScoreX());
        System.out.println("O win : " + ox.getScoreO());
        System.out.println("Draw : " + ox.getScoreDraw());
        System.out.println("____________");
    }
}
