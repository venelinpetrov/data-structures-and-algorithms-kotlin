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
        for (i in index until count - 1) {
            items[i] = items[i + 1]
        }
        items[count - 1] = 0
        count--
    }

    fun indexOf(item: Int): Int {
        for (i in 0 until count) {
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
        for (i in 0 until count / 2) {
            val tmp = items[i]
            items[i] = items[count - 1 - i]
            items[count - 1 - i] = tmp
        }
    }

    fun max(): Int {
        if (count == 0) {
            throw IllegalStateException("Array is empty")
        }

        var max = items[0]

        for (i in 1 until count) {
            if (items[i] > max) {
                max = items[i]
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

    fun intersect(other: DynamicArray): DynamicArray {
        val smaller = if (this.count > other.count) other else this
        val larger = if (this.count <= other.count) this else other

        if (other.count == 0) {
            return DynamicArray(1)
        }

        val intersection = DynamicArray(smaller.count)

        for (i in 0 until smaller.count) {
            val item = smaller.getAt(i)

            if (larger.indexOf(item) > -1 && intersection.indexOf(item) == -1) {
                intersection.insert(item)
            }
        }

        return intersection
    }

    fun printItems() {
        for (i in 0 until count) {
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