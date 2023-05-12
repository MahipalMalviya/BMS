package com.mahipal.assignment

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahipal.assignment.adapter.ShowTimesAdapter
import com.mahipal.assignment.databinding.ActivityMainBinding
import com.mahipal.assignment.di.DaggerAppComponentProvider
import com.mahipal.assignment.viewmodel.MainViewModel
import com.mahipal.common_ui.viewmodel.ViewModelFactory
import com.mahipal.feature_one.FeatureOneActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var showTimesAdapter: ShowTimesAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerAppComponentProvider.getAppComponent().inject(mainActivity = this)

        initialize()
        fetchData()
        observeData()
    }

    private fun initialize() {
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        binding.rvMovies.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.rvMovies.adapter = showTimesAdapter

        showTimesAdapter.onShowTimeClick = {
            startActivity(
                Intent(this,FeatureOneActivity::class.java).apply {
                    putExtra("times",it)
                }
            )
        }
    }

    private fun observeData() {
        viewModel.venueList.observe(this) {
            showTimesAdapter.setData(it)
        }
        viewModel.progressData.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.error.observe(this) {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
    }

    private fun fetchData() {
        viewModel.getShowTimes()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_filter, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_filter -> {
                fetchData()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return false
    }

}