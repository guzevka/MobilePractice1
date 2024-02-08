package ru.guzeeva.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.guzeeva.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {

    private lateinit var nameValue: EditText
    private lateinit var ageValue: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // ... (existing code)

        nameValue = findViewById(R.id.name_value1)
        ageValue = findViewById(R.id.age_value1)

        val sendButton: Button = findViewById(R.id.send)
        val resetButton = findViewById<Button>(R.id.reset)
        val radioButtonFemale = findViewById<RadioButton>(R.id.gender_value_female1)
        val radioButtonMale = findViewById<RadioButton>(R.id.gender_value_male1)

        sendButton.setOnClickListener {
            val name = nameValue.text.toString()
            val age = ageValue.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)

            if (radioButtonFemale.isChecked) {
                intent.putExtra("gender", "Женский")
            } else if (radioButtonMale.isChecked) {
                intent.putExtra("gender", "Мужской")
            }

            startActivity(intent)
        }

        resetButton.setOnClickListener {
            nameValue.text.clear()
            ageValue.text.clear()
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeTheme {
        Greeting("Android")
    }
}