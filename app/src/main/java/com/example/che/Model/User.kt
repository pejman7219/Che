package com.example.che.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class User : RealmObject() {

    @PrimaryKey
    var Id : Long? = null
    var Name : String? = null
    var Family : String? = null





}