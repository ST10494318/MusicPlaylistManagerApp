package za.ac.iie.musicplaylistmanagerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val songs = intent.getStringArrayListExtra("songs") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val songListText = findViewById<TextView>(R.id.songListText)
        val avgRatingText = findViewById<TextView>(R.id.avgRatingText)
        val backButton = findViewById<Button>(R.id.backButton)

        // Display song list
        val songDetails = songs.indices.joinToString("\n") { i ->
            "Song: ${songs[i]}, Artist: ${artists[i]}, Rating: ${ratings[i]}, Comment: ${comments[i]}"
        }
        songListText.text = songDetails

        // Calculate and display average rating
        val avgRating = if (ratings.isNotEmpty()) ratings.average() else 0.0
        avgRatingText.text = "Average Rating is : %.2f".format(avgRating)

        // Back button functionality
        backButton.setOnClickListener {
            finish()
        }
    }
}