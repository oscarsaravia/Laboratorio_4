package com.example.android.lab4v2

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.lab4v2.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * A simple [Fragment] subclass.
 */
class gameFragment : Fragment() {




    private val personas: MutableList<Guest> = mutableListOf(
        Guest(name = "Oscar Saravia", phone = "57469845", mail = "oscarsaravia@gmail.com"),
        Guest(name = "Carlos Perez", phone = "67345698", mail = "carlosperez@gmail.com"),
        Guest(name = "Maria Suarez", phone = "45673459", mail = "msuarez@gmail.com"),
        Guest(name = "Carla Lopez", phone = "34890567", mail = "carlop@gmail.com"),
        Guest(name = "Raul Jimenez", phone = "34567654", mail = "rjimenez@gmail.com"),
        Guest(name = "Marcos Alonso", phone = "54543212", mail = "alonso98@gmail.com"),
        Guest(name = "Lourdes Garcia", phone = "56734589", mail = "lgar@gmail.com"),
        Guest(name = "Esteban Gonzales", phone = "45667345", mail = "exteben@gmail.com"),
        Guest(name = "Cinthia Saravia", phone = "45345909", mail = "cmaria@gmail.com"),
        Guest(name = "Oscar Lopez", phone = "34534588", mail = "oscarlop@gmail.com")
    )

    lateinit var personaActual: Guest
    private var indexpersona = 0
    private var guest = Guest()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        binding.guest = guest

        binding.apply {
            binding.invalidateAll()
            textView3.text = personas[indexpersona].name
            textView4.text = "TEL: " + personas[indexpersona].phone
            textView5.text = "email: " + personas[indexpersona].mail

        }

        if(indexpersona == 9){

        }


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.answer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        indexpersona += 1
        when(item.itemId){

            R.id.check_button -> {
                if(indexpersona < 10){
                    textView3.text = personas[indexpersona].name
                    textView4.text = "Teléfono: " + personas[indexpersona].phone
                    textView5.text = "Email: " + personas[indexpersona].mail
                }else{
                    Toast.makeText(activity, "TOPE", Toast.LENGTH_SHORT).show()
                }
            }



            R.id.deny_button -> {
                if(indexpersona < 10){
                    textView3.text = personas[indexpersona].name
                    textView4.text = "Teléfono: " + personas[indexpersona].phone
                    textView5.text = "Email: " + personas[indexpersona].mail
                }else{
                    Toast.makeText(activity, "TOPE", Toast.LENGTH_SHORT).show()
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun change_values(){




    }





}
