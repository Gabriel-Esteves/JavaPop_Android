package com.example.javapop.java_pop.ui.base

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    fun showProgress() {
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Aguarde")
        progressDialog.setCancelable(false)
        if (!progressDialog.isShowing) progressDialog.show()
    }

    fun hideProgress() {
        if (progressDialog.isShowing && !isFinishing) progressDialog.dismiss()
    }

}