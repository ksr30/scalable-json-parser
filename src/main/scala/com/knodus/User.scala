package com.knodus

//case class User(
//                 @JsonProperty("id") id:Int,
//                 @JsonProperty("name") name:String,
//                 @JsonProperty("age") age:Int,
//                 @JsonProperty("address") address:String)

class User {
  private var id: Int = 0
  private var name: String = " "
  private var age: Int = 0
  private var address: String = " "

  def this(id: Int, name: String, age: Int, address: String) {
    this()
    this.id = id
    this.name = name
    this.age = age
    this.address = address
  }

  def getName: String = this.name

  def getAge: Int = this.age

  def getId: Int = this.id

  def getAddress: String = this.address

  override def toString: String = "User(" + name + ", " + age + ", " + id + ", " + address + ")"
}