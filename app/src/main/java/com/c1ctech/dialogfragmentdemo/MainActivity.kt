package com.c1ctech.dialogfragmentdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        sharedViewModel.name.observe(this, Observer {
            tvName.text = it
        })

        btnAlertDialog.setOnClickListener {
            AlertDialogFragment.newInstance().show(supportFragmentManager, AlertDialogFragment.TAG)
        }

        btnCustomDialog.setOnClickListener {
            CustomDialogFragment.newInstance(
                getString(R.string.custom_dialog_title),
                getString(R.string.custom_dialog_subTitle)
            ).show(supportFragmentManager, CustomDialogFragment.TAG)
        }

        btnDataDialog.setOnClickListener {
            DialogWithDataFragment().show(supportFragmentManager, DialogWithDataFragment.TAG)
        }

    }

}