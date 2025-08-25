package com.vpe

import com.vpe.array.DynamicArray

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val a = DynamicArray(3)
    a.insert(3)
    a.insert(5)
    a.printItems()
}