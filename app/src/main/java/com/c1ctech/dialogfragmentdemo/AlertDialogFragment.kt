package com.c1ctech.dialogfragmentdemo

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AlertDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "AlertDialogFragment"

        //create fragment instance
        fun newInstance(): AlertDialogFragment {
            val fragment = AlertDialogFragment()
            return fragment
        }
    }

    //creating the AlertDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setTitle(R.string.alert_dialog_title)
        builder?.setMessage(R.string.alert_dialog_subTitle)
        builder?.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, which: Int) {
                dismiss()
            }
        })
        builder?.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, which: Int) {
                dismiss()
            }
        })
        return builder?.create()!!
    }

}