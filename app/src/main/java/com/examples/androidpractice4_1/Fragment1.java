package com.examples.androidpractice4_1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mac on 2017. 3. 30..
 */

public class Fragment1 extends Fragment {
    Button button, button2, button3;

    Button[] btn = new Button[4];

    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    LinearLayout linearLayout ;

    View v;

    Restaurant[] table = new Restaurant[4];

    String[] name = {"사과 Table","포도 Table","키위 Table","자몽 Table"};

    LayoutInflater inflater;

    int Selected;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        v = inflater.inflate(R.layout.fragment1, container, false );

        init();
        return v;
    }

    void init(){
        btn[0] = (Button) v.findViewById(R.id.button);
        btn[1] = (Button) v.findViewById(R.id.button2);
        btn[2] = (Button) v.findViewById(R.id.button3);
        btn[3] = (Button) v.findViewById(R.id.button4);

        button = (Button) v.findViewById(R.id.btn1);
        button2 = (Button) v.findViewById(R.id.btn2);
        button3 = (Button) v.findViewById(R.id.btn3);

        linearLayout = (LinearLayout) v.findViewById(R.id.linear);

        textView1 = (TextView) v.findViewById(R.id.textView1);
        textView2 = (TextView) v.findViewById(R.id.textView2);
        textView3 = (TextView) v.findViewById(R.id.textView3);
        textView4 = (TextView) v.findViewById(R.id.textView4);
        textView5 = (TextView) v.findViewById(R.id.textView5);
        textView6 = (TextView) v.findViewById(R.id.textView6);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = 0;
                if(table[Selected] == null){
                    Emptytext();
                }else{
                    getTable(0);
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = 1;
                if(table[Selected] == null){
                    Emptytext();
                }else{
                    getTable(1);
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = 2;
                if(table[Selected] == null){
                    Emptytext();
                }else{
                    getTable(2);
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Selected = 3;
                if(table[Selected] == null){
                    Emptytext();
                }else{
                    getTable(3);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTable();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(table[Selected] == null){
                    Emptytext();
                }else{
                    ChangeInformation();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(table[Selected] == null){
                    Toast.makeText(getActivity(),"비어있는 테이블입니다.",Toast.LENGTH_LONG).show();
                }else{
                    resetMethod();
                }
            }
        });

    }

    //테이블이 비어있으면 암것두 안보이게~
    void Emptytext(){
        linearLayout.setVisibility(View.VISIBLE);
        Toast.makeText(getActivity(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
        resetTextView();
    }

    void getTable(int i){
        textView1.setText(table[i].getTableName());
        textView2.setText(table[i].getEnterTime());
        textView3.setText(table[i].getSpagetti());
        textView4.setText(table[i].getPizza());
        textView5.setText(table[i].getMember());
        textView6.setText(table[i].getPrice());
    }

    //테이블에 정보 입력하는 메소드
    void setTable(){
        table[Selected] = new Restaurant(name[Selected], getTime());

        textView1.setText(table[Selected].getTableName());
        textView2.setText(table[Selected].getEnterTime());

        callDialog("정보가 입력되었습니다.");

    }
    //현재 시간 얻는 메소드
    String getTime(){
        String time;

        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장한다.
        Date date = new Date(now);
        // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
        // nowDate 변수에 값을 저장한다.
        time = sdf.format(date);


        return time;
    }

    //테이블 정보 수정 메소드
    void ChangeInformation(){
        callDialog("정보가 수정되었습니다.");
    }

    void resetMethod(){
        btn[Selected].setText(table[Selected].getTableName()+("(비어있음)"));
        table[Selected] = null;
        resetTextView();
    }

    //AlertDialog를 통해서 정보 수정 및 정보 입력 하는 메소드
    void callDialog(String s){
        View dlgView = inflater.inflate(R.layout.dialog, null);

        AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());

        final EditText editText = (EditText) dlgView.findViewById(R.id.editText);
        final EditText editText2 = (EditText) dlgView.findViewById(R.id.editText2);

        final RadioButton radioButton = (RadioButton) dlgView.findViewById(R.id.radioButton);

        final String str = s;

        dlg.setTitle("정보 입력")
                .setView(dlgView)
                .setNegativeButton("닫기",null)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String spagetti = editText.getText().toString();
                        String pizza = editText2.getText().toString();

                        int price = Integer.parseInt(spagetti)*10000+Integer.parseInt(pizza)*120000;

                        table[Selected].setSpagetti(spagetti);
                        table[Selected].setPizza(pizza);

                        if(radioButton.isChecked()){
                            table[Selected].setMember("기본멤버쉽");
                            price = (int)(price*0.9);
                        }else{
                            table[Selected].setMember("Vip멤버쉽");
                            price = (int)(price*0.7);
                        }

                        table[Selected].setPrice(price +"");

                        textView3.setText(table[Selected].getSpagetti());
                        textView4.setText(table[Selected].getPizza());
                        textView5.setText(table[Selected].getMember());
                        textView6.setText(table[Selected].getPrice());

                        btn[Selected].setText(table[Selected].getTableName());

                        Snackbar.make(v, str, Snackbar.LENGTH_LONG).show();

                    }
                })
                .show();

    }
    //textView 리셋 메소드
    void resetTextView(){
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView5.setText("");
        textView6.setText("");
    }

}
