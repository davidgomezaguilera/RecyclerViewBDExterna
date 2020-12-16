package com.example.recyclerdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var coches: ArrayList<Coche> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initReycler()

        conectarJSON()
    }

    fun conectarJSON(){
        val url="http://iesayala.ddns.net/davidGomez/json/externa.php"

        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            println("Conexion correctamente")
            val jsonArray = JSONArray(response)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = JSONObject(jsonArray.getString(i))
                val marca = jsonObject.get("marca")
                val modelo = jsonObject.get("modelo")
                val precio = jsonObject.get("precio")
                val cv = jsonObject.get("CV")
                val id = jsonObject.get("id")
                //val imagen = jsonObject.get("ruta")
                val nuevo = Coche(marca.toString(),modelo.toString(), precio.toString().toLong(), cv.toString().toLong(),"")
                print(nuevo.marca)
                coches.add(nuevo)

            }
            initReycler()

        }, Response.ErrorListener {
            println("Error")
        })
        queue.add(stringRequest)
    }
    fun initReycler(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = cocheAdapter(coches)
        recyclerView.adapter = adapter
    }
}