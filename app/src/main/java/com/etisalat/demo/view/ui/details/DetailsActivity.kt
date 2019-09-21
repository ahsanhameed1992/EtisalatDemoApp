package com.etisalat.demo.view.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.etisalat.demo.R
import com.etisalat.demo.utils.Constants
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        val title = intent.getStringExtra(Constants.EXTRA_POST_TITLE)
        val body = intent.getStringExtra(Constants.EXTRA_POST_BODY)
        tv_body.text = body

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
