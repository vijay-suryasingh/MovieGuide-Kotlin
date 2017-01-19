package com.esoxjem.movieguide.movies.listing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.esoxjem.movieguide.MovieGuideApp
import com.esoxjem.movieguide.R
import javax.inject.Inject

/**
 * @author arunsasidharan
 */
class ListingFragment : Fragment(), ListingView {

    @Inject
    lateinit var presenter : ListingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context.applicationContext as MovieGuideApp).createListingComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (context.applicationContext as MovieGuideApp).releaseListingComponent()
    }
}