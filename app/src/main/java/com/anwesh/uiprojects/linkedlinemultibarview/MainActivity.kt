package com.anwesh.uiprojects.linkedlinemultibarview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.linemultibarview.LineMultiBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LineMultiBarView.create(this)
    }
}
