package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    TextView num,result;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,bequal,bclr,badd,bsub,bmul,bdiv;
    String number;
    Double finalresult,postnumber[];
 private final static String logtag=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        b0=(Button)findViewById(R.id.button0);
        bdot=(Button)findViewById(R.id.buttondot);
        bequal=(Button)findViewById(R.id.buttonequal);
        bclr=(Button)findViewById(R.id.buttonclr);
        badd=(Button)findViewById(R.id.buttonadd);
        bsub=(Button)findViewById(R.id.buttonsub);
        bmul=(Button)findViewById(R.id.buttonmul);
        bdiv=(Button)findViewById(R.id.buttondiv);

        num=(TextView)findViewById(R.id.number);
        result=(TextView)findViewById(R.id.result);



        b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"1");
                Log.d(logtag,"1 enterred");
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"2");
                Log.d(logtag,"2 enterred");
            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"3");
                Log.d(logtag,"3 enterred");
            }
        });

        b4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"4");
                Log.d(logtag,"4 enterred");
            }
        });

        b5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"5");
                Log.d(logtag,"5 enterred");
            }
        });

        b6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"6");
                Log.d(logtag,"6 enterred");
            }
        });

        b7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"7");
                Log.d(logtag,"7 enterred");
            }
        });

        b8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"8");
                Log.d(logtag,"8 enterred");
            }
        });

        b9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"9");
                Log.d(logtag,"9 enterred");
            }
        });

        b0.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"0");
                Log.d(logtag,"0 enterred");
            }
        });

        bdot.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+".");
                Log.d(logtag,". enterred");
            }
        });

        badd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"+");
                Log.d(logtag,"+ enterred");
            }
        });

        bsub.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"-");
                Log.d(logtag,"- enterred");
            }
        });

        bmul.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"*");
                Log.d(logtag,"* enterred");
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText(num.getText()+"/");
                Log.d(logtag,"/ enterred");
            }
        });

        bclr.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                num.setText("");
                result.setText("");
                Log.d(logtag,"clr enterred");
            }
        });

        bequal.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v){
                Log.d(logtag,"equal enterred");
                Stack<Character> s1=new Stack<Character>();
                s1.push('(');
                number= (String) num.getText();
                number=number+')';
                Log.d(logtag,number);
                int length=number.length();
                int k=0;
                postnumber=new Double[length];
                Log.d(logtag,"infix to postfix for loop");
                String temp=" ";
                for(int i=0;i<length;i++)
                {

                    if(number.charAt(i)>='0'&&number.charAt(i)<='9'||number.charAt(i)=='.')
                    {
                        Log.d(logtag,"equal enterred number encountered");
                        if(temp==" ")
                        {
                            temp= String.valueOf(number.charAt(i));
                            System.out.println(temp);
                        }
                        else{temp=temp+String.valueOf(number.charAt(i));
                        System.out.println(temp);}
                    }
                    else if(number.charAt(i)=='+'||number.charAt(i)=='-'||number.charAt(i)=='*'||number.charAt(i)=='/')
                    {
                        Log.d(logtag,"equal enterred operation encounterred");

                        postnumber[k]=Double.parseDouble(temp);
                        System.out.println(postnumber[k]+" "+k);
                        k++;temp=" ";
                        Log.d(logtag,"equal enterred number in postnumber");
                        int x=preceedence(number.charAt(i));
                        int y=preceedence(s1.peek());
                        while(x<=y)
                        {
                            postnumber[k]=Double.valueOf(s1.pop());k++;
                            System.out.println(postnumber[k-1]);
                            y=preceedence(s1.peek());
                        }
                        if(x>y)
                        {
                            s1.push(number.charAt(i));
                            System.out.println(s1.peek()+" in operation");
                        }
                    }
                    else if(number.charAt(i)==')')
                    {
                        postnumber[k]=Double.parseDouble(temp);k++;temp=" ";
                        System.out.println(postnumber[k-1]+" "+(k-1));
                        Log.d(logtag,"equal enterred expression finished");
                        char c=s1.pop();
                        while(c!='(')
                        {
                            System.out.println("in while");
                            postnumber[k]=Double.valueOf(c);k++;
                            System.out.println(postnumber[k-1]);
                            c=s1.pop();
                        }
                        Log.d(logtag,"after popping "+postnumber[k-1]);
                         System.out.println(k);

                    }
                }
                Log.d(logtag,"evaluating expression");
                Stack<Double> s2=new Stack<Double>();
                System.out.println(postnumber.length);
                for(int i=0;i<k;i++)
                {
                    Log.d(logtag,"while evaluating ");
                    Log.d(logtag,postnumber[i].toString());
                    if( postnumber[i]==('+')||postnumber[i]==('-')||postnumber[i]==('*')||postnumber[i]==('/'))
                    {
                        Log.d(logtag,"while evaluating operation encountered");
                        double n1=s2.pop();
                        System.out.println(n1);
                        double n2=s2.pop();
                        System.out.println(n2);
                        if(postnumber[i]==('+'))
                        {
                            s2.push(n1+n2);
                            Log.d(logtag,"equal enterred numbers added");
                        }
                        else if(postnumber[i]==('-'))
                        {
                            s2.push(n2-n1);
                            Log.d(logtag,"equal enterred numbers subtracted");
                        }
                        else if(postnumber[i]==('*'))
                        {
                            s2.push(n1*n2);
                            Log.d(logtag,"equal enterred numbers multiplied");
                        }
                        else if(postnumber[i]==('/'))
                        {
                            s2.push(n2/n1);
                            Log.d(logtag,"equal enterred numbers divided");
                        }

                    }
                    else if(postnumber[i]>=0.00||postnumber[i]<=Double.MAX_VALUE)
                    {
                        Log.d(logtag,postnumber[i]+" pushing in s2");
                        s2.push(postnumber[i]);
                        System.out.println(s2.peek());
                        Log.d(logtag,"equal enterred postnumber pushed in s2");
                    }
                }
                finalresult=s2.pop();
                result.setText(finalresult.toString());
                Log.d(logtag,"equal enterred got final result");

            }
        });

    }
    int preceedence(char ch)
    {
        Log.d(logtag,"in preceedence");
        int x=0;
        if(ch=='*'||ch=='/')
        {x=2;}
        else if(ch=='+'||ch=='-')
        {x=1;}
        else if(ch=='(')
        {x=0;}
        Log.d(logtag,"leaving preceedence");
        return x;
    }
}
