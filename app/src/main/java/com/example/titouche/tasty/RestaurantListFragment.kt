package com.example.titouche.tasty


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RestaurantListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = ArrayList<Restaurant>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialize()
        loadData()
        viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
        viewAdapter = RestaurantListAdapter(myDataset, this!!.getActivity()!!)
        recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }


    }

//    fun Initialize(){
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//        myDataset.add(Restaurant("FAVORITA", R.drawable.favorita, "Favorita@gmail.com", "027 21 34 57", "facebook.com/FAVORITA", 36f, 37f))
//
//    }

    private fun loadData() {
        val listRestaurants = mutableListOf<Restaurant>()
        val call = RetrofitService.endpoint.getRestaurants()
        call.enqueue(object: Callback<ArrayList<Restaurant>> {

            override fun onFailure(call: Call<ArrayList<Restaurant>>?, t: Throwable?) {
                //progressBar.visibility = View.GONE
                //toast("erreur")
                Toast.makeText(getActivity()!!, "error", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<ArrayList<Restaurant>>?, response: Response<ArrayList<Restaurant>>?) {
                //progressBar.visibility = View.GONE
                if (response?.isSuccessful!!) {
                    val list:ArrayList<Restaurant> = response.body()!!

                    for (item in list) {
                        listRestaurants.add(item)
                        myDataset.add(item)
                    }
                    //val adapter = ArrayAdapter(getActivity()!!, android.R.layout.simple_list_item_1, listRestaurants)
                    //listView.adapter = adapter
                } else {
                    Toast.makeText(getActivity()!!, response.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}
