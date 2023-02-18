import java.util.Arrays
import java.util.Collections

internal object ArrayDasar {
    // Membuat array dengan 5 elemen
    // Array integer
    private var numbers = IntArray(5)

    // Array String
    private val words = arrayOfNulls<String>(5)

    // ArrayLIst
    private val alist = ArrayList<Int>()

    @JvmStatic
    fun main(args: Array<String>) {
        valueArray()
        showArrayNumber()
        arrayNumberShow()
        getItemArrayNumber(2)
        arrayNumberDelete(3)
        arrayNumberDeleteOtherWay(2)
        arrayNumberDeleteAll()
        arrayNumberDeleteAllOtherWay()

        arrayStringShow()
        showArrayString()
        editArrayString(4, "kontras")
        arrayStringAscending()
        arrayStringDescending()
    }

    private fun valueArray() {
        // Mengisi elemen array (angka) dengan nilai
        numbers[0] = 1
        numbers[1] = 200
        numbers[2] = 30
        numbers[3] = 4000
        numbers[4] = 15

        // Array (string)
        words[0] = "rangga"
        words[1] = "antika"
        words[2] = "nizham"
        words[3] = "haifa"
        words[4] = "oyen"
    }

    private fun showArrayNumber() {
        // Menampilkan elemen array 1 per 1
        println("\nMenampilkan elemen array 1 per 1:")
        for (x in numbers.indices) {
            println("$x ${numbers[x]}")
        }
    }

    private fun arrayNumberShow() {
        println("\nMenampilkan elemen array 1 per 1(foreach):")
        for (number in numbers) {
            println(" $number")
        }
    }

    private fun getItemArrayNumber(index: Int) {
        println("\nAmbil 1 item di index $index: ${numbers[index]}")
    }

    private fun arrayNumberDelete(index: Int) {
        showArrayNumber()

        // Create ArrayList from Array
        println("\nCreate ArrayList from Array.")
        for (number in numbers) {
            alist.add(number)
        }
        println("\nArrayList item: ")
        for (x in alist.indices) {
            println("$x  ${alist[x]}")
        }

        // Delete 1 item
        alist.removeAt(index)
        println("\nHapus elemen index: $index")
        println("\nArrayList item. Setelah dihapus: ")
        for (x in alist.indices) {
            println("$x  ${alist[x]}")
        }

        // Create Array from ArrayList
        println("\nCreate Array from ArrayList.")
        numbers = IntArray(4)
        for (y in alist.indices) {
            numbers[y] = alist[y]
        }
        showArrayNumber()
    }

    private fun arrayNumberDeleteOtherWay(index: Int) {
        showArrayNumber()

        val number = IntArray(numbers.size - 1)
        var x = 0
        var y = 0
        while (x < numbers.size) {
            if (x != index) {
                number[y] = numbers[x]
                y++
            }
            x++
        }
        numbers = number
        println("\nHapus elemen index: $index. Cara lain: ")
        showArrayNumber()
    }

    private fun arrayNumberDeleteAll() {
        showArrayNumber()
        Arrays.fill(numbers, 0)
        println("\nDelete all array item.")
        showArrayNumber()
    }

    private fun arrayNumberDeleteAllOtherWay() {
        showArrayNumber()
        numbers = IntArray(0)
        println("\nDelete all array item.")
        showArrayNumber()
    }

    private fun arrayStringShow() {
        println("\nMenampilkan elemen array 1 per 1(foreach):")
        for (word in words) {
            println(" $word")
        }
    }

    private fun showArrayString() {
        // Menampilkan elemen array 1 per 1
        println("\nMenampilkan elemen array 1 per 1:")
        for (x in words.indices) {
            println("$x  ${words[x]}")
        }
    }

    private fun editArrayString(index: Int, value: String) {
        showArrayString()
        words[index] = value
        println("\nEdit index: $index. Value: $value")
        showArrayString()
    }

    private fun arrayStringAscending() {
        showArrayString()
        Arrays.sort(words)
        println("\nSort Ascending")
        showArrayString()
    }

    private fun arrayStringDescending() {
        showArrayString()
        Arrays.sort(words, Collections.reverseOrder())
        println("\nSort Descending")
        showArrayString()
    }
}
