package com.vpe

import com.vpe.array.DynamicArray

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var arr1 = DynamicArray(3)
    for (i in 1..4) {
        arr1.insert(i)
    }

    var arr2 = DynamicArray(2)
    arr2.insert(2)
    arr2.insert(3)

    val intersection = arr1.intersect(arr2)
    intersection.printItems()
}