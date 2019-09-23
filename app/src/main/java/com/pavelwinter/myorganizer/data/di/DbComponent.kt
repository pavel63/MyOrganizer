package com.pavelwinter.myorganizer.data.di

import com.pavelwinter.myorganizer.presentation.fragments.Forms.AddTaskFragment
import dagger.Component

@Component(modules = [DbModule::class])
interface DbComponent {

   fun inject(addtaskFragment : AddTaskFragment)
}