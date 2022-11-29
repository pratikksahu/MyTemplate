package com.pratik.mytemplate.Utils

import android.app.Activity
import android.widget.Toast

fun Activity.showtoast(msg:String,dur:Int = Toast.LENGTH_SHORT) =
    Toast.makeText(applicationContext,msg, dur).show()