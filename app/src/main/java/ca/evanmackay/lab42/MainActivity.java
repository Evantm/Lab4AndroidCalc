package ca.evanmackay.lab42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdot, badd, bsub, bmul, bdiv, beq, bdel, bclear,bpm, bhex, boct, bbin, bmod;

    TextView tv,hist;
    boolean hasNumAndOperand;


    private DecimalFormat decimalFormat;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.b1:
                tv.setText(tv.getText() + (String) b1.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b2:
                tv.setText(tv.getText() + (String) b2.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b3:
                tv.setText(tv.getText() + (String) b3.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b4:
                tv.setText(tv.getText() + (String) b4.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b5:
                tv.setText(tv.getText() + (String) b5.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b6:
                tv.setText(tv.getText() + (String) b6.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b7:
                tv.setText(tv.getText() + (String) b7.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b8:
                tv.setText(tv.getText() + (String) b8.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b9:
                tv.setText(tv.getText() + (String) b9.getText());
                MainActivity.this.checkLength();
                break;
            case R.id.b0:
                tv.setText(tv.getText() + (String) b0.getText());
                MainActivity.this.checkLength();
                break;

            case R.id.bdot:
                tv.setText(tv.getText() + (String) bdot.getText());
                break;
            case R.id.badd:
                tv.setText(tv.getText() + " " + (String) badd.getText() + " ");
                break;
            case R.id.bsub:
                tv.setText(tv.getText() + " " + (String) bsub.getText() + " ");
                break;
            case R.id.bmul:
                tv.setText(tv.getText() + " " + (String) bmul.getText() + " ");
                break;
            case R.id.bdiv:
                tv.setText(tv.getText() + " " + (String) bdiv.getText() + " ");
                break;
            case R.id.beq:
                MainActivity.this.parseInts();
                break;
            case R.id.bpm:
                MainActivity.this.bpm();
                break;


            case R.id.bbin:
                MainActivity.this.parseInts();
                tv.setText(Integer.toString((int) Double.parseDouble(tv.getText()+""),2));
                break;
            case R.id.boct:
                MainActivity.this.parseInts();
                tv.setText(Integer.toString((int) Double.parseDouble(tv.getText()+""),8));
                break;
            case R.id.bhex:
                MainActivity.this.parseInts();
                tv.setText(Integer.toString((int) Double.parseDouble(tv.getText()+""),16));
                break;


            case R.id.bmod:
                tv.setText(tv.getText() + " " + (String) bmod.getText() + " ");
                break;

            case R.id.bdel:
                MainActivity.this.checkLength();
                if(tv.getText().length() > 0)
                    tv.setText(tv.getText().subSequence(0,tv.getText().length()-1));
                else
                    tv.setText("");
                break;
            case R.id.bclear:
                MainActivity.this.checkLength();
                tv.setText("");
                hist.setText("");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.####");

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.b9);
        b9.setOnClickListener(this);
        b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(this);

        bdot = (Button) findViewById(R.id.bdot);
        bdot.setOnClickListener(this);
        badd = (Button) findViewById(R.id.badd);
        badd.setOnClickListener(this);
        bsub = (Button) findViewById(R.id.bsub);
        bsub.setOnClickListener(this);
        bmul = (Button) findViewById(R.id.bmul);
        bmul.setOnClickListener(this);
        bdiv = (Button) findViewById(R.id.bdiv);
        bdiv.setOnClickListener(this);
        beq = (Button) findViewById(R.id.beq);
        beq.setOnClickListener(this);
        bpm = (Button) findViewById(R.id.bpm);
        bpm.setOnClickListener(this);


        bbin = (Button) findViewById(R.id.bbin);
        bbin.setOnClickListener(this);
        boct = (Button) findViewById(R.id.boct);
        boct.setOnClickListener(this);
        bhex = (Button) findViewById(R.id.bhex);
        bhex.setOnClickListener(this);

        bmod = (Button) findViewById(R.id.bmod);
        bmod.setOnClickListener(this);


        bclear = (Button) findViewById(R.id.bclear);
        bclear.setOnClickListener(this);
        bdel = (Button) findViewById(R.id.bdel);
        bdel.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.textView);
        hist = (TextView) findViewById(R.id.hist);


    }

    public void checkLength(){
        if(tv.length() > 11){
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b0.setEnabled(false);
        }else{
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            b0.setEnabled(true);
        }
    }

    public void parseInts() {
        checkLength();
        hist.setText(tv.getText());
        String num = (String) tv.getText();
        Scanner numScan = new Scanner(num);
        double firstNum = Double.NaN, secondNum = Double.NaN;
        char currentOp = 'Z';

        try {
            firstNum = Double.parseDouble(numScan.next());
             do{
            currentOp = numScan.next().charAt(0);
            double storedNum = Double.NaN;
            secondNum = Double.parseDouble(numScan.next());
            switch (currentOp) {
                case '+':
                    storedNum = firstNum+secondNum;
                    tv.setText(decimalFormat.format(firstNum+secondNum));
                    break;
                case '-':
                    storedNum = firstNum-secondNum;
                    tv.setText(decimalFormat.format(firstNum - secondNum));
                    break;
                case 'X':
                    storedNum = firstNum*secondNum;
                    tv.setText(decimalFormat.format(firstNum * secondNum));
                    break;
                case '/':
                    storedNum = firstNum/secondNum;
                    tv.setText(decimalFormat.format(firstNum / secondNum));
                    break;
                case '%':
                    storedNum = firstNum%secondNum;
                    tv.setText(decimalFormat.format(firstNum % secondNum));
                    break;
                default:
                    break;
                                }
                 tv.setText(storedNum+"");
                 firstNum = storedNum;
            }while (numScan.hasNext());


            if(Double.parseDouble(tv.getText()+"")==Double.POSITIVE_INFINITY || Double.parseDouble(tv.getText()+"")==Double.NEGATIVE_INFINITY)
                tv.setText("");


        } catch (NoSuchElementException e) {
            tv.setText(decimalFormat.format(firstNum));
        } catch (NumberFormatException e) {
            tv.setText("");
        } catch (Exception e) {
            tv.setText(e + "");
        }
    }

    public void bpm(){
        MainActivity.this.parseInts();
        try {
            tv.setText(Double.parseDouble(tv.getText() + "") * -1 + "");
        }catch (Exception e){

        }
    }


}
