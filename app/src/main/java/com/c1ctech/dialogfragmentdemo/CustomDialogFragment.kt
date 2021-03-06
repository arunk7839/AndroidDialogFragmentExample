package com.c1ctech.dialogfragmentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_custom_dialog.view.*


class CustomDialogFragment : DialogFragment() {

    companion object {

        const val TAG = "CustomDialogFragment"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        //take the title and subtitle form the Activity
        fun newInstance(title: String, subTitle: String): CustomDialogFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = CustomDialogFragment()
            fragment.arguments = args
            return fragment
        }

    }

    //creating the Dialog Fragment.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }

    //tasks that need to be done after the creation of Dialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    //setting the text in CustomDialog
    private fun setupView(view: View) {

        view.tvTitle.text = arguments?.getString(KEY_TITLE)
        view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
    }

    //setting all the click listeners of the CustomDialog
    private fun setupClickListeners(view: View) {

        // On clicking the positive/negative button,
        // the dialog will be closed with the help of dismiss()
        view.btnPositive.setOnClickListener {
            dismiss()
        }
        view.btnNegative.setOnClickListener {
            dismiss()
        }
    }

}