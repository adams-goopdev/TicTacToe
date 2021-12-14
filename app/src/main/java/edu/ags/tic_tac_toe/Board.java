package edu.ags.tic_tac_toe;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Board {

    public final static int BOARDSIZE = 3;
    //Save the game values (Checker pieces)
    String[][] cellValues = new String[BOARDSIZE][BOARDSIZE];

    //Array of the rectangles
    Rect[][] cells = new Rect[BOARDSIZE][BOARDSIZE];

    ArrayList<String> emptySpaces = new ArrayList<>();

    public static final String TAG = "Board";

    int SIZE = 55;
    int OFFSET = 10;
    int viewHeight;
    int viewWidth;

    public Board() {

    }

    public Board(int width) {
        viewWidth = width / BOARDSIZE;
        viewHeight = viewWidth;
        SIZE = viewWidth - 3;
    }

    public Board(int width, int height) {
        viewWidth = width / BOARDSIZE;
        viewHeight = height / BOARDSIZE;
        SIZE = viewWidth - 3;
    }

    public String hitTest(Point pt, String turn, Context context) {
        String results = "-1";
        for (int row = 0; row < cellValues[0].length; row++) {
            for (int col = 0; col < cellValues[1].length; col++) {
                if (cellValues[row][col] == "e") {
                    if (cells[row][col].contains(pt.x, pt.y)) {

                        cellValues[row][col] = turn;
                        results = "0";

                        Log.d(TAG, "hitTest: Hit " + turn + " " + cellValues[row][col]);
                    }
                }
            }
        }
        return results;
    }


    public void Draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        for (int row = 0; row < cellValues[0].length; row++) {
            for (int col = 0; col < cellValues[1].length; col++) {

                cells[row][col] = new Rect();
                cells[row][col].left = col * SIZE + OFFSET;
                cells[row][col].top = row * SIZE + OFFSET;
                cells[row][col].right = col * SIZE + OFFSET + SIZE;
                cells[row][col].bottom = row * SIZE + OFFSET + SIZE;

                canvas.drawRect(cells[row][col], paint);

                if (cellValues[row][col] == "O") {
                    drawTurn(canvas, cells[row][col], "O");

                    computerTurn(canvas,cells[row][col],"X");
                }
                else
                {

                }
            }
        }
    }


    public void createEmptySpaces() {
        emptySpaces.add("0");
        emptySpaces.add("1");
        emptySpaces.add("2");
        emptySpaces.add("3");
        emptySpaces.add("4");
        emptySpaces.add("5");
        emptySpaces.add("6");
        emptySpaces.add("7");
        emptySpaces.add("8");
    }


    public void computerTurn(Canvas canvas,  String turn) {
        int select = emptySpaces.size();
        int random = new Random().nextInt(select);
        String selectSpace = emptySpaces.get(random);
        Paint paint = new Paint();
        Rect rect1;


        switch (selectSpace) {

            case "0":

                if(cellValues[0][0] == "e")
                {
                    rect1 = cells[0][0];
                    cellValues[0][0] = "X";

                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }


                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;


            case "1":

                if(cellValues[1][0] == "e") {
                    rect1 = cells[1][0];
                    cellValues[1][0] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "2":

                if(cellValues[2][0] == "e") {
                    rect1 = cells[2][0];
                    cellValues[2][0] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);

                break;

            case "3":
                if(cellValues[0][1] == "e") {
                    rect1 = cells[0][1];
                    cellValues[0][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "4":

                if(cellValues[1][1] == "e") {
                    rect1 = cells[1][1];
                    cellValues[1][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);

                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "5":

                if(cellValues[2][1] == "e") {
                    rect1 = cells[2][1];
                    cellValues[2][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "6":
                if(cellValues[0][2] == "e") {
                    rect1 = cells[0][2];
                    cellValues[0][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }

                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "7":

                if(cellValues[1][2] == "e") {
                    rect1 = cells[1][2];
                    cellValues[1][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);

                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "8":
                if(cellValues[2][2] == "e") {
                    rect1 = cells[2][2];
                    cellValues[2][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

        }

    }

    private void drawTurn(Canvas canvas, Rect rect, String turn) {
        if (turn == "O") {
            Paint paint = new Paint();
            paint.setColor(Color.RED);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            int x = rect.centerX();
            int y = rect.centerY();

            canvas.drawCircle(x, y, SIZE * .45f, paint);

        }

    }

    public void computerTurn(Canvas canvas, Rect rect,  String turn) {
        int select = emptySpaces.size();
        int random = new Random().nextInt(select);
        String selectSpace = emptySpaces.get(random);
        Paint paint = new Paint();
        Rect rect1;

        int x = rect.centerX();
        int y = rect.centerY();


        switch (selectSpace) {

            case "0":

                if(cellValues[0][0] == "e")
                {
                    rect1 = cells[0][0];
                    cellValues[0][0] = "X";

                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }


                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;


            case "1":

                if(cellValues[1][0] == "e") {
                    rect1 = cells[1][0];
                    cellValues[1][0] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "2":

                if(cellValues[2][0] == "e") {
                    rect1 = cells[2][0];
                    cellValues[2][0] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);

                break;

            case "3":
                if(cellValues[0][1] == "e") {
                    rect1 = cells[0][1];
                    cellValues[0][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "4":

                if(cellValues[1][1] == "e") {
                    rect1 = cells[1][1];
                    cellValues[1][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);

                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "5":

                if(cellValues[2][1] == "e") {
                    rect1 = cells[2][1];
                    cellValues[2][1] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "6":
                if(cellValues[0][2] == "e") {
                    rect1 = cells[0][2];
                    cellValues[0][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }

                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "7":

                if(cellValues[1][2] == "e") {
                    rect1 = cells[1][2];
                    cellValues[1][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);

                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

            case "8":
                if(cellValues[2][2] == "e") {
                    rect1 = cells[2][2];
                    cellValues[2][2] = "X";
                    //Draw the X
                    paint.setColor(Color.BLUE);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    //Draw two lines that intersect within the rectangle
                    canvas.drawLine(rect1.left, rect1.bottom, rect1.right, rect1.top, paint);
                    canvas.drawLine(rect1.right, rect1.bottom, rect1.left, rect1.top, paint);
                }
                emptySpaces.remove(selectSpace);
                Log.d(TAG, "computerTurn: " + selectSpace);
                break;

        }

    }


}

