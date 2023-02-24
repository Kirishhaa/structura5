import java.util.Scanner

class MenuProgramm {
    private var hashTable = HashTable<Int>()
    private val sc = Scanner(System.`in`)
    fun run(){
        println("""
Enter an action:
1. add to hash
2. remove from hash
3. show all elements
4. contains function
5.get size of the array
6.get amount of items
7.exit""")
        when(sc.nextLine()){
            "1" -> {
                println("Enter an element:")
                hashTable.add(sc.nextLine().toInt())
                run()
            }
            "2" -> {
                println("Enter an element:")
                hashTable.remove(sc.nextLine().toInt())
                run()
            }
            "3" -> {hashTable.showAll();run()}
            "4" -> {
                println("Enter an element:")
                println(hashTable.contains(sc.nextLine().toInt()))
                run()
            }
            "5" -> {println(hashTable.getSize());run()}
            "6" -> {println(hashTable.getCountItems());run()}
            "7" -> return
            else -> run()
        }
    }
}