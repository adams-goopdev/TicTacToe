package edu.ags.tic_tac_toe;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

public class Board {

    public final static int BOARDSIZE = 3;
    //Save the game values (Checker pieces)
    String[][] cellValues = new String[BOARDSIZE][BOARDSIZE];

    //Array of the rectangles
    Rect[][] cells = new Rect[BOARDSIZE][BOARDSIZE];

    public static final String TAG = "Board";

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

    public String hitTest(Point pt, String turn, Context context)
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

                if((row + col) % 2 == 0)
                    paint.setColor(Color.DKGRAY);
                else
                    paint.setColor(Color.DKGRAY);

                cells[row][col] = new Rect();
                cells[row][col].left = col * SIZE + OFFSET;
                cells[row][col].top = row * SIZE + OFFSET;
                cells[row][col].right = col * SIZE + OFFSET + SIZE;
                cells[row][col].bottom = row * SIZE + OFFSET + SIZE;

                canvas.drawRect(cells[row][col], paint);

                if(cellValues[row][col] == "1")
                    drawTurn(canvas, cells[row][col],Color.RED);
                else if(cellValues[row][col] == "2")
                drawTurn(canvas, cells[row][col],Color.BLUE);

            }
        }
    }

    private void drawTurn(Canvas canvas, Rect rect, int color)
    {
        if(color == Color.RED)
        {
            Paint paint = new Paint();
            paint.setColor(color);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            int x = rect.centerX();
            int y = rect.centerY();

            canvas.drawCircle(x, y, SIZE * .45f, paint);
        }
        else
        {
            //Draw the X
            Paint paint = new Paint();
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);

            //Draw two lines that intersect within the rectangle
            canvas.drawLine(rect.left, rect.bottom, rect.right, rect.top, paint);
            canvas.drawLine(rect.right, rect.bottom, rect.left, rect.top, paint);

        }


    }


}

