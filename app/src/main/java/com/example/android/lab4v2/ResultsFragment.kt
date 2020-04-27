package com.example.android.lab4v2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.android.lab4v2.databinding.FragmentAboutBinding
import com.example.android.lab4v2.databinding.FragmentResultsBinding
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_results.*

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment() {

    lateinit var str: String
    lateinit var str2: String


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentResultsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_results,
            container,
            false
        )


        binding.reiniciar.setOnClickListener{v:View->
            v.findNavController().navigate(R.id.action_resultsFragment_to_gameFragment)
        }


        (activity as AppCompatActivity).supportActionBar?.title = "Resultados"

        setHasOptionsMenu(true)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val asist = sharedPref?.getString("asist", "")
        val total = sharedPref?.getString("invitados", "")
        val lista = sharedPref?.getString("listado", "")

        binding.textView8.text = "Registrados: " + asist
        binding.textView7.text = "Invitados: " + total

        binding.button3.setOnClickListener{
            Toast.makeText(activity, lista, Toast.LENGTH_LONG).show()
        }

        return binding.root
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        when (item.itemId) {
            R.id.share_button -> {
                val lista = sharedPref?.getString("listado", "")
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, lista);
                startActivity(Intent.createChooser(shareIntent, "Share via"))

            }


        }
        return super.onOptionsItemSelected(item)
    }
}
