class List<T>:Iterable<T>{
    private var head:Element<T>? = null

    private data class Element<T>(var element: T, var next: Element<T>?=null)

    operator fun contains(current:T):Boolean{
        var temp = head
        while (temp!=null){
            if(temp.element==current) return true
            temp=temp.next
        }
        return false
    }

    fun remove(element: T){
        var temp = head
        var tempPrevious = head
        while(temp!=null){
            if(temp.element==element) break
            tempPrevious=temp
            temp=temp.next
        }
        tempPrevious?.next=temp?.next
        if(temp==head) head=temp?.next
    }

    fun add(element: T){
        val newEl = Element(element)
        newEl.next=head
        head=newEl
    }

    fun showAll(){
        var temp = head
        while(temp!=null){
            print("${temp.element} ")
            temp=temp.next
        }
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var current = head
            override fun hasNext(): Boolean {
                return current!=null
            }

            override fun next(): T {
                val result = current!!.element
                if(!hasNext()) throw IndexOutOfBoundsException("End of list")
                current=current!!.next
                return result!!
            }
        }
    }
}
