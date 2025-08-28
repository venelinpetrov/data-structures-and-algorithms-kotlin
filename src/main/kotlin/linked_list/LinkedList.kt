package com.vpe.linked_list

class LinkedList {
    private var first: Node? = null
    private var last: Node? = null
    private var size: Int = 0

    private class Node(private val value: Int) {
        var next: Node? = null
        override fun toString(): String {
            return "Node(value=$value, next=$next)"
        }
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
        var node = Node(value)

        if (isEmpty()) {
            first = node
            last = node
        } else {
            node?.next = first
            first = node
        }
        size++
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    override fun toString(): String {
        return "LinkedList(first=$first, last=$last)"
    }
}