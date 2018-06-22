package com.example.titouche.tasty


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PlatListFragment : Fragment() {
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

        initialize()

        viewManager = LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false)
        viewAdapter = PlatListAdapter(myDataset, getActivity()!!)
        recyclerView = getActivity()!!.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }


    }

    fun initialize(){
        myDataset.add(Plat("Cuisses lapin", R.drawable.cuisselapinmoutarde,
                "Le lapin à la moutarde est un grand classique de la cuisine française."))
        myDataset.add(Plat("Cuisses lapin", R.drawable.cuisselapinmoutarde,
                "Le lapin à la moutarde est un grand classique de la cuisine française."))
        myDataset.add(Plat("Cuisses lapin", R.drawable.cuisselapinmoutarde,
                "Le lapin à la moutarde est un grand classique de la cuisine française."))
        myDataset.add(Plat("Cuisses lapin", R.drawable.cuisselapinmoutarde,
                "Le lapin à la moutarde est un grand classique de la cuisine française."))
        myDataset.add(Plat("Cuisses lapin", R.drawable.cuisselapinmoutarde,
                "Le lapin à la moutarde est un grand classique de la cuisine française."))
    }


}
