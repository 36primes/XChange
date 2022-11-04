package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.knowm.xchange.dto.Order.IOrderFlags;

public enum TimeInForce implements IOrderFlags {
  GTC,
  FOK,
  IOC
}
