package com.pavelwinter.myorganizer.data.db.datamanagment

interface IDbDataManager<in T> {

   fun addObject(parentType : T)

   fun updateObject(parentType: T)

   fun deleteObject(id : Int)
}