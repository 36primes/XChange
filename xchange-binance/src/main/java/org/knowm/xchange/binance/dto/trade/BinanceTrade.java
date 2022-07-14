package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public final class BinanceTrade {

  public final long id;
  public final long orderId;
  public final BigDecimal price;
  public final BigDecimal qty;
  public final BigDecimal commission;
  public final String commissionAsset;
  public final long time;
  public final boolean isBuyer;
  public final boolean isMaker;
  public final boolean isBestMatch;

  public BinanceTrade(
          @JsonProperty("id") long id,
          @JsonProperty("orderId") long orderId,
          @JsonProperty("price") BigDecimal price,
          @JsonProperty("qty") BigDecimal qty,
          @JsonProperty("commission") BigDecimal commission,
          @JsonProperty("commissionAsset") String commissionAsset,
          @JsonProperty("time") long time,
          @JsonProperty("isBuyer") boolean isBuyer,
          @JsonProperty("isMaker") boolean isMaker,
          @JsonProperty("isBestMatch") boolean isBestMatch) {
    this.id = id;
    this.orderId = orderId;
    this.price = price;
    this.qty = qty;
    this.commission = commission;
    this.commissionAsset = commissionAsset;
    this.time = time;
    this.isBuyer = isBuyer;
    this.isMaker = isMaker;
    this.isBestMatch = isBestMatch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BinanceTrade that = (BinanceTrade) o;
    return id == that.id && orderId == that.orderId && time == that.time && isBuyer == that.isBuyer && isMaker == that.isMaker && isBestMatch == that.isBestMatch && Objects.equals(price, that.price) && Objects.equals(qty, that.qty) && Objects.equals(commission, that.commission) && Objects.equals(commissionAsset, that.commissionAsset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId, price, qty, commission, commissionAsset, time, isBuyer, isMaker, isBestMatch);
  }

  public Date getTime() {
    return new Date(time);
  }

  @Override
  public String toString() {
    return "BinanceTrade{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", price=" + price +
            ", qty=" + qty +
            ", commission=" + commission +
            ", commissionAsset='" + commissionAsset + '\'' +
            ", time=" + time +
            ", isBuyer=" + isBuyer +
            ", isMaker=" + isMaker +
            ", isBestMatch=" + isBestMatch +
            '}';
  }
}
