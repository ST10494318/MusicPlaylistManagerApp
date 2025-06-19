package za.ac.iie.musicplaylistmanagerapp

// CHRIS LUFUILU ST10494318


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var songsInput: EditText
    private lateinit var artistInput: EditText
    private lateinit var ratingsInput: EditText
    private lateinit var commentsInput: EditText
    private lateinit var addButton: Button
    private lateinit var viewButton: Button
    private lateinit var exitButton: Button

    // Parallel array for data storing
    private val songs = mutableListOf<String>()
    private val artists = mutableListOf<String>()
    private val ratings = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI components
        songsInput = findViewById(R.id.songsInput)
        artistInput = findViewById(R.id.artistInput)
        ratingsInput = findViewById(R.id.ratingsInput)
        commentsInput = findViewById(R.id.commentsInput)
        addButton = findViewById(R.id.addButton)
        viewButton = findViewById(R.id.viewButton)
        exitButton = findViewById(R.id.exitButton)

        // Addbutton function
        addButton.setOnClickListener {
            val Song = songsInput.text.toString()
            val Artist = artistInput.text.toString()
            val Rating = ratingsInput.text.toString().toIntOrNull()
            val Comment = commentsInput.text.toString()

            if (Song.isNotEmpty() && Artist.isNotEmpty() && Rating != null && Rating in 1..5 && Comment.isNotEmpty()) {
                songs.add(Song)
                artists.add(Artist)
                ratings.add(Rating)
                comments.add(Comment)
                Log.d("PlaylistApp", "Added: $Song by $Artist, Rating: $Rating")
                Toast.makeText(this, "Song added to playlist", Toast.LENGTH_SHORT).show()
                clearInputs()
            } else {
                Toast.makeText(this, "Please enter valid details (Rating 1-5)", Toast.LENGTH_SHORT).show()
            }
        }

        // Viewbutton function
        viewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putStringArrayListExtra("songs", ArrayList(songs))
            intent.putStringArrayListExtra("artists", ArrayList(artists))
            intent.putIntegerArrayListExtra("ratings", ArrayList(ratings))
            intent.putStringArrayListExtra("comments", ArrayList(comments))
            startActivity(intent)
        }

        // Exit button function
        exitButton.setOnClickListener {
            finish()
        }
    }


    // Clearbutton function
    private fun clearInputs() {
        songsInput.text.clear()
        artistInput.text.clear()
        ratingsInput.text.clear()
        commentsInput.text.clear()
    }
}