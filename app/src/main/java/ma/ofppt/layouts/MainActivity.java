package ma.ofppt.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import ma.ofppt.layouts.databinding.ActivityMainBinding;
import ma.ofppt.layouts.databinding.MainContrainteBinding;

public class MainActivity extends AppCompatActivity {
    MainContrainteBinding binding;
    Button[] numbers;
    Button[] operators;
    Double nb1,nb2;
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainContrainteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        operators = new Button[]{binding.btnDiv,binding.btnmultiplication,binding.btnPlus,binding.btnMinus};
        for(Button button : operators){
            button.setOnClickListener(view ->{
                String number = binding.editeDisplay.getText().toString();
                Button b = (Button) view;
                binding.editeDisplay.setText("");
                if(op==""){
                   nb1 = Double.parseDouble(number);
                   op = b.getText().toString();

                }else{
                    Double result = (double) 0;
                    nb2 = Double.parseDouble(number);

                    switch (op){
                        case "+" : result = nb1 + nb2; break;
                        case "-" : result = nb1 - nb2; break;
                        case "*" : result = nb1 * nb2; break;
                        case "/" : result = nb1 / nb2; break;
                    }
                    binding.editeDisplay.setText(""+ result);
                    op=b.getText().toString();
                }

            });
        }
        numbers = new Button[]{binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4, binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9};
        for (Button button : numbers) {
            button.setOnClickListener(view -> {
                String number = binding.editeDisplay.getText().toString();
                Button b = (Button) view;
                number += b.getText().toString();
                binding.editeDisplay.setText(number);
            });
        }
    }
}