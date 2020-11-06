package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.webkit.URLUtil
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        findViewById<Button>(R.id.sendSMS).setOnClickListener{ sendSMS() }
        findViewById<Button>(R.id.openCamera).setOnClickListener{ openCamera() }
        findViewById<Button>(R.id.watchNetflix).setOnClickListener{ watchNetflix() }
        findViewById<Button>(R.id.playMusic).setOnClickListener{ playMusic() }
        findViewById<Button>(R.id.viewPicture).setOnClickListener{ viewPicture() }
    }

    private fun sendSMS(){
        val uri = Uri.parse("smsto:Demogorgon")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", "Welcome to the upside down!")
        startActivity(intent)
    }
    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }

    private fun watchNetflix() {
        val webpage: Uri = Uri.parse("https://www.netflix.com/browse")
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)

    }
    private fun playMusic(){
        val uri = Uri.parse("ww.spotify.co")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        val isValid = URLUtil.isValidUrl(uri.toString()) && Patterns.WEB_URL.matcher(uri.toString()).matches()

        if(isValid){
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "The intent failed due to invalid URI.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun viewPicture() {
        val contactUri = Uri.parse("tel:09123456789")
        val intent = Intent(Intent.ACTION_SET_WALLPAPER, contactUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            Toast.makeText(this, "The intent failed due to invalid format.", Toast.LENGTH_SHORT).show()
        }
    }

}
