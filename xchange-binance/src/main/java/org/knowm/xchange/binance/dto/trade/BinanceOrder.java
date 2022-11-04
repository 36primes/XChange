package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public final class BinanceOrder {

  public final String symbol;
  public final long orderId;
  public final String clientOrderId;
  public final BigDecimal price;
  public final BigDecimal origQty;
  public final BigDecimal executedQty;
  public final BigDecimal cummulativeQuoteQty;
  public final OrderStatus status;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final OrderSide side;
  public final BigDecimal stopPrice;
  public final BigDecimal icebergQty;
  public final long time;

  public BinanceOrder(
          @JsonProperty("symbol") String symbol,
          @JsonProperty("orderId") long orderId,
          @JsonProperty("clientOrderId") String clientOrderId,
          @JsonProperty("price") BigDecimal price,
          @JsonProperty("origQty") BigDecimal origQty,
          @JsonProperty("executedQty") BigDecimal executedQty,
          @JsonProperty("cummulativeQuoteQty") BigDecimal cummulativeQuoteQty,
          @JsonProperty("status") OrderStatus status,
          @JsonProperty("timeInForce") TimeInForce timeInForce,
          @JsonProperty("type") OrderType type,
          @JsonProperty("side") OrderSide side,
          @JsonProperty("stopPrice") BigDecimal stopPrice,
          @JsonProperty("icebergQty") BigDecimal icebergQty,
          @JsonProperty("time") long time) {
    this.symbol = symbol;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.cummulativeQuoteQty = cummulativeQuoteQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
    this.stopPrice = stopPrice;
    this.icebergQty = icebergQty;
    this.time = time;
  }

  public Date getTime() {
    return new Date(time);
  }

  @Override
  public String toString() {
    return "BinanceOrder{" +
            "symbol='" + symbol + '\'' +
            ", orderId=" + orderId +
            ", clientOrderId='" + clientOrderId + '\'' +
            ", price=" + price +
            ", origQty=" + origQty +
            ", executedQty=" + executedQty +
            ", cummulativeQuoteQty=" + cummulativeQuoteQty +
            ", status=" + status +
            ", timeInForce=" + timeInForce +
            ", type=" + type +
            ", side=" + side +
            ", stopPrice=" + stopPrice +
            ", icebergQty=" + icebergQty +
            ", time=" + time +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BinanceOrder that = (BinanceOrder) o;
    return orderId == that.orderId && time == that.time && Objects.equals(symbol, that.symbol) && Objects.equals(clientOrderId, that.clientOrderId) && Objects.equals(price, that.price) && Objects.equals(origQty, that.origQty) && Objects.equals(executedQty, that.executedQty) && Objects.equals(cummulativeQuoteQty, that.cummulativeQuoteQty) && status == that.status && timeInForce == that.timeInForce && type == that.type && side == that.side && Objects.equals(stopPrice, that.stopPrice) && Objects.equals(icebergQty, that.icebergQty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, orderId, clientOrderId, price, origQty, executedQty, cummulativeQuoteQty, status, timeInForce, type, side, stopPrice, icebergQty, time);
  }
}
