package com.pavelwinter.myorganizer.presentation.fragments.forms


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pavelwinter.myorganizer.data.db.datamanagment.TasksDataManager
import com.pavelwinter.myorganizer.data.di.DaggerDbComponent
import kotlinx.android.synthetic.main.add_task_form.*
import java.util.*
import javax.inject.Inject


class AddTaskFragment : Fragment() {

    lateinit var dateAndTime : Calendar

    @Inject
    lateinit var tasksDataManager: TasksDataManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.pavelwinter.myorganizer.R.layout.add_task_form,container,false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDagger()

        add_task_form_choose_time_btn ?.setOnClickListener {
            callTimePicker()
        }

        initCategsChooser()
        initProjectsChooser()

        //callTimePicker()

        // val taske = TaskE(2,"dbgbbggbgbgsdsd",2,2,"dfdfdf",2,2,2,2)
        // tasksDataManager.addObject(taske)
      //  val taskeUpd = TaskE(1,"ddfdfdfdf",1,2,"dfdfdfiuu",2,2,2,2)
      //  TasksDataManager().addObject(taskeUpd)
      //  println("=====TDL${TasksDataManager().getTaskList()?.size}")
    }



    private fun initPrioritiesChooser(){
    }


    private fun initCategsChooser(){

        this.context ?.let {
            val items = arrayOf(
                "Home",
                "Money",
                "Pets",
                "Car",
                "Work"
            )

            val adapter = ArrayAdapter<String>(
                it,
                android.R.layout.simple_spinner_dropdown_item, items
            )

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            add_task_form_categories_spinner.adapter = adapter
        }
    }


    private fun initProjectsChooser(){
        this.context ?.let {
            val items = arrayOf(
                "Birthday",
                "Repair car",
                "Learn english",
                "Write app"
            )

            val adapter = ArrayAdapter<String>(
                it,
                android.R.layout.simple_spinner_dropdown_item, items
            )

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            add_task_form_projects_spinner ?.adapter = adapter
        }
    }


    private fun initDagger(){
        DaggerDbComponent.create().inject(this)

    }



    // region choose time picker

   private fun callTimePicker() {

       dateAndTime = Calendar.getInstance()

       this.context?.let {
           DatePickerDialog(
               it, d,
               dateAndTime.get(Calendar.YEAR),
               dateAndTime.get(Calendar.MONTH),
               dateAndTime.get(Calendar.DAY_OF_MONTH)
           )
               .show()
       }
   }


    private fun setTime() {

        this .context ?.let {
            TimePickerDialog(
                it, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true
            )
                .show()
        }
    }


    // установка обработчика выбора времени
     var t: TimePickerDialog.OnTimeSetListener =
        TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            dateAndTime.set(Calendar.MINUTE, minute)

            Log.d("CHOOSEN_TIME", dateAndTime.getTimeInMillis().toString())
            Log.d("CURRENT_TIME", System.currentTimeMillis().toString())
        }


    // установка обработчика выбора даты
     var d: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            //setInitialDateTime();
            setTime()
        }

    // endregion choose time picker ----------------------------------------------


}


