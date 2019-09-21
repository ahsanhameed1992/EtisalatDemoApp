package com.etisalat.demo.utils;

import android.view.View;
import androidx.databinding.BindingConversion;

public class BindingUtils {
  @BindingConversion
  public static int bindingVisibility(boolean visible) {
    return visible ? View.VISIBLE : View.GONE;
  }
}
