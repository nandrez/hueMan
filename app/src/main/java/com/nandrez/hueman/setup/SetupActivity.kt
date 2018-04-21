/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.setup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.nandrez.hueman.R
import com.nandrez.hueman.setup.bridgeselection.BridgeSelectionContract
import com.nandrez.hueman.setup.bridgeselection.BridgeSelectionFragment
import com.nandrez.hueman.setup.bridgeselection.BridgeSelectionPresenter
import com.nandrez.hueman.util.HueActivities

class SetupActivity : AppCompatActivity() {

    private lateinit var presenter: BridgeSelectionContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fragment = getLightsFragment()
        presenter = BridgeSelectionPresenter(fragment)
    }

    private fun getLightsFragment(): BridgeSelectionFragment {
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.contentFragment) as BridgeSelectionFragment?
        if (fragment == null) {
            fragment = BridgeSelectionFragment.newInstance()
            HueActivities.addFragment(fragmentManager, fragment, R.id.contentFragment)
        }
        return fragment
    }

}
