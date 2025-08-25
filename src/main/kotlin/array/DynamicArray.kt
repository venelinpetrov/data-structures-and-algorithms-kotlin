package com.vpe.array

class DynamicArray (initialCapacity: Int = 1) {
    private var count = 0
    private var items = IntArray(initialCapacity) { 0 }

    fun insert(item: Int) {
        ensureCapacity()
        items[count++] = item
    }

    fun delete(index: Int) {
        if (index < 0 || index >= count) {
            throw IllegalArgumentException()
        }
        for (i in index..< count - 1) {
            items[i] = items[i + 1]
        }

        count--
    }

    fun indexOf(item: Int): Int {
        for (i in 0..< count) {
            if (item == items[i]) {
                return i
            }
        }

        return -1
    }

    fun getAt(index: Int): Int {
        if (index < 0 || index >= count) {
            throw IllegalArgumentException()
        }

        return items[index]
    }

    fun reverse() {
        for (i in 0..< count / 2) {
            val tmp = items[i]
            items[i] = items[count - 1 - i]
            items[count - 1 - i] = tmp
        }
    }

    fun max(): Int {
        var max = items[0]
        for (item in items) {
            if (item > max) {
                max = item
            }
        }
        return max
    }

    fun insertAt(item: Int, index: Int) {
        if (index < 0 || index > count) {
            throw IllegalArgumentException()
        }

        ensureCapacity()

        for(i in (count - 1)downTo index) {
            items[i + 1] = items[i]
        }

        items[index] = item
        count++
    }

    fun printItems() {
        for (i in 0..<count) {
            println(items[i])
        }
    }

    private fun ensureCapacity() {
        if (items.size == count) {
            val newCapacity = if (items.isEmpty()) 1 else items.size * 2
            items = items.copyOf(newCapacity)
        }
    }
}