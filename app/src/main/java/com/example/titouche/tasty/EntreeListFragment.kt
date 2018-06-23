package com.example.titouche.tasty


import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import com.example.titouche.tasty.R.styleable.AlertDialog
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
class EntreeListFragment : Fragment() {
    lateinit var res : Restaurant

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = ArrayList<Entree>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entree_list, container, false)
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         res = getActivity()!!.intent.getSerializableExtra("resto") as Restaurant
        //Initialize()
        loadData(res.id)
//        viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
//        viewAdapter = EntreeListAdapter(myDataset, getActivity()!!)
//        recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
//            setHasFixedSize(true)
//            layoutManager = viewManager
//            adapter = viewAdapter
//        }




    }

//    fun Initialize(){
//        myDataset.add(Entree("Tortilla", R.drawable.tortilla,
//                "Se consomme chaud ou froid. Avec du ketchup, c'est aussi très bon."))
//        myDataset.add(Entree("Tortilla", R.drawable.tortilla,
//                "Se consomme chaud ou froid. Avec du ketchup, c'est aussi très bon."))
//        myDataset.add(Entree("Tortilla", R.drawable.tortilla,
//                "Se consomme chaud ou froid. Avec du ketchup, c'est aussi très bon."))
//        myDataset.add(Entree("Tortilla", R.drawable.tortilla,
//                "Se consomme chaud ou froid. Avec du ketchup, c'est aussi très bon."))
//        myDataset.add(Entree("Tortilla", R.drawable.tortilla,
//                "Se consomme chaud ou froid. Avec du ketchup, c'est aussi très bon."))
//    }

    companion object {
        fun newInstance(): EntreeListFragment {
            var fragmentHome = EntreeListFragment()
            var args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }

    }

    private fun loadData(id: Int) {
        val call = RetrofitService.endpoint.getRestaurantEntrees(id)
        call.enqueue(object: Callback<ArrayList<Entree>> {

            override fun onFailure(call: Call<ArrayList<Entree>>?, t: Throwable?) {
                //progressBar.visibility = View.GONE
                //toast("erreur")
                Toast.makeText(getActivity()!!, "error while loading entrees", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<Entree>>?, response: Response<ArrayList<Entree>>?) {
                //progressBar.visibility = View.GONE
                if (response?.isSuccessful!!) {


                    val list:ArrayList<Entree> = response.body()!!

                    for (item in list) {
                        myDataset.add(item)
                    }
                } else {
                    Toast.makeText(getActivity()!!, response.toString(), Toast.LENGTH_SHORT).show()
                }
                viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
                viewAdapter = EntreeListAdapter(myDataset, this@EntreeListFragment.getActivity()!!)
                recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }



        })




    }
}
