package ru.guzeeva.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        val radioGroupGender = findViewById<RadioGroup>(R.id.radio_group_gender)

        sendButton.setOnClickListener {
            val name = nameValue.text.toString()
            val age = ageValue.text.toString()
            val selectedGender = findViewById<RadioButton>(radioGroupGender.checkedRadioButtonId)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("gender", selectedGender.text)

            startActivity(intent)
        }

        resetButton.setOnClickListener {
            nameValue.text.clear()
            ageValue.text.clear()
            radioGroupGender.clearCheck()
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