package lemsaneg.go.id.tebakangka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnX, btnV;
    private TextView txtNumber, txtMessage;
    private int tebakanUser = 0, secretNumber;
    private Button btnTryAgain;
    private LinearLayout layoutNumbers;
    private final int MIN = 1;
    private final int MAX = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSecretNumber();

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnX = (Button) findViewById(R.id.btnX);
        btnV = (Button) findViewById(R.id.btnV);

        txtNumber = (TextView) findViewById(R.id.txtNumber);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        layoutNumbers = (LinearLayout) findViewById(R.id.layoutNumbers);
        initGame();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 1;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 2;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 3;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 4;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 5;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 6;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 7;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 8;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 9;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = tebakanUser * 10 + 0;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = 0;
                txtNumber.setText(String.valueOf(tebakanUser));
            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tebakanUser > secretNumber){
                    txtMessage.setText("Tebakan Anda terlalu BESAR");
                }else if (tebakanUser < secretNumber){
                    txtMessage.setText("Tebakan Anda terlalu KECIL");
                }else{
                    txtMessage.setText("Yeahhhh... Tebakan Anda BENAR");
                    txtNumber.setText("0");
                    btnTryAgain.setVisibility(View.VISIBLE);
                    layoutNumbers.setVisibility(View.GONE);
                }
                tebakanUser = 0;
            }
        });

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initGame();
            }
        });

    }

    private void createSecretNumber(){
        Random random = new Random();
        secretNumber = random.nextInt((MAX - MIN) + 1) + 1;
    }

    private void initGame(){
        layoutNumbers.setVisibility(View.VISIBLE);
        btnTryAgain.setVisibility(View.GONE);
        createSecretNumber();
        txtMessage.setText("");
    }
}
