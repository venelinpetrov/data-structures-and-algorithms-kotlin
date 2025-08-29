package com.vpe.linked_list

class LinkedList {
    private var first: Node? = null
    private var last: Node? = null
    private var size: Int = 0

    private class Node(val value: Int) {
        var next: Node? = null
    }

    fun addLast(value: Int) {
        val node = Node(value)

        if (isEmpty()) {
            first = node
            last = node
        } else {
            last?.next = node
            last = node
        }
        size++
    }

    fun addFirst(value: Int) {
        val node = Node(value)

        if (isEmpty()) {
            first = node
            last = node
        } else {
            node.next = first
            first = node
        }
        size++
    }

    fun deleteFirst() {
        if (isEmpty()) {
            return
        }

        if (first == last) {
            first = null
            last = null
        } else {
            val second = first?.next
            first?.next = null
            first = second
        }

        size--
    }

    fun deleteLast() {
        if (isEmpty()) {
            return
        }
        // 10 -> 20 -> 30 -> 40
        //                   ^ last
        if (first == last) {
            first = null
            last = null
        } else {
            var current = first
            while (current?.next != last) {
                current = current?.next
            }

            current?.next = null
            last = current
        }

        size--
    }

    operator fun contains(value: Int): Boolean {
        if (isEmpty()) {
            return false
        }
        var current = first
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = current.next
        }
        return false
    }
    
    fun reverse() {
        if (isEmpty()) {
            return;
        }

        var prev = first
        var current = first?.next

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        last = first
        last?.next = null
        first = prev
    }

    fun isEmpty(): Boolean = first == null

    override fun toString(): String {
        val values = buildList {
            var current = first
            while (current != null) {
                add(current.value)
                current = current.next
            }
        }
        return values.joinToString(prefix = "[", postfix = "]")
    }
}