package com.example.myapplication.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.myapplication.databinding.FragmentHomeBinding
import java.io.File

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val player: PlayerView = binding.player




        /*val contract = registerForActivityResult(ActivityResultContracts.GetContent()) { it ->
            val playerExo = this.context?.let { context -> ExoPlayer.Builder(context).build() }
            var mediaItem = it?.let { uri -> MediaItem.fromUri(uri) }
            mediaItem?.let { media ->
                if (playerExo != null) {
                    playerExo.setMediaItem(media)
                }
            }
            player.player = playerExo
        }
        contract.launch("video/mp4")*/


        val playerExo = this.context?.let { context -> ExoPlayer.Builder(context).build() }

        //var mediaItem = MediaItem.fromUri("https://file-examples.com/storage/feb01e0890649c510949c8e/2017/04/file_example_MP4_480_1_5MG.mp4")
            var mediaItem = MediaItem.fromUri("https://devstreaming-cdn.apple.com/videos/streaming/examples/adv_dv_atmos/main.m3u8")
            mediaItem?.let { media ->
                if (playerExo != null) {
                    playerExo.setMediaItem(media)
                }
            }
            player.player = playerExo
            player.onResume()



                /*val textView: TextView = binding.textHome
                homeViewModel.text.observe(viewLifecycleOwner) {
                    textView.text = it
                }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}