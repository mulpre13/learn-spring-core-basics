package woosung.learn.springcorebasics.order

data class Order(
    val memberId: Long, val itemName: String, val itemPrice: Int, val discountPrice: Int
) {
    val finalPrice = itemPrice - discountPrice
}
