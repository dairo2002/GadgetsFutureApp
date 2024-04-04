package com.example.gadgetsfuture

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.gadgetsfuture.config.config
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserFragment : Fragment() {

    private lateinit var cardEditarDatos: CardView
    private lateinit var cardPedidosC: CardView
    private lateinit var historialPedidos: CardView
    private lateinit var cardCerrarSesion: CardView
    private lateinit var cardContacto: CardView
    private lateinit var url: String
    private lateinit var nombreCliente: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        nombreCliente = view.findViewById(R.id.txtNombreUser)
        cardEditarDatos = view.findViewById(R.id.cardEditarDatos)
        cardPedidosC = view.findViewById(R.id.cardPedidosC)
        historialPedidos = view.findViewById(R.id.historialPedidos)
        cardCerrarSesion = view.findViewById(R.id.cardCerrarSesion)
        cardContacto = view.findViewById(R.id.cardContacto)
        url = "https://wa.link/40y4dh"

        cardEditarDatos.setOnClickListener {
            val edit = Intent(requireContext(), Editar_datos::class.java)
            startActivity(edit)
        }

        cardPedidosC.setOnClickListener {
            val pedi = Intent(requireContext(), Pedidos_EnCamino::class.java)
            startActivity(pedi)
        }

        historialPedidos.setOnClickListener {
            val histo = Intent(requireContext(), Historial_pedidos::class.java)
            startActivity(histo)
        }

        cardContacto.setOnClickListener {
            openLink(url)
        }

        cardCerrarSesion.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    peticionCerrarSesion(
                        onSuccess = {message ->
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            // Redirigir a la pantalla de inicio de sesión después de cerrar sesión exitosamente
                            clearCredentials()
                            redirectToLoginActivity()
                        },
                        onError = { errorMessage ->
                            Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show()
                            //Toast.makeText(this@UserFragment, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    )
                } catch (error: Exception) {
                    Toast.makeText(activity, "Error al cerrar sesión $error", Toast.LENGTH_SHORT).show()
                }
            }
            // Limpiar las credenciales de inicio de sesión
            //clearCredentials()
            // Redirigir al usuario a la actividad de inicio de sesión
            //redirectToLoginActivity()

        }

        return view
    }

    private fun openLink(_url: String) {
        val uri = Uri.parse(_url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun clearCredentials() {
        val editor = config.SharedPreferences.edit()
        editor.remove("username")
        editor.remove("password")
        editor.apply()
        requireActivity().deleteSharedPreferences("username")
    }

    private fun redirectToLoginActivity() {
        //val intent = Intent(requireContext(), InicioSesion::class.java)
        val intent = Intent(context, InicioSesion::class.java)
        startActivity(intent)
        requireActivity().finish() // Cerrar la actividad actual (UserFragment)
    }

    suspend fun peticionCerrarSesion(onSuccess: (String) -> Unit, onError: (String) -> Unit){
        var queue= Volley.newRequestQueue(context)
        var url=config.urlCuenta+"v1/logout/"
        var request = JsonObjectRequest(
            Request.Method.POST,
            url,
            null,
            {response ->
                val message = response.getString("message")
                onSuccess.invoke(message)
            },
            {error ->
                onError.invoke("Error en la solicitud: $error")
            }
        )
        queue.add(request)
    }

    /*fun busca_cliente(){
        GlobalScope.launch {
            try {
                peticion_cliente()
            }catch (error:Exception){
            }
        }
    }

    suspend fun peticion_cliente(){
        val url = config().detalles + "urlCuenta"
        val queue = Volley.newRequestQueue(activity)
        val request = object : JsonObjectRequest(
            Method.GET,
            url,
            null,
            { response ->
                cargar_formulario(response)
            },
            { error ->
                Toast.makeText(
                    activity,
                    "Error en el servidor: $error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            // Aquí agregamos el token JWT a los encabezados de la solicitud
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                // Obtener el token JWT de tu configuración y agregarlo a los encabezados
                val token = config.token
                if (token.isNotEmpty()) {
                    headers["Authorization"] = "Bearer $token"
                }
                return headers
            }
        }
        queue.add(request)
    }
    fun cargar_formulario(registro: JSONObject){
        var nombre=registro.getString("nombre")
        if(nombre=="null"){
            nombre = registro.getString("username")
        }
        nombreCliente.setText(nombre)
        username.text = registro.getString("username")

    }*/
}
