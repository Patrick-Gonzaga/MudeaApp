package com.example.mudea.fragments.cardsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mudea.R
import com.example.mudea.data.Personagens
import com.example.mudea.databinding.FragmentAlbumBinding
import com.example.mudea.util.PersonagensAdapter

class AlbumFragment : Fragment() {
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PersonagensAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //here
        val recyclerView = binding.recyclerAlbum

        val list: List<Personagens> = listOf(
            Personagens(
                "https://s2-ge.glbimg.com/Yw7BaSksCttx4VucoPo0Cd1jeeQ=/0x0:4000x3033/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2023/v/i/nd1eWjSu2iiQKAbek6Yg/12a4827.jpg",
                "Neymar Jr.",
                "Brasileirão Série A",
                91239
            ),
            Personagens(
                "https://static.wikia.nocookie.net/naruto/images/2/24/Itachi-Uchiha.png/revision/latest/scale-to-width-down/1000?cb=20181104200812&path-prefix=pt-br",
                "Itachi Uchiha",
                "Naruto",
                13423
            ),
            Personagens(
                "https://animeflix.com.br/wp-content/uploads/2025/04/one-piece-luffy-pode-ganhar-dois-aliados-poderosos.jpg",
                "Monkey D. Luffy",
                "One Piece",
                24356
            ),
            Personagens(
                "https://animecomics.com.br/animecomics/images/upload/426.jpg",
                "Light Yagami",
                "Death Note",
                32455
            ),
            Personagens(
                "https://recreio.com.br/wp-content/uploads/2024/05/goku_capa-1.jpg",
                "Goku",
                "Dragon Ball",
                53322
            ),
            Personagens(
                "https://static.wikia.nocookie.net/naruto/images/e/e7/Sasuke_epi_319.png/revision/latest?cb=20130629210647&path-prefix=pt-br",
                "Sasuke Uchiha",
                "Naruto",
                22114
            ),
            Personagens(
                "https://scontent-gig4-1.xx.fbcdn.net/v/t1.6435-9/53219023_352827398656343_1520396793328697344_n.jpg?stp=dst-jpg_p526x296_tt6&_nc_cat=106&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeHYMPjDbqTByfnFmJlyZ0B-tzGKl9VlQEG3MYqX1WVAQYSxdtNylBaAZjbRmfUEa27-9g6wiiygS-SG9TA2SnhG&_nc_ohc=s-tpUJqoxKkQ7kNvwH_abJk&_nc_oc=Adno-JwhExD6MyWQwe8RfyWOqAsgBc1wInZNi0QhdU2_Ebq8gu6YNL-axLLLUIUq2JOMaW0GrXxt8Zp8_WXRPJhn&_nc_zt=23&_nc_ht=scontent-gig4-1.xx&_nc_gid=qHQkjEq9j-k7BYEiJQWuQA&oh=00_AfTQtJnvuR5edzXrATEKClKRn5FSqApLIu1TTigGgjX_JQ&oe=689DBE22",
                "Yumeko Jabami",
                "Kakegurui",
                18674
            ),
            Personagens(
                "https://ovicio.com.br/wp-content/uploads/2022/09/20220913-ovicio-bleach-ichigo.jpg",
                "Ichigo Kurosaki",
                "Bleach",
                37985
            ),
            Personagens(
                "https://s2-ge.glbimg.com/Yw7BaSksCttx4VucoPo0Cd1jeeQ=/0x0:4000x3033/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2023/v/i/nd1eWjSu2iiQKAbek6Yg/12a4827.jpg",
                "Neymar Jr.",
                "Brasileirão Série A",
                91239
            ),
            Personagens(
                "https://static.wikia.nocookie.net/naruto/images/2/24/Itachi-Uchiha.png/revision/latest/scale-to-width-down/1000?cb=20181104200812&path-prefix=pt-br",
                "Itachi Uchiha",
                "Naruto",
                13423
            ),
            Personagens(
                "https://animeflix.com.br/wp-content/uploads/2025/04/one-piece-luffy-pode-ganhar-dois-aliados-poderosos.jpg",
                "Monkey D. Luffy",
                "One Piece",
                24356
            ),
            Personagens(
                "https://animecomics.com.br/animecomics/images/upload/426.jpg",
                "Light Yagami",
                "Death Note",
                32455
            ),
            Personagens(
                "https://recreio.com.br/wp-content/uploads/2024/05/goku_capa-1.jpg",
                "Goku",
                "Dragon Ball",
                53322
            ),
            Personagens(
                "https://static.wikia.nocookie.net/naruto/images/e/e7/Sasuke_epi_319.png/revision/latest?cb=20130629210647&path-prefix=pt-br",
                "Sasuke Uchiha",
                "Naruto",
                22114
            ),
            Personagens(
                "https://scontent-gig4-1.xx.fbcdn.net/v/t1.6435-9/53219023_352827398656343_1520396793328697344_n.jpg?stp=dst-jpg_p526x296_tt6&_nc_cat=106&ccb=1-7&_nc_sid=6ee11a&_nc_eui2=AeHYMPjDbqTByfnFmJlyZ0B-tzGKl9VlQEG3MYqX1WVAQYSxdtNylBaAZjbRmfUEa27-9g6wiiygS-SG9TA2SnhG&_nc_ohc=s-tpUJqoxKkQ7kNvwH_abJk&_nc_oc=Adno-JwhExD6MyWQwe8RfyWOqAsgBc1wInZNi0QhdU2_Ebq8gu6YNL-axLLLUIUq2JOMaW0GrXxt8Zp8_WXRPJhn&_nc_zt=23&_nc_ht=scontent-gig4-1.xx&_nc_gid=qHQkjEq9j-k7BYEiJQWuQA&oh=00_AfTQtJnvuR5edzXrATEKClKRn5FSqApLIu1TTigGgjX_JQ&oe=689DBE22",
                "Yumeko Jabami",
                "Kakegurui",
                18674
            ),
            Personagens(
                "https://ovicio.com.br/wp-content/uploads/2022/09/20220913-ovicio-bleach-ichigo.jpg",
                "Ichigo Kurosaki",
                "Bleach",
                37985
            )
        )

        adapter = PersonagensAdapter(list)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}