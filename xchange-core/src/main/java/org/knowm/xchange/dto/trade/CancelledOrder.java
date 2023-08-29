package org.knowm.xchange.dto.trade;

import java.util.Objects;

/**
 * DTO representing a cancelled order
 *
 * <p>A cancelled order allows you to get the executed qty right from the api without takeing a roundtrip
 * to confirm that nothing was traded while the order was being canceled.
 */
public class CancelledOrder {
  private final long orderId;
  private final String origClientOrderId;
  private final String origQty;
  private final String executedQty;

  public CancelledOrder(long orderId, String origClientOrderId, String origQty, String executedQty) {
    this.orderId = orderId;
    this.origClientOrderId = origClientOrderId;
    this.origQty = origQty;
    this.executedQty = executedQty;
  }

  public long getOrderId() {
    return orderId;
  }

  public String getOrigClientOrderId() {
    return origClientOrderId;
  }

  public String getOrigQty() {
    return origQty;
  }

  public String getExecutedQty() {
    return executedQty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelledOrder that = (CancelledOrder) o;
    return orderId == that.orderId && Objects.equals(origClientOrderId,
        that.origClientOrderId) && Objects.equals(origQty, that.origQty)
        && Objects.equals(executedQty, that.executedQty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, origClientOrderId, origQty, executedQty);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CanceledOrder{");
    sb.append("orderId=").append(orderId);
    sb.append(", origClientOrderId='").append(origClientOrderId).append('\'');
    sb.append(", origQty='").append(origQty).append('\'');
    sb.append(", executedQty='").append(executedQty).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
