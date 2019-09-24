package com.pavelwinter.myorganizer.presentation.fragments.forms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pavelwinter.myorganizer.R
import kotlinx.android.synthetic.main.fragment_add_quota.*
import kotlinx.android.synthetic.main.fragment_add_quota.hour_picker
import kotlinx.android.synthetic.main.picker_dialog_quota.minute_picker
import kotlinx.android.synthetic.main.picker_dialog_quota.period_picker


class AddQuotaFragment : Fragment() {

    internal var str = arrayOf("a", "b", "c")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_quota, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        tv_digit_hour ?.text = 0.toString()
        tv_descr_hour ?.text = "h   "
        tv_descr_minute ?.text = 0.toString()
        tv_descr_minute ?.text = "m   "
        tv_descr_period ?.text = " for period: "
        tv_variant ?.text = "week"


        ll_quota ?.setOnClickListener {

            this.context?.let {

                val d = AlertDialog.Builder(it)
                val inflater = this.layoutInflater
                val dialogView = inflater.inflate(R.layout.picker_dialog_quota, null)
                d.setTitle("Title")
                d.setMessage("Message")
                d.setView(dialogView)


                hour_picker?.maxValue = 200
                hour_picker?.minValue = 0

                minute_picker.setMaxValue(59)
                minute_picker.setMinValue(0)

                period_picker.setMinValue(0)
                period_picker.setMaxValue(2)

                period_picker.setDisplayedValues(str)
                //new String[]{"a", "b", "c"});


                hour_picker?.setOnValueChangedListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                }

                minute_picker.setOnValueChangedListener(NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                })


                period_picker.setOnValueChangedListener(NumberPicker.OnValueChangeListener { numberPicker, i, i1 ->
                    Log.d(
                        "TAG",
                        "onValueChange: $i1"
                    )
                })


                d.setPositiveButton("Done") { dialogInterface, i ->
                    Log.d("TAG", "onClickh: " + hour_picker?.value)
                    Log.d("TAG", "onClickm: " + minute_picker.getValue())
                    Log.d("TAG", "onClickp: " + period_picker.getValue())


                    tv_digit_hour?.text = hour_picker?.value.toString()
                    tv_digit_minute?.setText(minute_picker.getValue().toString())
                    tv_variant?.text = str[period_picker.getValue()]
                }
                d.setNegativeButton(
                    "Cancel"
                ) { dialogInterface, i -> }

                val alertDialog = d.create()
                alertDialog.show()
            }
        }

        btnq ?.setOnClickListener {  }

       }

 }
