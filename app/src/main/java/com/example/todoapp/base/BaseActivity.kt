package com.example.todoapp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    private var viewBinding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewBinding = createViewBinding(LayoutInflater.from(this)).also {
            setContentView(it.root)
        }
    }

    protected abstract fun createViewBinding(inflater: LayoutInflater): VB
}