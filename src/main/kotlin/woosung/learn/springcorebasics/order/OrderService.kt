package woosung.learn.springcorebasics.order

interface OrderService {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}