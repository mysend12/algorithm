package lv2

fun main() {
    tailrec fun checkDiscount(
        index: Int,
        products: Map<String, Int>,
        discount: Array<String>,
    ): Int = when (products.isEmpty()) {
        true -> 1
        false -> {
            when (index == 10) {
                true -> 0
                false -> {
                    val product = discount[index]
                    when (products[product] == null) {
                        true -> checkDiscount(
                            index = index + 1,
                            products = products,
                            discount = discount,
                        )

                        false -> {
                            val copyProducts = products.toMutableMap()
                            copyProducts[product] = products[product]!! - 1
                            if (copyProducts[product] == 0) copyProducts.remove(product)

                            checkDiscount(
                                index = index + 1,
                                products = copyProducts,
                                discount = discount,
                            )
                        }
                    }
                }
            }
        }
    }

    tailrec fun tailRecursive(
        index: Int,
        products: Map<String, Int>,
        discount: Array<String>,
        count: Int,
    ): Int = when (index == discount.size - 9) {
        true -> count
        false -> tailRecursive(
            index = index + 1,
            products = products,
            discount = discount,
            count = count + checkDiscount(
                index = 0,
                products = products,
                discount = discount.sliceArray(
                    IntRange(index, index + 9)
                ),
            )
        )
    }

    fun solution(
        want: Array<String>,
        number: IntArray,
        discount: Array<String>,
    ): Int = tailRecursive(
        index = 0,
        products = want.mapIndexed { index, product -> product to number[index] }.toMap(),
        discount = discount,
        count = 0,
    )



    println(
        solution(
            want = arrayOf(
                "banana", "apple", "rice", "pork", "pot"
            ),
            number = intArrayOf(
                3, 2, 2, 2, 1
            ),
            discount = arrayOf(
                "chicken",
                "apple",
                "apple",
                "banana",
                "rice",
                "apple",
                "pork",
                "banana",
                "pork",
                "rice",
                "pot",
                "banana",
                "apple",
                "banana"
            )
        )
//        solution(
//            want = arrayOf("apple"),
//            number = intArrayOf(10),
//            discount = arrayOf(
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana",
//                "banana"
//            ),
//        )
    )


}