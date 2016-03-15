package com.ske.snakebaddesign.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.R;
import com.ske.snakebaddesign.guis.BoardView;
import com.ske.snakebaddesign.models.Game;

public class GameActivity extends AppCompatActivity {

    private BoardView boardView;
    private Button buttonTakeTurn;
    private Button buttonRestart;
    private TextView textPlayerTurn;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetGame();
    }

    private void initComponents() {
        boardView = (BoardView) findViewById(R.id.board_view);
        buttonTakeTurn = (Button) findViewById(R.id.button_take_turn);
        buttonTakeTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeTurn();
            }
        });
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        textPlayerTurn = (TextView) findViewById(R.id.text_player_turn);
        game = Game.getInstance();
        boardView.setBoard(game.getBoard());
    }

    private void resetGame() {
        game.reset();
        boardView.setBoardSize(game.getBoard().getBoardSize());
        boardView.setP1Position(game.getPlayer1().getPostion());
        boardView.setP2Position(game.getPlayer2().getPostion());
    }

    private void takeTurn() {
        Log.e("check", "hi" + game.getTurn() + "takeTurn");
        game.rollDice();
        Log.e("check", "die " + game.getDie().getValue());
        final int value = game.getDie().getValue();
        String title = "You rolled a die";
        String msg = "You got " + game.getDie().getValue();
                OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                moveCurrentPiece(value);
                dialog.dismiss();
            }
        };
        displayDialog(title, msg, listener);

    }


    private void moveCurrentPiece(int value) {
        if(game.getTurn() % 2 ==0 ){
            game.movePlayer(game.getPlayer1(),value);
            boardView.setP1Position(game.getPlayer1().getPostion());
            textPlayerTurn.setText("Player 2's Turn");
        }
        else{
            game.movePlayer(game.getPlayer2(),value);
            boardView.setP2Position(game.getPlayer2().getPostion());
            textPlayerTurn.setText("Player 1's Turn");
        }
        checkWin();
        game.nextTurn();

    }


    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                dialog.dismiss();
            }
        };
        if(game.checkWin()){
            msg = game.getWinner()+" won!";
        }
        else {
            return;
        }
        displayDialog(title, msg, listener);
    }

    private void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }

}
