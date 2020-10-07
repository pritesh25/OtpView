package com.example.custom

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.custom.lib.OTPListener
import com.example.custom.lib.OtpTextView

class MainActivity : AppCompatActivity() {

    private var otpTextView: OtpTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://github.com/aabhasr1/OtpView
        val errorButton = findViewById<Button>(R.id.button)
        val successButton = findViewById<Button>(R.id.button2)
        otpTextView = findViewById(R.id.otp_view)
        otpTextView?.requestFocusOTP()
        otpTextView?.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                Toast.makeText(applicationContext, "The OTP is $otp", Toast.LENGTH_SHORT).show()

            }
        }
        errorButton.setOnClickListener { otpTextView?.showError() }
        successButton.setOnClickListener { otpTextView?.showSuccess() }

    }
}
