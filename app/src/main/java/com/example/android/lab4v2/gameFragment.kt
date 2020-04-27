package com.example.android.lab4v2

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
    private var  asistentes = 0
    private var invitados = 0
    private var listado = ""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game, container, false)
        binding.guest = guest
        (activity as AppCompatActivity).supportActionBar?.title = "Registrando (1/10)"

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
                    asistentes += 1
                    textView3.text = personas[indexpersona].name
                    textView4.text = "Teléfono: " + personas[indexpersona].phone
                    textView5.text = "Email: " + personas[indexpersona].mail
                    (activity as AppCompatActivity).supportActionBar?.title = "Registrando (" + (indexpersona+1) +"/10)"
                    invitados +=1
                    listado += personas[indexpersona].name +": si, "

                }else{
                    asistentes+=1
                    invitados+=1
                    //listado += personas[indexpersona].name +": si."
                    indexpersona = 0
                    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPref?.edit()
                    if (editor != null) {
                        editor.putString("invitados", invitados.toString())
                        editor.putString("asist", asistentes.toString())
                        editor.putString("listado", listado)
                        editor.apply()
                    }
                    view?.findNavController()?.navigate(R.id.action_gameFragment_to_resultsFragment)



                }
            }



            R.id.deny_button -> {
                if(indexpersona < 10){
                    textView3.text = personas[indexpersona].name
                    textView4.text = "Teléfono: " + personas[indexpersona].phone
                    textView5.text = "Email: " + personas[indexpersona].mail
                    (activity as AppCompatActivity).supportActionBar?.title = "Registrando (" + (indexpersona+1) +"/10)"
                    invitados += 1
                    listado += personas[indexpersona].name +": no, "
                }else{
                    //listado += personas[indexpersona].name +": no."
                    indexpersona = 0
                    invitados+=1

                    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPref?.edit()
                    if (editor != null) {
                        editor.putString("invitados", invitados.toString())
                        editor.putString("asist", asistentes.toString())
                        editor.putString("listado", listado)
                        editor.apply()
                    }
                    view?.findNavController()?.navigate(R.id.action_gameFragment_to_resultsFragment)

                }
            }

        }
        return super.onOptionsItemSelected(item)
    }









}
