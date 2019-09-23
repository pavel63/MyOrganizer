package com.pavelwinter.myorganizer.data.db.datamanagment

interface IDbDataManager<in T> {

   fun addObject(parentType : T)

   fun updateObject(id :Long, parentType: T)

   fun deleteObject(id : Int)
}