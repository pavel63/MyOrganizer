package com.pavelwinter.myorganizer.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType

    class ProductDiffUtilCallback(
        private val oldList: List<ParentType>,
        private val newList: List<ParentType>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val (id) = oldList[oldItemPosition]
            val (id1) = newList[newItemPosition]
            return id == id1
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val (id, name, _) = oldList[oldItemPosition]
            val (id1, name1, _) = newList[newItemPosition]
            return id == id1 && name == name1
        }

 }