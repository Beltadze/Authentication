package com.example.davalebani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var sendButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAuth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.resetEmailEditText)
        sendButton = findViewById(R.id.resetButton)

        sendButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if(email.isEmpty()) {
                Toast.makeText(this, "carielia emaili :( !", Toast.LENGTH_LONG).show()
            } else {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "ver gashala farshevangma kudi :( !", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

}