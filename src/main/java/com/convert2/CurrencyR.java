package com.convert2;

import java.util.Dictionary;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public record CurrencyR(@SerializedName("conversion_rates")HashMap<String, Double> conversion) {

}
