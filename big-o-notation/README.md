# Big-O theory

## `O(1)`, or constant time complexity

`O(1)` means that the execution time (or number of operations) of an algorithm does not depend on the size of the input.

```kotlin
fun getFirstElement(arr: IntArray): Int {
    return arr[0]
}
```

**Key Idea:**

- Fastest possible time complexity
- Performance stays the same, whether input is 10 items or 10 million
- Efficient
- Doesn't grow with input size

## `O(n)`, or linear time complexity

`O(n)` means that the execution time grows directly in proportion to the input size.

```kotlin
fun sum(arr: IntArray): Int {
    var total = 0
    for (num in arr) {
        total += num
    }
    return total
}
```

**Key Idea:**

- Performance scales with input size
- Efficient for many tasks
- Slower than O(1) for large inputs

## `O(n^2)`, or quadratic time complexity

`O(n^2)` means the algorithm’s runtime grows proportionally to the square of the input size. This usually happens when there are nested loops over the input.

```kotlin
fun printAllPairs(arr: IntArray) {
    for (i in arr.indices) {
        for (j in arr.indices) {
            println("${arr[i]}, ${arr[j]}")
        }
    }
}
```

**Key Idea:**

- Two nested loops over the same input
- Time grows very quickly with input size
- Can get slow fast
- Usually avoided for large inputs

## `O(log n)`, or logarithmic time complexity

`O(log n)` means the algorithm's execution time grows slowly as the input size increases. Instead of checking every element, it cuts the problem in half each time.

```kotlin
fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}

```

**Key Idea:**

- Problem size is halved at each step
- Super efficient for large datasets (when applicable)
- Very fast
- Applicable for sorted or structured input

## `O(n log n)`, or linearithmic time complexity

`O(n log n)` means the algorithm does logarithmic work (`log n`) for each of the `n` elements

```java
// Most efficient sorting algorithms like Merge Sort and Heap Sort run in O(n log n)

void mergeSort(int[] arr) {
    // recursively splits the array in half (log n)
    // and merges n elements back together at each level
}
```

**Key Idea:**

- The problem is divided recursively `(log n)`
- All elements are touched (`n`) during processing and merging
- More complex than `O(n)`, but much faster than `O(n^2)`

## `O(n x m)` or product time complexity

Reflects how the total number of operations depends on both input sizes.

```kotlin
fun printAllPairs(a: IntArray, b: IntArray) {
    for (i in a.indices) {
        for (j in b.indices) {
            println("${a[i]}, ${b[j]}")
        }
    }
}
```

**Keynotes:**

- If `n == m`, then `O(n × m)` becomes `O(n^2)`
- If n and m are different inputs we should not simplify it to `O(n^2)`