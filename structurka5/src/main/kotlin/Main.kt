import java.lang.System.*

fun main() {
    println("adding time 10^6 elems to my hash = ${getTimeDifferenceMyHash()}ms")
    println("adding time 10^6 elems to hashSet = ${getTimeDifferenceHashSet()}ms")
    MenuProgramm().run()
}

private fun getTimeDifferenceHashSet():Long{
    val hashTable = HashSet<Int>()
    val t1 = currentTimeMillis()
    for (i in 0 until 1000000)
        hashTable.add((-10000..10000).random())

    for (i in 0 until 1000000)
        hashTable.remove((-10000..10000).random())

    val t2 = currentTimeMillis()
    return t2-t1
}

private fun getTimeDifferenceMyHash():Long {
    val hashTable = HashTable<Int>()
    val t1 = currentTimeMillis()
    for (i in 0 until 1000000)
        hashTable.add((-10000..10000).random())

    for (i in 0 until 100000)
        hashTable.remove((-10000..10000).random())

    val t2 = currentTimeMillis()
    return t2-t1
}
