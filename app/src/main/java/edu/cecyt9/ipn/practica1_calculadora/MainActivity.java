package edu.cecyt9.ipn.practica1_calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    Double numero1,numero2,resultado;
    String operador;
    public void onClickButtonUno(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "1");
    }
    public void onClickButtonDos(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "2");
    }
    public void onClickButtonTres(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "3");
    }
    public void onClickButtonCuatro(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "4");
    }
    public void onClickButtonCinco(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "5");
    }
    public void onClickButtonSeis(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickButtonSiete(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickButtonOcho(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickButtonNueve(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickButtonCero(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + "0");
    }

    public void onClickButtonPunto(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText(tv.getText() + ".");
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }

    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }

    //Método que añade el operador al pulsar alguna de
    //las 5 operaciones agregadas
    public void agregarOperador(View view){
        int operacion=view.getId();
        switch(operacion)
        {
            case R.id.raiz:
                operador="sqrt";
                break;
            case R.id.pow:
                operador="pot";
                break;
            case R.id.log:
                operador="log";
                break;
            case R.id.RAD:
                operador="rad";
                break;
            case R.id.factorial:
                operador="!";
                break;
        }
        onClickOperacionCapturaNumero1(view);
    }

    public void onClickIgual(View miView)
    {
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        if(!operador.matches("(!)|(log)|(rad)"))
            numero2 = Double.parseDouble(tv.getText().toString());

        try {

            if (operador.equals("+")) {
                resultado = numero1 + numero2;
            } else if (operador.equals("-")) {
                resultado = numero1 - numero2;
            } else if (operador.equals("*")) {
                resultado = numero1 * numero2;
            } else if (operador.equals("/")) {
                resultado = numero1 / numero2;
            }else if(operador.equals("raiz")){
                resultado=Math.pow(numero1,1/numero2);
            }else if(operador.equals("pow")){
                resultado=Math.pow(numero1,numero2);
            }else if(operador.equals("log")){
                resultado=Math.log10(numero1);
            }else if(operador.equals("rad")){
                resultado=Math.toRadians(numero1);
            }else if(operador.equals("!")){
                resultado=Double.parseDouble(""+factorial(numero1.intValue()));
            }
            tv.setText(resultado.toString());
        }catch(NumberFormatException nfe){
            Toast.makeText(this,"Numero Incorrecto", LENGTH_SHORT).show();
        }
    }

    public int factorial(int n){
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);
    }
    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
        TextView tv = (TextView) findViewById(R.id.textViewNumero) ;
        tv.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
