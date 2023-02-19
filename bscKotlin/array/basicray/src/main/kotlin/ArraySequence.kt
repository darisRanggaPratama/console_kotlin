class ArraySequence {
    companion object {
        private var arrayInt: IntArray = intArrayOf(0)

        @JvmStatic
        fun main(args: Array<String>) {
            setArrayIntegerValue(100, 130)
            getFullArrayInteger()
            getFullArrayIntegerOther()
            getFullArrayIntegerDescending()
            getFullArrayIntegerAscending()
            getArrayNumber(5)
            editIntArrayItem(5, 100)
            deleteIntArrayItem(6)
            oddGreater(100)
            evenLess(110)
            getLastInteger(4)
            findIntegerValue(115)
            deleteIntegerValue(115)
            deleteIntArrayAll()
        }

        private fun setArrayIntegerValue(start: Int, end: Int) {
            // Membuat array integer dengan 11 elemen unik acak antara 0-20
            arrayInt = (start..end).shuffled().distinct().take(11).toIntArray()
        }

        private fun getFullArrayInteger() {
            // Menampilkan isi array
            println("\nSeluruh isi array (String): \n${arrayInt.contentToString()}")
        }

        private fun getFullArrayIntegerOther() {
            // Cara lain
            println("\nSeluruh isi array(String). Cara lain.")
            for (x: Int in 0..arrayInt.size - 1 step 1) {
                println("Index: $x Value: ${arrayInt[x]}")
            }
        }

        private fun getFullArrayIntegerAscending() {
            // Mengurutkan array secara ascending
            var ascending: List<Int> = arrayInt.asSequence().sorted().toList()
            println("\nSeluruh isi array (Integer. Ascending): \n$ascending")
        }

        private fun getFullArrayIntegerDescending() {
            // Mengurutkan array secara descending
            var descending: List<Int> = arrayInt.asSequence().sortedDescending().toList()
            println("\nSeluruh isi array (Integer. Descending): \n$descending")
        }

        private fun getArrayNumber(index: Int) {
            // Mengambil nilai tertentu
            var getIndex: Int = arrayInt.asSequence().elementAt(index)
            println("\nAmbil data di index: $index value: $getIndex")
        }

        private fun editIntArrayItem(idx: Int, number: Int) {
            getFullArrayIntegerOther()

            var editItem: IntArray = arrayInt.asSequence().mapIndexed { index: Int, value: Int ->
                if (index == idx) number else value
            }.toList().toIntArray()

            println("\nEdit data di index: $idx value: ${editItem[idx]}")
            for (x: Int in 0..editItem.size - 1 step 1) {
                println("Index: $x Value: ${editItem[x]}")
            }
        }

        private fun deleteIntArrayItem(idx: Int) {
            getFullArrayIntegerOther()

            println("\nHapus data di index: $idx value: ${arrayInt[idx]}")

            var deleteItem: IntArray = arrayInt.asSequence().filterIndexed() { index: Int, _: Int ->
                index != idx
            }.toList().toIntArray()

            for (x: Int in 0..deleteItem.size - 1 step 1) {
                println("Index: $x Value: ${deleteItem[x]}")
            }
        }

        private fun oddGreater(value: Int) {
            getFullArrayIntegerOther()
            getFullArrayIntegerDescending()

            var greaterOdd: List<Int> = arrayInt.asSequence().filter {
                it > value && it % 2 != 0
            }.toList()

            println("\nItem array lebih dari $value dan Ganjil: \n$greaterOdd")
        }

        private fun evenLess(value: Int) {
            getFullArrayIntegerOther()
            getFullArrayIntegerAscending()

            var lessEven: List<Int> = arrayInt.asSequence().filter {
                it < value && it % 2 == 0
            }.toList()

            println("\nItem array kurang dari $value dan Genap: \n$lessEven")
        }

        private fun getLastInteger(number: Int) {
            // Menampilkan array
            getFullArrayIntegerDescending()

            // Mengambil nilai yang lebih dari 100 dan angka terakhir bernilai 3 menggunakan Sequence
            val lastInt: List<Int> = arrayInt.asSequence()
                .filter { it > 0 }
                .filter { it % 10 == number }
                .toList()

            // Menampilkan hasilnya
            println("\nNilai yang lebih dari 100 dan \nangka terakhir bernilai $number: $lastInt")
        }

        private fun findIntegerValue(value: Int) {
            getFullArrayIntegerDescending()
            // Ambil elemen array bernilai 115 menggunakan Sequence
            val find: Int? = arrayInt.asSequence().filter { it == value }.firstOrNull()
            println("\nElemen $value: $find ditemukan")
        }

        private fun deleteIntegerValue(value: Int) {
            getFullArrayIntegerDescending()

            val (filteredArray: List<Int>, deleted: Int) = arrayInt.asSequence().filterNot { it == value }
                .toList() to arrayInt.count { it == value }
            println("\nArray setelah elemen $value dihapus: \n$filteredArray")
            println("\nElemen $value yang dihapus: $deleted")
        }

        private fun deleteIntArrayAll() {
            getFullArrayIntegerDescending()

            arrayInt.asSequence()
                .forEachIndexed { index, value -> arrayInt[index] = 0 }
            println("Array setelah dihapus: \n${arrayInt.contentToString()}")
        }
    }
}

