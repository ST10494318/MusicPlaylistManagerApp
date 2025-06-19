package za.ac.iie.musicplaylistmanagerapp

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

    // Parallel arrays to store data
    private val songs = mutableListOf<String>()
    private val artists = mutableListOf<String>()
    private val ratings = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        songsInput = findViewById(R.id.songsInput)
        artistInput = findViewById(R.id.artistInput)
        ratingsInput = findViewById(R.id.ratingsInput)
        commentsInput = findViewById(R.id.commentsInput)
        addButton = findViewById(R.id.addButton)
        viewButton = findViewById(R.id.viewButton)
        exitButton = findViewById(R.id.exitButton)

        // Add button functionality
        addButton.setOnClickListener {
            val song = songsInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingsInput.text.toString().toIntOrNull()
            val comment = commentsInput.text.toString()

            if (song.isNotEmpty() && artist.isNotEmpty() && rating != null && rating in 1..5 && comment.isNotEmpty()) {
                songs.add(song)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)
                Log.d("PlaylistApp", "Added: $song by $artist, Rating: $rating")
                Toast.makeText(this, "Song added to playlist", Toast.LENGTH_SHORT).show()
                clearInputs()
            } else {
                Toast.makeText(this, "Please enter valid details (Rating 1-5)", Toast.LENGTH_SHORT).show()
            }
        }

        // View button functionality
        viewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putStringArrayListExtra("songs", ArrayList(songs))
            intent.putStringArrayListExtra("artists", ArrayList(artists))
            intent.putIntegerArrayListExtra("ratings", ArrayList(ratings))
            intent.putStringArrayListExtra("comments", ArrayList(comments))
            startActivity(intent)
        }

        // Exit button functionality
        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun clearInputs() {
        songsInput.text.clear()
        artistInput.text.clear()
        ratingsInput.text.clear()
        commentsInput.text.clear()
    }
}