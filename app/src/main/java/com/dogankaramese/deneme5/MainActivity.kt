package com.dogankaramese.deneme5

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dogankaramese.deneme5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences
     var ageFromPref : Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref=this.getSharedPreferences("package com.dogankaramese.deneme5",MODE_PRIVATE)

       ageFromPref = sharedPref.getInt("Age",-1)
        if (ageFromPref==-1){
            binding.textView.text="Your age : "
        }else{
            binding.textView.text="Your age : ${ageFromPref}"
        }




    }
    fun save(view: View){

        val myAge = binding.editText.text.toString().toIntOrNull()
        if(myAge!= null ){
            binding.textView.text ="Your age : ${myAge}"
            sharedPref.edit().putInt("Age",myAge).apply()

        }else {
            // Kullanıcı boş bıraktı veya sayı dışı bir şey girdi
            binding.textView.text = "Lütfen geçerli bir sayı girin!"
        }


    }
    fun delete(view: View){
         ageFromPref = sharedPref.getInt("Age",-1)

        if(ageFromPref!=-1){

            sharedPref.edit().remove("Age").apply()
            binding.textView.text="Your Age : "
        }



    }






}