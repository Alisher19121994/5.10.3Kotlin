package com.example.a5103kotlin


import java.util.*
import kotlin.collections.ArrayList

class Main {

    var story: LinkedList<Story> = LinkedList()
     var photo: ArrayList<Photo> = ArrayList()
     var adds: Adds?=null

    constructor()
    constructor(story: LinkedList<Story>) {
        this.story = story
    }

    constructor(photo: ArrayList<Photo>) {
        this.photo = photo
    }

    constructor(adds: Adds?) {
        this.adds = adds
    }


}