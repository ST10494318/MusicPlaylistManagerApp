package za.ac.iie.musicplaylistmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var SongName : EditText
    private lateinit var ArtistName : EditText
    private lateinit var SonRating : EditText
    private lateinit var SongComment : EditText
    private lateinit var addButton : Button
    private lateinit var ViewButton : Button
    private lateinit var ExitButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}