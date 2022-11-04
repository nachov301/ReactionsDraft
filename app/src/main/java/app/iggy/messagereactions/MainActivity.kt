package app.iggy.messagereactions

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.iggy.messagereactions.Interfaces.AdapterCallback
import app.iggy.messagereactions.Adapter.MyAdapter

class MainActivity : AppCompatActivity(), AdapterCallback {
    private val TAG = "MainActivity"

    lateinit var myAdapter: MyAdapter
    lateinit var myRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRV = findViewById(R.id.recycler)
        myRV.layoutManager = LinearLayoutManager(this@MainActivity)

        val list: ArrayList<String> = arrayListOf()

        list.add("Message 1")
        list.add("Message 2")
        list.add("Message 3")
        list.add("Message 4")
        list.add("Message 5")
        list.add("Message 6")
        list.add("Message 7")
        list.add("Message 8")
        list.add("Message 9")
        list.add("Message 10")
        list.add("Message 11")
        list.add("Message 12")
        list.add("Message 13")
        list.add("Message 14")
        list.add("Message 15")
        list.add("Message 16")
        list.add("Message 17")

        myAdapter = MyAdapter(list, this as AdapterCallback)
        myRV.adapter = myAdapter

    }



    override fun callback(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_reactions)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.nav_crying -> {
                    Toast.makeText(this, "Crying", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_in_love -> {
                    Toast.makeText(this, "In love", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_laughing -> {
                    Toast.makeText(this, "Laughing", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_sad -> {
                    Toast.makeText(this, "Sad", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_smiling -> {
                    Toast.makeText(this, "Smiling", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }

        try {
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenu)
            menu.javaClass
                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(menu, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            popupMenu.show()
        }

    }
}