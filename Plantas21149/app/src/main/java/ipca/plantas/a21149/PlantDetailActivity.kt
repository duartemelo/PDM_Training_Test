package ipca.plantas.a21149

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class PlantDetailActivity : AppCompatActivity() {

    val plant = Plant(null, null, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_detail)

        val name = intent.getStringExtra("name")
        val latinName = intent.getStringExtra("latin_name")
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.textViewDetailedName).text = name
        findViewById<TextView>(R.id.textViewDetailedLatinName).text = latinName
        findViewById<TextView>(R.id.textViewDetailedDescription).text = description

        plant.name = name
        plant.latinName = latinName
        plant.description = description
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.plant_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Plant name: ${plant.name}\nPlant latin name: ${plant.latinName}\nPlant description:${plant.description}")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
        return true
    }
}