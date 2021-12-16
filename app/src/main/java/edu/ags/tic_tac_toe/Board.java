package edu.ags.tic_tac_toe;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Board {

    public final static int BOARDSIZE = 3;
    //Save the game values (Checker pieces)
    String[][] cellValues = new String[BOARDSIZE][BOARDSIZE];

    //Array of the rectangles
    Rect[][] cells = new Rect[BOARDSIZE][BOARDSIZE];

    public static final String TAG = "Board";

    Game game;
    int SIZE = 55;
    int OFFSET = 10;
    int viewHeight;
    int viewWidth;

    public Board(){

    }

    public Board(int width){
        viewWidth = width / BOARDSIZE;
        viewHeight = viewWidth;
        SIZE = viewWidth - 3;
    }

    public Board(int width, int height){
        viewWidth = width / BOARDSIZE;
        viewHeight = height / BOARDSIZE;
        SIZE = viewWidth - 3;
    }

    public String hitTest(Point pt, String turn)
    {
        String results = "-1";
        for(int row = 0; row < cellValues[0].length; row ++)
        {
            for(int col = 0; col < cellValues[1].length; col ++)
            {
                if(cellValues[row][col]=="")
                {
                    if(cells[row][col].contains(pt.x, pt.y))
                    {
                        Log.d(TAG, "hitTest: Hit");
                        cellValues[row][col] = turn;
                        results = "0";

                    }
                }
            }
        }
        return results;
    }

    public void Draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        for(int row = 0; row < cellValues[0].length; row ++)
        {
            for(int col = 0; col < cellValues[1].length; col ++)
            {

                cells[row][col] = new Rect();
                cells[row][col].left = col * SIZE + OFFSET;
                cells[row][col].top = row * SIZE + OFFSET;
                cells[row][col].right = col * SIZE + OFFSET + SIZE;
                cells[row][col].bottom = row * SIZE + OFFSET + SIZE;

                canvas.drawRect(cells[row][col], paint);

                if(cellValues[row][col] == "1")
                {
                    drawTurn(canvas, cells[row][col],"1");
                }
                else if(cellValues[row][col] == "2")
                {
                    drawTurn(canvas, cells[row][col],"2");
                }



            }
        }

    }

    private void drawTurn(Canvas canvas, Rect rect, String turn)
    {
        if(turn == "1")
        {
            Paint paint = new Paint();
            paint.setColor(Color.RED);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            int x = rect.centerX();
            int y = rect.centerY();

            canvas.drawCircle(x, y, SIZE * .45f, paint);
        }
        else
        {
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            //Draw two lines that intersect within the rectangle
            canvas.drawLine(rect.left, rect.bottom, rect.right, rect.top, paint);
            canvas.drawLine(rect.right, rect.bottom, rect.left, rect.top, paint);
        }

    }


    public boolean computerTurn()
    {
        int compMove = 0;

        try
        {

            while(true){
                compMove++;
                if (isValid(cellValues, compMove ) && compMove < 9){
                    break;
                }
            }
            Log.d(TAG, "computerTurn: Before switch " + compMove);

            switch (String.valueOf(compMove)){
                case "1":
                    cellValues[0][0] = "2";
                    break;
                case "2":
                    cellValues[0][1] = "2";
                    break;
                case "3":
                    cellValues[0][2] = "2";
                    break;
                case "4":
                    cellValues[1][0] = "2";
                    break;
                case "5":
                    cellValues[1][1] = "2";
                    break;
                case "6":
                    cellValues[1][2] = "2";
                    break;
                case "7":
                    cellValues[2][0] = "2";
                    break;
                case "8":
                    cellValues[2][1] = "2";
                    break;
                case "9":
                    cellValues[2][2] = "2";
                    break;
                default:
                    return true;
            }

        }
        catch (Exception e)
        {
            Log.d(TAG, "computerTurn: " + e.getMessage());
        }

        return true;

    }


    public boolean isValid(String[][] cellValues, int position)
    {
        switch (position)
        {
            case 1:
                return (cellValues[0][0] == "");
            case 2:
                return (cellValues[0][1] == "");
            case 3:
                return (cellValues[0][2] == "");
            case 4:
                return (cellValues[1][0] == "");
            case 5:
                return (cellValues[1][1] == "");
            case 6:
                return (cellValues[1][2] == "");
            case 7:
                return (cellValues[2][0] == "");
            case 8:
                return (cellValues[2][1] == "");
            case 9:
                return (cellValues[2][2] == "");
            default:
                return false;
        }
    }



}

