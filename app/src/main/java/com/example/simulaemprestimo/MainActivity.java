package com.example.simulaemprestimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etValorEmprestimo;
    private EditText etNumParcelas;
    private EditText etTaxaJuros;
    private EditText etSalarioCliente;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //  encontrar a view do campo de entrada Edit Text
        etValorEmprestimo = findViewById(R.id.etValorEmprestimo);
        etNumParcelas = findViewById(R.id.etNumParcelas);
        etTaxaJuros = findViewById(R.id.etTaxaJuros);
        etSalarioCliente = findViewById(R.id.etSalarioCliente);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnCalcular = findViewById(R.id.buttonCalcular);

        //ao clicar em btnCalcular execute o método abaixo
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorEmprestimo = Double.parseDouble(etValorEmprestimo.getText().toString());
                int numParcelas = Integer.parseInt(etNumParcelas.getText().toString());
                double taxaJuros = Double.parseDouble(etTaxaJuros.getText().toString());
                double salarioCliente = Double.parseDouble(etSalarioCliente.getText().toString());

                calculaEmprestimo emprestimo = new calculaEmprestimo(valorEmprestimo, numParcelas, taxaJuros, salarioCliente);

                if (emprestimo.podeConcederEmprestimo()) {
                    double valorParcela = emprestimo.calcularParcela();
                    String resultado = "Valor da parcela: R$" + String.format("%.2f", valorParcela);
                    tvResultado.setText(resultado);
                } else {
                    tvResultado.setText("Empréstimo não pode ser concedido. Valor da parcela excede 30% do salário.");
                }
            }
        });
    }
}

