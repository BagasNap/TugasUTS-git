package com.example.tugasuts

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.editUsername)
        val email = findViewById<EditText>(R.id.editEmail)
        val firstName = findViewById<EditText>(R.id.editFirstName)
        val lastName = findViewById<EditText>(R.id.editLastName)
        val password = findViewById<EditText>(R.id.editPassword)
        val confirmPassword = findViewById<EditText>(R.id.editConfirmPassword)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnBatal = findViewById<Button>(R.id.btnBatal)

        btnKirim.setOnClickListener {
            val user = username.text.toString()
            val mail = email.text.toString()
            val first = firstName.text.toString()
            val last = lastName.text.toString()
            val pass = password.text.toString()
            val confirm = confirmPassword.text.toString()

            if (user.isEmpty() || mail.isEmpty() || first.isEmpty() || last.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Semua input harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (pass != confirm) {
                Toast.makeText(this, "Password dan konfirmasi password tidak sama!", Toast.LENGTH_SHORT).show()
            } else {
                val fullName = "$first $last"
                Snackbar.make(it, "User $fullName berhasil didaftarkan.", Snackbar.LENGTH_LONG).show()
            }
        }

        btnBatal.setOnClickListener {
            username.text.clear()
            email.text.clear()
            firstName.text.clear()
            lastName.text.clear()
            password.text.clear()
            confirmPassword.text.clear()
        }
    }
}