/*
* Penjelasan kode di atas:

1. Kita membuat array berukuran 11 yang berisi angka acak antara 0 sampai dengan 20 menggunakan fungsi shuffled() dan take(11). Kemudian kita ubah ke tipe data IntArray.
2. Kita menggunakan fungsi contentToString() untuk menampilkan semua elemen dari array sebelum diurutkan.
3. Kita menggunakan asSequence() untuk mengubah array menjadi sequence agar bisa diurutkan menggunakan fungsi sorted().
4. Kita menampilkan hasil array yang telah diurutkan secara ascending menggunakan toList() untuk mengubah sequence menjadi list.
5. Kita menggunakan asSequence() lagi untuk mengubah array menjadi sequence dan kemudian menggunakan fungsi sortedDescending() untuk mengurutkan array secara descending.
6. Terakhir, kita menampilkan hasil array yang telah diurutkan secara descending menggunakan toList().
* */

/*
* Penjelasan:

* 1. Pertama-tama, kita menggunakan shuffled() pada range 0..20 untuk menciptakan array berisi angka acak antara 0 dan 20, lalu kita gunakan take(11) untuk membatasi panjang array menjadi 11 elemen dan distinct() untuk memastikan bahwa tidak ada elemen yang duplikat. Kemudian kita ubah menjadi array integer menggunakan toIntArray() dan simpan dalam variabel array.

* 2. Kita gunakan contentToString() untuk menampilkan isi dari array array.

* 3. Kita menggunakan asSequence() untuk mengubah array menjadi sebuah Sequence, lalu menggunakan elementAt(5) untuk mengambil nilai dari index 5 dan simpan dalam variabel valueAtIndex5.

* 4. Kita menggunakan mapIndexed() untuk mengubah nilai pada index 5 menjadi 100, lalu menggunakan toList() untuk mengubah kembali menjadi List dan terakhir toIntArray() untuk mengubah kembali ke tipe array integer. Hasilnya kita simpan dalam variabel newArray.

* 5. Kita menggunakan filterIndexed() pada newArray untuk menghapus nilai pada index 6, lalu gunakan toList() dan toIntArray() untuk mengubah kembali ke tipe array integer. Hasilnya kita simpan dalam variabel finalArray.

* 6.Kita gunakan contentToString() untuk menampilkan isi dari array finalArray.
* */

/*
* Penjelasan kode:
1. Kita mulai dengan membuat sebuah array dengan menggunakan shuffled() untuk mengacak angka dari 0 hingga 1000 dan take(11) untuk memilih 11 angka acak dari daftar tersebut. Kemudian kita memanggil distinct() untuk memastikan tidak ada duplikat dalam array dan mengembalikan IntArray yang dihasilkan.
2. Kita mencetak array yang dihasilkan menggunakan contentToString().
3. Kita menggunakan asSequence() untuk mengubah array menjadi sebuah sequence, kemudian kita memfilter elemen yang lebih besar dari 500 dan ganjil dengan menggunakan filter(). Hasil filter kemudian dikumpulkan kembali ke dalam sebuah list menggunakan toList().
4. Kita melakukan hal yang sama dengan mencari elemen yang kurang dari 500 dan genap.
5. Kode kemudian mencetak hasil dari kedua operasi filter menggunakan println().
*
* */

/*
* kita menggunakan asSequence() pada array yang telah dibuat, kemudian kita menggunakan dua operasi filter(). Pertama, kita mengambil nilai yang lebih dari 100 dengan it > 100. Kedua, kita mengambil nilai yang angka terakhirnya bernilai 3 dengan it % 10 == 3. Lalu, hasilnya kita ubah menjadi list menggunakan toList().
* */
