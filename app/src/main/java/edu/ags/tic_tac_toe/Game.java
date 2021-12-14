package edu.ags.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class Game extends AppCompatActivity {

    public static final String TAG = "myDebug";
    int width;
    int height;
    Board board;
    String value;
    String[][] cellValues = new String[Board.BOARDSIZE][Board.BOARDSIZE];

    Boolean PlayComputer = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getScreenDims();
        board = new Board(width);

        initialSetup();
        board.cellValues = cellValues;
        setContentView(new DrawView(this));

        board.createEmptySpaces();
    }

    private void initialSetup() {

        for(int row = 0; row < cellValues[0].length; row ++)
        {
            for(int col = 0; col < cellValues[1].length; col ++)
            {
                    cellValues[row][col] = "e";
            }
        }
    }

    private void getScreenDims(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        Log.d(TAG, "getScreenDims: " + width + ":" + height);
    }

    private class DrawView extends View implements View.OnTouchListener {

        String turn = "O";

        public DrawView(Game game) {
            super(game);
            this.setOnTouchListener(this);
        }


        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            Point pt = new Point();

            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                pt.x = (int)motionEvent.getX();
                pt.y = (int)motionEvent.getY();

                if(board.hitTest(pt, turn, this.getContext()) != "-1")
                {
                   //turn = (turn == "X") ? "O" : "X";

                    turn = "O";
                    Log.d(TAG, "onTouch: " + turn);

                }
                else {

                    return false;

                }
                invalidate();

            }

            checkVictory();
            Log.d(TAG, "onTouch: " + Arrays.deepToString(cellValues));
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            board.Draw(canvas);

        }

    }




    public String checkVictory()
    {
        String[] values = {"O", "X"};
        for(String value : values)
        {
            if(cellValues[0][0].equals(value) && cellValues[0][1].equals(value) && cellValues[0][2].equals(value) //Top row
                    ||cellValues[1][0].equals(value) && cellValues[1][1].equals(value) && cellValues[1][2].equals(value) //Middle row
                    ||cellValues[2][0].equals(value) && cellValues[2][1].equals(value) && cellValues[2][2].equals(value) //bottom row
                    ||cellValues[0][0].equals(value) && cellValues[1][0].equals(value) && cellValues[2][0].equals(value) //1st col
                    ||cellValues[0][1].equals(value) && cellValues[1][1].equals(value) && cellValues[2][1].equals(value) //2nd col
                    ||cellValues[0][2].equals(value) && cellValues[1][2].equals(value) && cellValues[2][2].equals(value) //3rd col
                    ||cellValues[2][0].equals(value) && cellValues[1][1].equals(value) && cellValues[0][2].equals(value) //bottom left to top right diag
                    ||cellValues[2][2].equals(value) && cellValues[1][1].equals(value) && cellValues[0][0].equals(value))//bottom right to top right diag

            {
                Log.d(TAG, "Victory!: " + value);

                String message = "";

                if(value == "O")
                   message = "O Won!";
                else if (value =="X")
                    message = "X Won!";

                showMessage(message);

                initialSetup();
               board.cellValues = cellValues;
               setContentView(new DrawView(this));

                return value;
            }
        }

        return value;
    }

    private void showMessage(String msg)
    {
        //Show a messagebox
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}