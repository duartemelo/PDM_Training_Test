package ipca.plantas.a21149

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val plants = arrayListOf<Plant>()

    val adapter = PlantsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plants.add(Plant("Nome1", "Latin1", "Description"))
        plants.add(Plant("Nome2", "Latin2", "Description2"))
        plants.add(Plant("Nome3", "Latin3", "Description3"))

        val listViewPlants = findViewById<ListView>(R.id.listViewPlants)
        listViewPlants.adapter = adapter
        //adapter.notifyDataSetChanged()
    }

    inner class PlantsAdapter: BaseAdapter(){
        override fun getCount(): Int {
            return plants.size
        }

        override fun getItem(pos: Int): Any {
            return plants[pos]
        }

        override fun getItemId(p0: Int): Long {
            return 0L
        }

        override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_plant, parent, false)
            val textViewName = rootView.findViewById<TextView>(R.id.textViewName)
            val textViewLatinName = rootView.findViewById<TextView>(R.id.textViewLatinName)

            textViewName.text = plants[pos].name
            textViewLatinName.text = plants[pos].latinName

            rootView.setOnClickListener{
                val intent = Intent(this@MainActivity, PlantDetailActivity::class.java)
                intent.putExtra("name", plants[pos].name)
                intent.putExtra("latin_name", plants[pos].latinName)
                intent.putExtra("description", plants[pos].description)
                startActivity(intent)
            }

            return rootView
        }

    }
}