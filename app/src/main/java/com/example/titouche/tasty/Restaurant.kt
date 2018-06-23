package com.example.titouche.tasty

import java.io.Serializable

class Restaurant(var id:Int, var nom:String, var image:String, var email:String?, var phone:String?,
                 var Facebook:String?, var longe:Float?, var lat:Float?):Serializable {

}