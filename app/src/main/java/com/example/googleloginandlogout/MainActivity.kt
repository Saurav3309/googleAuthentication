package com.example.googleloginandlogout

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : AppCompatActivity() {
    lateinit var mGoogleSingInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val logout=findViewById<Button>(R.id.logout)
        logout.setBackgroundColor(Color.CYAN)

        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSingInClient=GoogleSignIn.getClient(this,gso)

        logout.setOnClickListener{
            mGoogleSingInClient.signOut().addOnCompleteListener {
                val intent=Intent(this,Login::class.java)
                Toast.makeText(this,"Logging Out",Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
    }
}