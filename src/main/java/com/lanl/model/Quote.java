package com.lanl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="quote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quote extends BaseModel {
	
	private static final long serialVersionUID = 4192997147639777672L;

	@Column(name="symbol")
	private String symbol;

	@Column(name="price_time")
	private Date date;

	@Column(name="close_price")
	private Float close;

	@Column(name="high_price")
	private Float high;

	@Column(name="low_price")
	private Float low;

	@Column(name="open_price")
	private Float open;

	@Column(name="volume")
	private Double volume;

	public Quote(String symbol, Date date, Float open, Float high, Float low,
			Float close, Double volume) {
		this.symbol = symbol;
		this.date = date;
		this.close = close;
		this.high = high;
		this.low = low;
		this.open = open;
		this.volume = volume;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getClose() {
		return close;
	}

	public void setClose(Float close) {
		this.close = close;
	}

	public Float getHigh() {
		return high;
	}

	public void setHigh(Float high) {
		this.high = high;
	}

	public Float getLow() {
		return low;
	}

	public void setLow(Float low) {
		this.low = low;
	}

	public Float getOpen() {
		return open;
	}

	public void setOpen(Float open) {
		this.open = open;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Quote quote = (Quote) o;

		if (!symbol.equals(quote.symbol))
			return false;
		if (!date.equals(quote.date))
			return false;
		if (!open.equals(quote.open))
			return false;
		if (!high.equals(quote.high))
			return false;
		if (!low.equals(quote.low))
			return false;
		if (!close.equals(quote.close))
			return false;
		if (!volume.equals(quote.volume))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Quote [symbol=" + symbol + ", date=" + date + ", close="
				+ close + ", high=" + high + ", low=" + low + ", open=" + open
				+ ", volume=" + volume + "]";
	}

}