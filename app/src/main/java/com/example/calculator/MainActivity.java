package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView solution, result;
    MaterialButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        solution = findViewById(R.id.solution);

        result = findViewById(R.id.result);

        assignID(b1,R.id.b1);
        assignID(b2,R.id.b2);
        assignID(b3,R.id.b3);
        assignID(b4,R.id.b4);
        assignID(b5,R.id.b5);
        assignID(b6,R.id.b6);
        assignID(b7,R.id.b7);
        assignID(b8,R.id.b8);
        assignID(b9,R.id.b9);
        assignID(b10,R.id.b10);
        assignID(b11,R.id.b11);
        assignID(b12,R.id.b12);
        assignID(b13,R.id.b13);
        assignID(b14,R.id.b14);
        assignID(b15,R.id.b15);
        assignID(b16,R.id.b16);
        assignID(b17,R.id.b17);
        assignID(b18,R.id.b18);
        assignID(b19,R.id.b19);
        assignID(b20,R.id.b20);

    }



    void assignID(MaterialButton btn, int id)
    {
        btn=findViewById((id));
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String btxt = button.getText().toString();
        String datatocalculate = solution.getText().toString();
        if (btxt.equals("AC")) {
            solution.setText("");
            result.setText("0");
            return;
        }
        if (btxt.equals("=")) {
            solution.setText(result.getText());
            return;
        }
        if (btxt.equals("C")) {
            datatocalculate = datatocalculate.substring(0, datatocalculate.length() - 1);
        } else {
            datatocalculate = datatocalculate + btxt;
        }

        solution.setText(datatocalculate);
        String final_result=getresult(datatocalculate);
        if(!final_result.equals("Err"))
            result.setText(final_result);


    }

    String getresult(String data) {
        try {

            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String result = context.evaluateString(scriptable, data, "JavaScript", 1, null).toString();
            if(result.endsWith(".0"))
                result=result.replace(".0","");
            return result;
        } catch (Exception e) {
            return "ERR";
        }

    }
}

