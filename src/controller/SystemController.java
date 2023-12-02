package controller;

import window.Board;

public class SystemController {
    private SystemController() {
    }

    public static void start(){
        Board board = Board.create();
        board.show();
    }
}