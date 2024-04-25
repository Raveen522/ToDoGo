package com.appproject.todogo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.appproject.todogo.databinding.ActivityAddTaskBinding


class AddTaskActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add task"

        val titleInputView:EditText = findViewById(R.id.title_input)
        val descriptionInput:EditText = findViewById(R.id.description_input)

        val addTaskButton: Button = findViewById(R.id.add_task_button)

        val taskAddedDialog = Dialog(this)
        taskAddedDialog.setContentView(R.layout.task_added_dialog_layout)

        val doneButton:Button = taskAddedDialog.findViewById(R.id.done_button)
        doneButton.setOnClickListener {
            taskAddedDialog.dismiss()
            finish()
        }
        addTaskButton.setOnClickListener {
            if (titleInputView.text.isNotBlank()){
                val taskDatabaseHelper = TaskDatabaseHelper(this)
                taskDatabaseHelper.addTask(Task(titleInputView.text.toString().trim(),descriptionInput.text.toString().trim()))
                taskAddedDialog.show()
            }else{
                Toast.makeText(this,"Title field can not be empty!",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}