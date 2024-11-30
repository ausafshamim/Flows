package com.example.myapplication14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {

            producer().collect{
                Log.d("whats","${it.toString()}")
            }
        }
    }
}


private fun producer(): Flow<Int>{
    return flow<Int> {

        val list= listOf(1,2,3,4,5)
        list.forEach(){
            delay(1000)
            emit(it)
        }
    }
}