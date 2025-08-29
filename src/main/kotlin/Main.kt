package com.vpe

import com.vpe.linked_list.LinkedList

fun main() {
    val list = LinkedList()
    list.addLast(10)
    list.addLast(20)
    list.addLast(30)
    list.addLast(40)
    list.reverse()
    println(list.toString())
}