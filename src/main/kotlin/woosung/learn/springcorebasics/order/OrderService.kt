package woosung.learn.springcorebasics.order

fun interface OrderService {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}