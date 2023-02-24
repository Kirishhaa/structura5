import kotlin.math.abs

class HashTable<T> {
    private val loadFactor = 0.5
    private var nItems = 0
    private var arraySlots = Array<Slot<T>>(8){Slot()}

    private class Slot<T>:Iterable<T>{
        private var list = List<T>()
        operator fun contains(element:T):Boolean = list.contains(element)
        override fun iterator(): Iterator<T> = list.iterator()
        fun add(element: T) = list.add(element)
        fun remove(element: T) = list.remove(element)

        fun toText() = list.showAll()
    }

    fun showAll(){
        for(index in arraySlots.indices) {
            print("[$index] -> ")
            arraySlots[index].toText()
            println()
        }
    }

    operator fun contains(element: T):Boolean{
        return arraySlots[hashFunction(element,arraySlots.size)].contains(element)
    }

    fun add(element: T):Boolean{
        if(!arraySlots[hashFunction(element,arraySlots.size)].contains(element)) {
            expandSize(nItems + 1)
            nItems++
            arraySlots[hashFunction(element, arraySlots.size)].add(element)
            return true
        }
        return false
    }
    fun remove(element: T):Boolean{
        if(arraySlots[hashFunction(element,arraySlots.size)].contains(element)){
            shrinkSize(nItems-1)
            nItems--
            arraySlots[hashFunction(element,arraySlots.size)].remove(element)
            return true
        }
        return false
    }

    private fun shrinkSize(amountItems: Int) {
        if(amountItems*1.0/arraySlots.size<loadFactor/2){
            val newArray = Array<Slot<T>>(arraySlots.size/2){Slot()}
            for (slot in arraySlots) {
                for(element in slot){
                    newArray[hashFunction(element, newArray.size)].add(element)
                }
            }
            arraySlots=newArray
        }
    }


    fun getSize() = arraySlots.size

    fun getCountItems() = nItems

    private fun expandSize(amountItems:Int){
        if(amountItems*1.0/arraySlots.size>loadFactor){
            val newArray = Array<Slot<T>>(arraySlots.size*2){Slot()}
            for (slot in arraySlots) {
                for(element in slot){
                    newArray[hashFunction(element, newArray.size)].add(element)
                }
            }
            arraySlots=newArray
        }
    }

    private fun hashFunction(element: T, size: Int) = abs(element.hashCode()%size)
}