package id.go.lemsaneg.tebakangka;

import android.content.Intent;
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
    private boolean isEvaluated = true;

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
                setNumber(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(7);;
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(0);
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebakanUser = 0;
                txtNumber.setText("?");
                txtMessage.setText("Tebak Sebuah Angka antara " + MIN + " dan " + MAX);
            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEvaluated = true;
                if (tebakanUser > secretNumber) {
                    txtMessage.setText("Tebakan Anda terlalu BESAR");
                } else if (tebakanUser < secretNumber) {
                    txtMessage.setText("Tebakan Anda terlalu KECIL");
                } else {
                    txtMessage.setText("Hore! Tebakan Anda BENAR, " + secretNumber);
                    txtNumber.setText("\\0/");
                    btnTryAgain.setVisibility(View.VISIBLE);
                    layoutNumbers.setVisibility(View.GONE);
                }
            }
        });

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initGame();
            }
        });

    }

    private void setNumber(int n){
        if (isEvaluated){
            tebakanUser = n;
            isEvaluated = false;
        }else{
            int temp = tebakanUser * 10 + n;
            if (temp > MAX) return;
            tebakanUser = temp;
        }
        txtNumber.setText(String.valueOf(tebakanUser));
    }

    private void createSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt((MAX - MIN) + 1) + 1;
    }

    private void initGame() {
        layoutNumbers.setVisibility(View.VISIBLE);
        btnTryAgain.setVisibility(View.GONE);
        createSecretNumber();
        txtNumber.setText("?");
        txtMessage.setText("Tebak Sebuah Angka antara " + MIN + " dan " + MAX);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
