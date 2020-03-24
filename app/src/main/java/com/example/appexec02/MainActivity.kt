package com.example.appexec02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import com.example.appexec02.senac.Converte
import com.example.appexec02.senac.TemperaturaEnum

class MainActivity : AppCompatActivity() {

    private lateinit var temperatura: EditText
    private lateinit var temperaturasGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperatura = findViewById<EditText>(R.id.et_temp)
        temperaturasGroup = findViewById<RadioGroup>(R.id.rg_temperaturas)
        val btn = findViewById<Button>(R.id.bt_converte)
        btn.setOnClickListener {
            if (validate()) {

                val tipoConversao =
                    if (temperaturasGroup.checkedRadioButtonId == R.id.rb_celsios)
                        TemperaturaEnum.Celsios
                    else
                        TemperaturaEnum.Fahrenheit


                val tmp = Converte(
                    temperatura.text.toString().toDouble(),
                    tipoConversao
                )

                val tempFormat =
                    String.format("%.2f", tmp.converter())

                AlertDialog.Builder(this)
                    .setTitle("Temperaturas")
                    .setMessage("Temperatura: ${tempFormat} ")
                    .setPositiveButton("OK") { dialog, which -> dialog.dismiss()
                    }.show()
            }
        }
    }

    private fun validate() : Boolean {
        var result = true
        if (temperatura.getText().trim().length == 0) {
            temperatura.setError("Campo é obrigatório")
            result = false
        }
        return result
    }
}
