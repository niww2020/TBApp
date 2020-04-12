package com.example.tbapp.ui.dashboard

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tbapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        val webView:WebView  = root.findViewById(R.id.web_view)
        val webView2:WebView  = root.findViewById(R.id.web_view2)
        val webView3:WebView  = root.findViewById(R.id.web_view3)

        webView.settings.javaScriptEnabled = true
        webView2.settings.javaScriptEnabled = true
        webView3.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com/embed/3RuPQ9VW_x8")
        webView2.loadUrl("https://www.youtube.com/embed/XqPe_iAm8lI")
        webView3.loadUrl("https://www.youtube.com/embed/XqPe_iAm8lI")


        return root



    }
}