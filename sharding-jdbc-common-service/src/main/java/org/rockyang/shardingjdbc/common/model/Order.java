package org.rockyang.shardingjdbc.common.model;

/**
 * @author l.k
 */
public final class Order {

	private Long orderId;

	private Long userId;

	private String title;

	public Order() {
	}

	public Order(long orderId, long userId) {
		this.orderId = orderId;
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", userId=" + userId +
				", title='" + title + '\'' +
				'}';
	}
}
