package com.example.helps.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     Button btn_0;
     Button btn_1;
     Button btn_2;
     Button btn_3;
     Button btn_4;
     Button btn_5;
     Button btn_6;
     Button btn_7;
     Button btn_8;
     Button btn_9;
     Button btn_point;
     Button btn_mul;
     Button btn_add;
     Button btn_div;
     Button btn_sub;
     Button btn_cls;
     Button btn_del;
     Button btn_per;
     Button btn_equ;
     EditText et_input;

    boolean clean_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);
        btn_cls=(Button)findViewById(R.id.btn_clean);
        btn_per=(Button)findViewById(R.id.btn_percent);
        btn_point=(Button)findViewById(R.id.btn_decimal);
        btn_del=(Button)findViewById(R.id.btn_del);
        btn_div=(Button)findViewById(R.id.btn_divide);
        btn_mul=(Button)findViewById(R.id.btn_multiply);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_sub=(Button)findViewById(R.id.btn_subtract);
        btn_equ=(Button)findViewById(R.id.btn_equ);
        et_input=(EditText) findViewById(R.id.edit_input);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_cls.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_equ.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_per.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String str=et_input.getText().toString();

        switch (view.getId()){
            case R.id.btn_0:

            case R.id.btn_1:

            case R.id.btn_2:

            case R.id.btn_3:

            case R.id.btn_4:

            case R.id.btn_5:

            case R.id.btn_6:

            case R.id.btn_7:

            case R.id.btn_8:

            case R.id.btn_9:

            case R.id.btn_decimal:
                if(clean_flag){
                    clean_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)view).getText());

                break;

            case R.id.btn_divide:

            case R.id.btn_multiply:

            case R.id.btn_add:

            case R.id.btn_subtract:
                if(clean_flag){
                    clean_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)view).getText()+" ");
                break;

            case R.id.btn_clean:
                clean_flag=false;
                et_input.setText("");
                break;

            case R.id.btn_del:
                if(clean_flag){
                    clean_flag=false;
                    str="";
                    et_input.setText("");
                }else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_percent:
                break;

            case R.id.btn_equ:
                getResult();
                break;
        }
    }

    private void getResult(){
        String exp=et_input.getText().toString();
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clean_flag){
            clean_flag=false;
            return;
        }
        clean_flag=true;

        double result=0;

        String str1=exp.substring(0,exp.indexOf(" "));

        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);

        String str2=exp.substring(exp.indexOf(" ")+3);

        if(!str1.equals("")&&!str2.equals("")){
            double value1=Double.parseDouble(str1);
            double value2=Double.parseDouble(str2);
            if(op.equals("+")){
                result= value1+value2;
            }else if(op.equals("-")){
                result=value1-value2;
            }else if(op.equals("×")){
                result=value1*value2;
            }else if(op.equals("÷")){
                if(value2==0){
                    result=0;
                }else{
                    result=value1/value2;
                }
            }
            if(!str1.contains(".")&&!str2.contains(".")&&!op.equals("÷")){
                int int_result=(int)result;
                et_input.setText(int_result+"");
            }else{
                et_input.setText(result+"");
            }
        }else if(!str1.equals("")&&str2.equals("")){
            et_input.setText(exp);
        }else if(str1.equals("")&&!str2.equals("")){
            double value2=Double.parseDouble(str2);
            if(op.equals("+")){
                result= 0+value2;
            }else if(op.equals("-")){
                result=0-value2;
            }else if(op.equals("×")){
                result=0;
            }else if(op.equals("÷")){
                result=0;
            }if(!str2.contains(".")){
                int int_result=(int)result;
                et_input.setText(int_result+"");
            }else{
                et_input.setText(result+"");
            }
        }else{
            et_input.setText("");
        }
    }
}
