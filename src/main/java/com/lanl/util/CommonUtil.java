package com.lanl.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lanl.dto.Ohlc;
import com.lanl.model.Quote;

public class CommonUtil {

	public static List<Ohlc> convertQuotes(List<Quote> quotes) {
		List<Ohlc> ohlcs = new ArrayList<Ohlc>();
		
		for (Quote q: quotes) {
			ohlcs.add(new Ohlc(convertDate(q.getDate()), String.valueOf(q.getOpen()), String.valueOf(q.getHigh()), String.valueOf(q.getLow()), String.valueOf(q.getClose()), String.valueOf(q.getVolume())));
		}
		
		return ohlcs;
	}

	private static String convertDate(final Date date) {
		DateFormat df = new SimpleDateFormat("d-MMM-yy");
		
		return df.format(date);
	}

	static public String convertDecimal(final double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(value);
	}
	
}
