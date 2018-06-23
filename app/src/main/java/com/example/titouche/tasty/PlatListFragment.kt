package com.example.titouche.tasty


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
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
class PlatListFragment : Fragment() {
    lateinit var res : Restaurant

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = ArrayList<Plat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        res = getActivity()!!.intent.getSerializableExtra("resto") as Restaurant

        //initialize()
        loadData(res.id)

        //viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
//        viewAdapter = PlatListAdapter(myDataset, this!!.getActivity()!!)
//
//
//        recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
//            setHasFixedSize(true)
//            layoutManager = viewManager
//            adapter = viewAdapter
//        }


    }

//    fun initialize(){
//        myDataset.add(Plat(null,null,"Cuisses lapin", R.drawable.cuisselapinmoutarde,
//                "Le lapin à la moutarde est un grand classique de la cuisine française."))
//        myDataset.add(Plat(null,null,"Cuisses lapin", R.drawable.cuisselapinmoutarde,
//                "Le lapin à la moutarde est un grand classique de la cuisine française."))
//        myDataset.add(Plat(null,null,"Cuisses lapin", R.drawable.cuisselapinmoutarde,
//                "Le lapin à la moutarde est un grand classique de la cuisine française."))
//        myDataset.add(Plat(null,null,"Cuisses lapin", R.drawable.cuisselapinmoutarde,
//                "Le lapin à la moutarde est un grand classique de la cuisine française."))
//        myDataset.add(Plat(null,null,"Cuisses lapin", R.drawable.cuisselapinmoutarde,
//                "Le lapin à la moutarde est un grand classique de la cuisine française."))
//    }

    private fun loadData(id: Int) {
        //val listPlats = mutableListOf<Plat>()
        val call = RetrofitService.endpoint.getRestaurantPlats(id)
        call.enqueue(object: Callback<ArrayList<Plat>> {

            override fun onFailure(call: Call<ArrayList<Plat>>?, t: Throwable?) {
                //progressBar.visibility = View.GONE
                //toast("erreur")
                Toast.makeText(getActivity()!!, "error while loading plats", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<Plat>>?, response: Response<ArrayList<Plat>>?) {
                //progressBar.visibility = View.GONE
                if (response?.isSuccessful!!) {


                    val list:ArrayList<Plat> = response.body()!!

                    for (item in list) {
          //              listPlats.add(item)
                        myDataset.add(item)
                        //Toast.makeText(getActivity()!!, ""+myDataset, Toast.LENGTH_LONG).show()//le toast affiche les plats
                    }
                } else {
                    Toast.makeText(getActivity()!!, response.toString(), Toast.LENGTH_SHORT).show()
                }
                viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
                viewAdapter = PlatListAdapter(myDataset, this@PlatListFragment.getActivity()!!)
                recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }



        })




    }
}
